package io.commercelayer.api.http;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.commercelayer.api.exception.ConnectionException;

public abstract class HttpClient {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	
	public abstract HttpResponse send(HttpRequest httpRequest) throws ConnectionException;


	protected String getQueryString(HttpRequest httpRequest, boolean withQuestionMark) {

		StringBuilder sb = new StringBuilder();

		if (httpRequest.hasQueryStringParams()) {
			for (Map.Entry<String, String> param : httpRequest.getQueryStringParams().entrySet()) {
				if (sb.length() == 0) {
					if (withQuestionMark)
						sb.append('?');
				} else {
					sb.append('&');
				}
				sb.append(param.getKey()).append('=').append(param.getValue());
			}
		}

		return sb.toString();

	}
	
}
