package io.commercelayer.api.http.ok;

import okhttp3.logging.HttpLoggingInterceptor.Logger;

public class HttpLogger implements Logger {

	private org.slf4j.Logger logger;
	
	public HttpLogger(org.slf4j.Logger logger) {
		this.logger = logger;
	}
	
	@Override
	public void log(String message) {
		logger.info(message);
	}

}
