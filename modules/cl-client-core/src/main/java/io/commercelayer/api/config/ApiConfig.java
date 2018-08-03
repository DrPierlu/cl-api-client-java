package io.commercelayer.api.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.util.LogUtils;

public final class ApiConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(ApiConfig.class);
	
	public static enum Group {
		api, http, test
	}
	
	private static Properties settings = new Properties();
	
	static {
		loadConfiguration();
	}
	
	
	private static void loadConfiguration() {
		
		InputStream configStream = ClassLoader.class.getResourceAsStream("/META-INF/settings.properties");
		
		try {
			settings.load(configStream);
		} catch (IOException ioe) {
			logger.error(LogUtils.printStackTrace(ioe));
		}
		
	}


	
	public static String getProperty(String key) {
		return (key == null)? null : settings.getProperty(key);
	}
	
	public static String getProperty(Group group, String key) {
		return getProperty(group.name() + '.' + key);
	}
	
	public static Boolean isPropertyEnabled(String key) {
		return Boolean.valueOf(getProperty(key));
	}
	
	public static Boolean isPropertyEnabled(Group group, String key) {
		return Boolean.valueOf(getProperty(group, key));
	}
	
	public static boolean testModeEnabled() {
		return ApiConfig.isPropertyEnabled(Group.test, "mode");
	}
	
	public static String getApiBaseUrl() {
		String url = ApiConfig.getProperty(Group.api, "service.url");
		if ((url != null) && url.endsWith("/")) url = url.substring(0, url.lastIndexOf('/'));
		return url;
		
	}
	
	public static String getApiBaseUrl(ApiOrganization apiOrg) {
		return getApiBaseUrl(apiOrg.getSubdomain());
	}
	
	public static String getApiBaseUrl(String subdomain) {
		String url = ApiConfig.getProperty(Group.api, "service.url");
		if (subdomain != null) url = url.replaceFirst("\\{subdomain\\}", subdomain);
		if (url.endsWith("/")) url = url.substring(0, url.lastIndexOf('/'));
		return url;
		
	}

}
