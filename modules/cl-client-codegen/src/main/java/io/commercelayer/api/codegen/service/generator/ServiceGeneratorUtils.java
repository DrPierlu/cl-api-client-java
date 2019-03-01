package io.commercelayer.api.codegen.service.generator;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.lang.model.SourceVersion;

import org.apache.commons.lang3.StringUtils;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;

import io.commercelayer.api.codegen.CodegenConfig;
import io.commercelayer.api.codegen.CodegenConfig.Module;
import io.commercelayer.api.codegen.model.generator.ModelGeneratorUtils;
import io.commercelayer.api.codegen.schema.ApiOperation;
import io.commercelayer.api.domain.OperationType;
import io.commercelayer.api.util.CLInflector;
import io.commercelayer.api.util.Inflector;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

public final class ServiceGeneratorUtils {
	
	public static final String SERVICE_BASE_PACKAGE;
	public static final String SERVICE_CLIENT_BASE_PACKAGE;
	
	// Service Operation prefix remapping configuration
	private static final Map<String, String> SERVICE_OP_PREFIX = new HashMap<>();
	
	static {
		
		// SERVICE_BASE_PACKAGE
		SERVICE_BASE_PACKAGE = CodegenConfig.getProperty(Module.Service, "base.package");
		// SERVICE_CLIENT_BASE_PACKAGE
		SERVICE_CLIENT_BASE_PACKAGE = CodegenConfig.getProperty(Module.Service, "client.base.package");
		
		// SERVICE_OP_PREFIX		
//		SERVICE_OP_PREFIX.put(ServiceOperation.retrieve.name(), 	CodegenConfig.getProperty(Module.Service, "operation.prefix.retrieve"));
//		SERVICE_OP_PREFIX.put(ServiceOperation.list.name(), 		CodegenConfig.getProperty(Module.Service, "operation.prefix.list"));
//		SERVICE_OP_PREFIX.put(ServiceOperation.update.name(), 		CodegenConfig.getProperty(Module.Service, "operation.prefix.update"));
//		SERVICE_OP_PREFIX.put(ServiceOperation.create.name(), 		CodegenConfig.getProperty(Module.Service, "operation.prefix.create"));
//		SERVICE_OP_PREFIX.put(ServiceOperation.delete.name(), 		CodegenConfig.getProperty(Module.Service, "operation.prefix.delete"));
		for (ServiceOperation so : ServiceOperation.values()) {
			SERVICE_OP_PREFIX.put(so.name(), CodegenConfig.getProperty(Module.Service, String.format("operation.prefix.%s", so.name())));
		}
		
	}
	
	
	private ServiceGeneratorUtils() {
		
	}
	
	public static String getServiceOperationName(OperationType opType, String resourcePath) {
		
		String func = null;
		boolean byId = resourcePath.endsWith("Id}");
		boolean listRes = resourcePath.endsWith("s") && !resourcePath.endsWith("ss");
		
		switch (opType) {
			case GET: {
				func = byId || !listRes? ServiceOperation.retrieve.name() : ServiceOperation.list.name();
				break;
			}
			case PATCH: {
				func = ServiceOperation.update.name();
				break;
			}
			case POST: {
				func = ServiceOperation.create.name();
				break;
			}
			default: {
				func = opType.code().toLowerCase();
				break;
			}
		}
		
		String trName = SERVICE_OP_PREFIX.containsKey(func)? SERVICE_OP_PREFIX.get(func) : func;
		String[] pts = resourcePath.split("/");
		
		int pIdx = 0;
		for (String p : pts) {
			pIdx++;
			if (p.contains("{")) continue;
			String p_ = p;
			if (!OperationType.GET.equals(opType) || byId || (pIdx < pts.length)) p_ = CLInflector.getInstance().singularize(p_);
			trName = trName.concat(StringUtils.capitalize(ModelGeneratorUtils.toCamelCase(p_)));
		}
		
		return trName;
		
	}
	
	
	public static Class<? extends Annotation> getOperationAnnotation(ApiOperation op) throws ServiceException {
		
		switch (op.getType()) {
			case GET: return GET.class;
			case PATCH: return PATCH.class;
			case POST: return POST.class;
			case DELETE: return DELETE.class;
			default: throw new ServiceException(String.format("Unsupported OperationType %s", op.getType().code()));
		}
		
	}
	
	
	public static TypeName getOperationReturnTypeArgument(String resourcePath, ApiOperation operation) {
		
		if (OperationType.DELETE.equals(operation.getType())) return TypeName.get(Void.class);
		
		final Inflector inflector = CLInflector.getInstance();
		
		String res = resourcePath.substring(resourcePath.lastIndexOf('/')+1);
		boolean byId = false;
		
		if (res.endsWith("Id}")) {
			res = resourcePath.substring(1, resourcePath.lastIndexOf('/'));
			byId = true;
		}
		
		res = res.substring(res.lastIndexOf('/')+1);
		res = inflector.upperCamelCase(res);
		final String resSing = inflector.singularize(res);
		final String resSingRemapped = CodegenConfig.mapModelResource(resSing);
		
		TypeName typeArgument = ClassName.get(ModelGeneratorUtils.MODEL_BASE_PACKAGE, resSingRemapped);
		if (OperationType.GET.equals(operation.getType()) && !res.equals(resSingRemapped) && !byId) typeArgument = ParameterizedTypeName.get(ClassName.get(List.class), typeArgument);
		
		return typeArgument;
		
	}
	
	
	public static TypeName getOperationReturnType(String resourcePath, ApiOperation operation) {
		TypeName typeArgument = getOperationReturnTypeArgument(resourcePath, operation);
		return ParameterizedTypeName.get(ClassName.get(Call.class), typeArgument);
	}
	
	
	public static TypeName getOperationReturnType(TypeName typeArgument) {
		return ParameterizedTypeName.get(ClassName.get(Call.class), typeArgument);
	}
	
	public static String unreserve(String keyword) {
		return SourceVersion.isKeyword(keyword)? keyword.concat("_") : keyword;
	}

}
