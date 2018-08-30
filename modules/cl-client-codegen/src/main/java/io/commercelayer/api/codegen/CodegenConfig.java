package io.commercelayer.api.codegen;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.commercelayer.api.util.LogUtils;

public final class CodegenConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(CodegenConfig.class);
	
	private static Properties settings = new Properties();
	
	static {
		loadConfiguration();
	}
	
	
	private static void loadConfiguration() {
		
		InputStream configStream = CodegenConfig.class.getResourceAsStream("codegen.properties");
		
		try {
			settings.load(configStream);
		} catch (IOException ioe) {
			logger.error(LogUtils.printStackTrace(ioe));
		}
		
	}


	public static String getProperty(String key) {
		return (key == null)? null : settings.getProperty(key);
	}
	
	public static String getProperty(Module module, String subKey) {
		return ((module == null) || (subKey == null))? null : settings.getProperty(module.code().concat(".").concat(subKey));
	}
	
	public static boolean isPropertyEnabled(Module module, String key) {
		return Boolean.parseBoolean(getProperty(module, key));
	}
	
	public static boolean isPropertyEnabled(String key) {
		return Boolean.parseBoolean(getProperty(key));
	}
	
	public static String mapModelResource(String resName) {
		String remap = getProperty(Module.Model, "resource.mapping.".concat(resName));
		return (StringUtils.isBlank(remap))? resName : remap;
	}
	
	
	// Codegen Modules
	public static enum Module {
		Schema("schema"),
		Model("model"),
		Service("service"),
		Test("test"),
		Source("source");
		
		private String code;
		
		private Module(String code) {
			this.code = code;
		}
		
		public String code() {
			return this.code;
		}
		
	}
	
}
