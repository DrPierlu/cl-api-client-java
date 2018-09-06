package io.commercelayer.api.codegen.model.generator;


import java.util.LinkedList;
import java.util.List;

import javax.lang.model.element.Modifier;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;

import io.commercelayer.api.codegen.CodegenConfig;
import io.commercelayer.api.codegen.CodegenConfig.Module;
import io.commercelayer.api.codegen.schema.ApiPath;
import io.commercelayer.api.codegen.schema.ApiSchema;

public final class ModelGeneratorUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(ModelGeneratorUtils.class);
	
	public static final String 		MODEL_BASE_PACKAGE;	
	public static final String[] 	MODEL_IGNORED_FIELDS;

	static {
		
		// MODEL_BASE_PACKAGE
		MODEL_BASE_PACKAGE = CodegenConfig.getProperty(Module.Model, "base.package");
		
		// IGNORED_FIELDS
		String propIgnoredFields = CodegenConfig.getProperty(Module.Model, "ignored.fields");
		if (StringUtils.isNotBlank(propIgnoredFields)) {
			String[] fields = propIgnoredFields.split("[,;|]");
			if (fields != null) MODEL_IGNORED_FIELDS = fields;
			else MODEL_IGNORED_FIELDS = new String[0];
		}
		else MODEL_IGNORED_FIELDS = new String[0];
		
	}

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
	
	public static String toCamelCase(String strWith_) {
	
		if (StringUtils.isBlank(strWith_)) return strWith_;
		
		String prefix = strWith_.startsWith("_")? "_" : "";
		String cap = WordUtils.capitalize(strWith_, '_').replaceAll("_", "");
		char c[] = cap.toCharArray();
		c[0] = Character.toLowerCase(c[0]);
		cap = new String(c);
		
		return prefix.concat(cap);
		
	}
	
}
