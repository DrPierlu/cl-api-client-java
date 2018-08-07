package io.commercelayer.api.codegen.service.generator;

import java.awt.List;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;

import io.commercelayer.api.codegen.model.generator.ModelGeneratorUtils;
import io.commercelayer.api.codegen.schema.ApiOperation;
import io.commercelayer.api.domain.OperationType;
import io.commercelayer.api.util.CLInflector;
import io.commercelayer.api.util.Inflector;
import io.commercelayer.api.util.ModelUtils;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

public final class ServiceGeneratorUtils {
	
	public static final String SERVICE_BASE_PACKAGE = "io.commercelayer.api.service";
	
	// Service Operation prefix remapping configuration
	private static final Map<String, String> SERVICE_OP_PREFIX = new HashMap<>();
	static {
		SERVICE_OP_PREFIX.put("retrieve", "retrieve");
		SERVICE_OP_PREFIX.put("list", "list");
		SERVICE_OP_PREFIX.put("update", "update");
		SERVICE_OP_PREFIX.put("create", "create");
		SERVICE_OP_PREFIX.put("delete", "delete");
	}
	
	
	private ServiceGeneratorUtils() {
		
	}
	
	public static String getServiceOperationName(OperationType opType, String resourcePath) {
		
		String func = null;
		boolean byId = resourcePath.endsWith("Id}");
		boolean listRes = resourcePath.endsWith("s") && !resourcePath.endsWith("ss");
		
		switch (opType) {
			case GET: {
				func = byId || !listRes? "retrieve" : "list";
				break;
			}
			case PATCH: {
				func = "update";
				break;
			}
			case POST: {
				func = "create";
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
			trName = trName.concat(StringUtils.capitalize(ModelUtils.toCamelCase(p_)));
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
	
	public static TypeName getOperationReturnType(String resourcePath, ApiOperation op) throws ServiceException {
		
		if (OperationType.DELETE.equals(op.getType())) return ParameterizedTypeName.get(Call.class, Void.class);
		
		final Inflector inflector = CLInflector.getInstance();
		
		String res = resourcePath.substring(resourcePath.lastIndexOf('/')+1);
		boolean byId = false;
		
		if (res.endsWith("Id}")) {
			res = resourcePath.substring(1, resourcePath.lastIndexOf('/'));
			byId = true;
		}
		
		res = res.substring(res.lastIndexOf('/')+1);
		res = inflector.upperCamelCase(res);
		String resSing = inflector.singularize(res);
		
		TypeName typeArgument = ClassName.get(ModelGeneratorUtils.MODEL_BASE_PACKAGE, resSing);
		if (OperationType.GET.equals(op.getType()) && !res.equals(resSing) && !byId) typeArgument = ParameterizedTypeName.get(ClassName.get(List.class), typeArgument);
		
		TypeName resourceType = ParameterizedTypeName.get(ClassName.get(Call.class), typeArgument);
		
		return resourceType;
		
	}

}
