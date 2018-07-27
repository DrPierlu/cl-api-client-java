package io.commercelayer.api.http.trace;

import io.commercelayer.api.domain.ContentType;
import io.commercelayer.api.exception.ConnectionException;
import io.commercelayer.api.http.HttpClient;
import io.commercelayer.api.http.HttpRequest;
import io.commercelayer.api.http.HttpResponse;

public class HttpClientTrace extends HttpClient {
	
	@Override
	public HttpResponse send(HttpRequest request) throws ConnectionException {
		
		logger.debug("********** HttpClientTrace.HttpRequest **********");
		
		logger.debug("{} {}{}", request.getMethod(), request.getUrl(), getQueryString(request, true));
		
		logger.debug("Headers:");
		logger.debug(request.printHeaders());
		
		logger.debug("Body ({}):", request.getContentType());
		logger.debug("\n{}", request.getBody());
		
		logger.debug("*************************************************");
		
		HttpResponse response = new HttpResponse();
		
		response.setCode(200);
		response.setContentType(ContentType.JSON);
		response.setBody(request.getBody());
		
		return response;
		
	}

}
