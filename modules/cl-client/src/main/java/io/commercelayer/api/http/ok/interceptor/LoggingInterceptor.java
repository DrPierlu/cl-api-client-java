package io.commercelayer.api.http.ok.interceptor;

import java.io.IOException;

import org.slf4j.Logger;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class LoggingInterceptor implements Interceptor {

	private Logger logger;
	
	
	public LoggingInterceptor(Logger logger) {
		this.logger = logger;
	}
	
	
	@Override
	public Response intercept(Interceptor.Chain chain) throws IOException {
		
		// Request
		Request request = chain.request();

		long t1 = System.nanoTime();
		logger.info(String.format("Sending request to %s", request.url()));
		
		// Response
		Response response = chain.proceed(request);

		long t2 = System.nanoTime();
		logger.info(String.format("Received response from %s in %.1fms", response.request().url(), (t2 - t1) / 1e6d));
		
		return response;
		
	}

}
