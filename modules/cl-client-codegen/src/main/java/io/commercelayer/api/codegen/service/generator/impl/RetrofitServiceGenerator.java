package io.commercelayer.api.codegen.service.generator.impl;

import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.lang.model.element.Modifier;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import io.commercelayer.api.codegen.CodegenConfig;
import io.commercelayer.api.codegen.CodegenConfig.Module;
import io.commercelayer.api.codegen.model.generator.ModelGeneratorUtils;
import io.commercelayer.api.codegen.schema.ApiOperation;
import io.commercelayer.api.codegen.schema.ApiParameter;
import io.commercelayer.api.codegen.schema.ApiPath;
import io.commercelayer.api.codegen.schema.ApiSchema;
import io.commercelayer.api.codegen.service.ApiService;
import io.commercelayer.api.codegen.service.generator.ServiceException;
import io.commercelayer.api.codegen.service.generator.ServiceGenerator;
import io.commercelayer.api.codegen.service.generator.ServiceGeneratorUtils;
import io.commercelayer.api.domain.OperationType;
import io.commercelayer.api.util.CLInflector;
import retrofit2.http.Body;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public class RetrofitServiceGenerator implements ServiceGenerator {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public ApiService generate(ApiSchema apiSchema) throws ServiceException {

		ApiService apiService = new ApiService(getServiceBasePackage());

		List<String> mainPaths = ModelGeneratorUtils.getMainResourcePaths(apiSchema);

		logger.info("Analizing main paths ...");
		for (String mainRes : mainPaths) {

			SortedSet<ApiPath> servicePaths = new TreeSet<>();

			for (ApiPath path : apiSchema.getPaths()) {
				if (path.getResource().startsWith(mainRes))
					servicePaths.add(path);
			}

			TypeSpec service = createService(mainRes, servicePaths);
			apiService.addClass(service);

		}

		return apiService;

	}

	private TypeSpec createService(String mainRes, SortedSet<ApiPath> paths) throws ServiceException {
		
		final String resourceName = CLInflector.getInstance().singularize(StringUtils.capitalize(ModelGeneratorUtils.toCamelCase(mainRes.substring(1))));
		final String serviceName = String.format("%sService", resourceName);
		
		TypeSpec.Builder service = TypeSpec.interfaceBuilder(serviceName).addModifiers(Modifier.PUBLIC);
		
		logger.info("Generating Service Interface [{}]", serviceName);
		
		for (ApiPath path : paths) {
			for (Map.Entry<OperationType, ApiOperation> ope : path.getOperations().entrySet()) {
				
				final ApiOperation op = ope.getValue();
				final String serOpName = ServiceGeneratorUtils.getServiceOperationName(ope.getKey(), path.getResource());
				
				MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder(serOpName)
					.addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
					.returns(getOperationReturnType(path.getResource(), op));
				
				// Path Parameters
				for (ApiParameter p : op.getParameters()) {
					methodBuilder.addParameter(
						ParameterSpec.builder(p.getType().getClass(), p.getName())
							.addAnnotation(AnnotationSpec.builder(Path.class).addMember("value", "$S", p.getName()).build())
							.build()
					);
				}
				
				// Operation Annotation
				String resPath = path.getResource();
				if (CodegenConfig.isPropertyEnabled(Module.Service, "resource.path.relative")) resPath = resPath.replaceFirst("/", "");
				methodBuilder.addAnnotation(
					AnnotationSpec.builder(ServiceGeneratorUtils.getOperationAnnotation(op))
						.addMember("value", "$S", resPath)
						.build()
				);
				
				// Body Parameter
				if (op.hasRequestBody()) {
					methodBuilder.addParameter(
						ParameterSpec.builder(
							ClassName.get(ModelGeneratorUtils.MODEL_BASE_PACKAGE, resourceName),
							ServiceGeneratorUtils.unreserve(StringUtils.uncapitalize(resourceName))
						)
						.addAnnotation(AnnotationSpec.builder(Body.class).build())
						.build()
					);
				}
				
				// QueryMap Parameter for filters and sparse fieldset
//				if (OperationType.GET.equals(op.getType())) {
				if (!OperationType.DELETE.equals(op.getType())) {
					
					// Add overloaded method without filter parameters
					service.addMethod(methodBuilder.build());
					
					// Add a new method with filter
					methodBuilder.addParameter(
						ParameterSpec.builder(ParameterizedTypeName.get(Map.class, String.class, String.class), "queryStringParams")
							.addAnnotation(AnnotationSpec.builder(QueryMap.class).build())
						.build()
					);
					
				}
				

				service.addMethod(methodBuilder.build());
				
				logger.info("    Created Operation Interface [{}]", serOpName);
				
			}
		}
		
		logger.info("Service Interface generated [{}]", serviceName);
		
		return service.build();
		
	}
	
	
	protected TypeName getOperationReturnType(String resourcePath, ApiOperation operation) {
		return ServiceGeneratorUtils.getOperationReturnType(resourcePath, operation);
	}
	
	protected String getServiceBasePackage() {
		return ServiceGeneratorUtils.SERVICE_BASE_PACKAGE;
	}

}
