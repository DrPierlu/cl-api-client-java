package io.commercelayer.api.codegen.model.generator;


import java.util.LinkedList;
import java.util.List;

import javax.lang.model.element.Modifier;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;

import io.commercelayer.api.codegen.schema.ApiPath;
import io.commercelayer.api.codegen.schema.ApiSchema;

public final class ModelGeneratorUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(ModelGeneratorUtils.class);
	
	public static final String MODEL_BASE_PACKAGE = "io.commercelayer.api.model";
	
	public static final String[] IGNORED_FIELDS = {
		"reference",
		"metadata",
		"created_at",
		"updated_at",
		"id"
	};

	private ModelGeneratorUtils() {
		
	}
	
	
	public static List<String> getMainResourcePaths(ApiSchema apiSchema) {
		
		logger.info("Reading main resource paths ...");
		
		List<String> mainPaths = new LinkedList<>();
		
		for (ApiPath path : apiSchema.getPaths()) {
			String res = path.getResource();
			if (res.indexOf('/') == res.lastIndexOf('/')) {
				mainPaths.add(res);
				logger.debug(res);
			}
		}
		
		logger.info("Done.");
		
		return mainPaths;
		
	}
	
	public static MethodSpec createMethodSetter(FieldSpec field) {
		
		boolean _start = field.name.startsWith("_");
				
		String methodName = "set".concat(StringUtils.capitalize(field.name.replaceFirst("_", "")));
		if (_start) methodName = methodName.concat("_");
		
		MethodSpec method = MethodSpec.methodBuilder(methodName)
			.addModifiers(Modifier.PUBLIC)
			.addParameter(field.type, field.name)
			.addStatement("this.$N = $L", field, field.name)
			.build();
		
		return method;
		
	}
	
	
	public static MethodSpec createMethodGetter(FieldSpec field) {
		
		boolean _start = field.name.startsWith("_");
		
		String methodName = "get".concat(StringUtils.capitalize(field.name.replaceFirst("_", "")));
		if (_start) methodName = methodName.concat("_");
		
		MethodSpec method = MethodSpec.methodBuilder(methodName)
			.addModifiers(Modifier.PUBLIC)
			.returns(field.type)
			.addStatement("return this.$N", field)
			.build();
		
		return method;
		
	}
	
}
