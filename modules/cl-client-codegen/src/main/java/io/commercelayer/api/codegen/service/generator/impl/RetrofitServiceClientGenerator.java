package io.commercelayer.api.codegen.service.generator.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.lang.model.element.Modifier;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
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
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.util.CLInflector;

public class RetrofitServiceClientGenerator implements ServiceGenerator {

	private static final Logger logger = LoggerFactory.getLogger(RetrofitServiceClientGenerator.class);

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

			TypeSpec service = createServiceClient(mainRes, servicePaths);
			apiService.addClass(service);

		}

		return apiService;

	}

	
	private TypeSpec createServiceClient(String mainRes, SortedSet<ApiPath> paths) throws ServiceException {
		
		final String resourceName = CLInflector.getInstance().singularize(StringUtils.capitalize(ModelGeneratorUtils.toCamelCase(mainRes.substring(1))));
		final String serviceName = String.format("%sServiceClient", resourceName);
		
		TypeSpec.Builder service = TypeSpec.classBuilder(serviceName)
			.addModifiers(Modifier.PUBLIC)
			.superclass(AbstractServiceClient.class);
		
		final ClassName serviceClassName = ClassName.get(ServiceGeneratorUtils.SERVICE_BASE_PACKAGE, String.format("%sService", resourceName));
		final ClassName resourceClassName = ClassName.get(ModelGeneratorUtils.MODEL_BASE_PACKAGE, resourceName);
		
		// Service client field
		createServiceField(service, serviceClassName, resourceClassName);
		// Class constructors
		createConstructors(service, serviceClassName, resourceClassName);
		
		
		logger.info("Generating ServiceClient Class [{}]", serviceName);
		
		for (ApiPath path : paths) {
			for (Map.Entry<OperationType, ApiOperation> ope : path.getOperations().entrySet()) {
				
				final ApiOperation op = ope.getValue();
				final String serOpName = ServiceGeneratorUtils.getServiceOperationName(ope.getKey(), path.getResource());
				
				// Method with QueryMap Parameter for filters and sparse fieldset
				MethodSpec methodOpSync = createSyncMethod(serOpName, op, path, resourceName, true);
				service.addMethod(methodOpSync);
				
				MethodSpec methodOpAsync = createAsyncMethod(serOpName, op, path, resourceName, true);
				service.addMethod(methodOpAsync);
				
				// Overload Method
				if (OperationType.GET.equals(op.getType())) {
					
					MethodSpec methodOpSyncOverload = createSyncMethod(serOpName, op, path, resourceName, false);
					service.addMethod(methodOpSyncOverload);
					
					MethodSpec methodOpAsyncOverload = createAsyncMethod(serOpName, op, path, resourceName, false);
					service.addMethod(methodOpAsyncOverload);
					
				}
								
				logger.info("    Created Operation Interface [{}]", serOpName);
				
			}
		}
		
		logger.info("ServiceClient Class generated [{}]", serviceName);
		
		return service.build();
		
	}
	
	
	protected TypeName getOperationReturnType(String resourcePath, ApiOperation operation) {
		return ServiceGeneratorUtils.getOperationReturnTypeArgument(resourcePath, operation);
	}
	
	protected String getServiceBasePackage() {
		return ServiceGeneratorUtils.SERVICE_CLIENT_BASE_PACKAGE;
	}
	
	
	private MethodSpec createSyncMethod(String operationName, ApiOperation op, ApiPath path, String resourceName, boolean qsParams) {
		
		final List<String> methodParams = new LinkedList<>();
		
		final TypeName retType = getOperationReturnType(path.getResource(), op);
		
		MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder(operationName)
			.addModifiers(Modifier.PUBLIC)
			.addException(ApiException.class)
			.returns(retType.equals(TypeName.get(Void.class))? TypeName.get(void.class) : retType);
		
		// Path Parameters
		for (ApiParameter p : op.getParameters()) {
			methodBuilder.addParameter(
				ParameterSpec.builder(p.getType().getClass(), p.getName()).build()
			);
			methodParams.add(p.getName());
		}
		
		// Body Parameter
		if (op.hasRequestBody()) {
			String pName = StringUtils.uncapitalize(resourceName);
			methodBuilder.addParameter(
				ParameterSpec.builder(ClassName.get(ModelGeneratorUtils.MODEL_BASE_PACKAGE, resourceName), pName).build()
			);
			methodParams.add(pName);
		}
		
		if (OperationType.GET.equals(op.getType()) && qsParams) {
			final String qsParamName = "queryStringParams";
			methodBuilder.addParameter(
				ParameterSpec.builder(ParameterizedTypeName.get(Map.class, String.class, String.class), qsParamName).build()
			);
			methodParams.add(qsParamName);
		}
		
		CodeBlock methodBody = CodeBlock.builder()
				.addStatement("$T call = service.$L($L)", ServiceGeneratorUtils.getOperationReturnType(retType), operationName, StringUtils.join(methodParams, ", "))
				.addStatement("$LsyncCall(call)", (OperationType.DELETE.equals(op.getType())? "" : "return "))
				.build();
		methodBuilder.addCode(methodBody);
		
		return methodBuilder.build();
		
	}

	
	private MethodSpec createAsyncMethod(String operationName, ApiOperation op, ApiPath path, String resourceName, boolean qsParams) {
		
		final List<String> methodParams = new LinkedList<>();
		
		final TypeName retType = getOperationReturnType(path.getResource(), op);
		
		MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder(operationName).addModifiers(Modifier.PUBLIC);
		
		// Path Parameters
		for (ApiParameter p : op.getParameters()) {
			methodBuilder.addParameter(
				ParameterSpec.builder(p.getType().getClass(), p.getName()).build()
			);
			methodParams.add(p.getName());
		}
		
		// Body Parameter
		if (op.hasRequestBody()) {
			String pName = StringUtils.uncapitalize(resourceName);
			methodBuilder.addParameter(
				ParameterSpec.builder(ClassName.get(ModelGeneratorUtils.MODEL_BASE_PACKAGE, resourceName), pName).build()
			);
			methodParams.add(pName);
		}
		
		// QueryString Param Map
		if (OperationType.GET.equals(op.getType()) && qsParams) {
			final String qsParamName = "queryStringParams";
			methodBuilder.addParameter(
				ParameterSpec.builder(ParameterizedTypeName.get(Map.class, String.class, String.class), qsParamName).build()
			);
			methodParams.add(qsParamName);
		}
		
		// Callback Param
		methodBuilder.addParameter(ParameterizedTypeName.get(ClassName.get(ApiCallback.class), getOperationReturnType(path.getResource(), op)), "callback");
		
		CodeBlock methodBodyOverload = CodeBlock.builder()
				.addStatement("$T call = service.$L($L)", ServiceGeneratorUtils.getOperationReturnType(retType), operationName, StringUtils.join(methodParams, ", "))
				.addStatement("asyncCall(call, callback)")
				.build();
		methodBuilder.addCode(methodBodyOverload);
		
		return methodBuilder.build();
		
	}
	
	
	private void createServiceField(TypeSpec.Builder service, ClassName serviceClassName, ClassName resourceClassName) {
		
		FieldSpec.Builder field = FieldSpec.builder(serviceClassName, "service", Modifier.PROTECTED, Modifier.FINAL);
		service.addField(field.build());
		
		CodeBlock initBlock = CodeBlock.builder().addStatement("this.service = initServiceCallFactory($T.class, $T.class)", serviceClassName, resourceClassName).build();
		service.addInitializerBlock(initBlock);
		
	}
	
	private void createConstructors(TypeSpec.Builder service, ClassName serviceClassName, ClassName resourceClassName) {
		
		MethodSpec constAuth = MethodSpec.constructorBuilder()
		    .addModifiers(Modifier.PUBLIC)
		    .addException(AuthException.class)
		    .addParameter(ApiOrganization.class, "apiOrg")
		    .addParameter(ApiAuth.class, "apiAuth")
		    .addStatement("super(apiOrg, apiAuth)")
//		    .addStatement("this.service = apiCaller.getServiceCallFactory($T.class, $T.class)", serviceClassName, resourceClassName)
		    .build();
		
		service.addMethod(constAuth);
		
		
		MethodSpec constToken = MethodSpec.constructorBuilder()
		    .addModifiers(Modifier.PUBLIC)
		    .addException(AuthException.class)
		    .addParameter(ApiOrganization.class, "apiOrg")
		    .addParameter(ApiToken.class, "apiToken")
		    .addStatement("super(apiOrg, apiToken)")
//		    .addStatement("this.service = apiCaller.getServiceCallFactory($T.class, $T.class)", serviceClassName, resourceClassName)
		    .build();
		
		service.addMethod(constToken);
		
	}
	
}
