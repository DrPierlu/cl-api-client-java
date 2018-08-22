package io.commercelayer.api.http.ok;

import java.io.IOException;
import java.util.Map;

import io.commercelayer.api.config.ApiConfig;
import io.commercelayer.api.config.ApiConfig.Group;
import io.commercelayer.api.http.HttpCallException;
import io.commercelayer.api.http.HttpClient;
import io.commercelayer.api.http.HttpProxy;
import io.commercelayer.api.http.HttpRequest;
import io.commercelayer.api.http.HttpRequest.Header;
import io.commercelayer.api.http.HttpResponse;
import io.commercelayer.api.http.ok.interceptor.LoggingInterceptor;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpClientOkHttpImpl extends HttpClient {

	private final OkHttpClient httpClient;

	HttpClientOkHttpImpl() {
		this(null);
	}

	HttpClientOkHttpImpl(HttpProxy httpProxy) {
		
		OkHttpClientBuilder.Setup setup = new OkHttpClientBuilder.Setup();
		
		// Proxy
		setup.setProxy(httpProxy);
		// Logger
		if (ApiConfig.isPropertyEnabled(Group.http, "debug")) setup.addNetworkInterceptor(new LoggingInterceptor(logger));
		// SSL
		setup.setSslTrustAllEnabled(ApiConfig.getProperty(Group.api, "service.url").startsWith("https://") && ApiConfig.isPropertyEnabled(Group.http, "ssl.trustAll"));
		
		this.httpClient = new OkHttpClientBuilder(setup).build();
		
	}


	private RequestBody getRequestBody(HttpRequest httpRequest) {
		return RequestBody.create(MediaType.parse(httpRequest.getContentType()), httpRequest.getBody());
	}

	public HttpResponse send(HttpRequest httpRequest) throws HttpCallException {

		// REQUEST
		Request.Builder requestBuilder = new Request.Builder().url(httpRequest.getUrl());

		// HTTP Method & Body
		switch (httpRequest.getMethod()) {
			default:
			case GET: { requestBuilder.get(); break; }
			case POST: { requestBuilder.post(getRequestBody(httpRequest)); break; }
			case PUT: { requestBuilder.put(getRequestBody(httpRequest)); break; }
			case DELETE: { requestBuilder.delete(); break; }
		}

		// HTTP Headers
		if (httpRequest.hasHeaders()) {
			for (Map.Entry<String, String> header : httpRequest.getHeaders().entrySet()) {
				requestBuilder.addHeader(header.getKey(), header.getValue());
			}
		}

		if (httpRequest.getHttpAuth() != null) {
			requestBuilder.header(Header.AUTHORIZATION, httpRequest.getHttpAuth().getHttpRequestAuthHeader());
		}

		Request request = requestBuilder.build();

		// RESPONSE
		Response response = null;

		try {
			response = httpClient.newCall(request).execute();
		} catch (IOException ioe) {
			throw new HttpCallException("HTTP Error calling [%s:%s]", httpRequest.getMethod(), httpRequest.getUrl());
		}

		HttpResponse httpResponse = new HttpResponse();

		// HTTP Code
		httpResponse.setCode(response.code());

		// HTTP Headers
		Headers responseHeaders = response.headers();
		for (String hName : responseHeaders.names()) {
			httpResponse.addHeader(hName, responseHeaders.get(hName));
		}

		// HTTP Body
		try {
			httpResponse.setBody(response.body().string());
		} catch (IOException ioe) {
			throw new HttpCallException(String.format("HTTP Error reading body response [%s:%s]", httpRequest.getMethod(), httpRequest.getUrl()));
		}

		// HTTP Content Type
		httpResponse.setContentType(getContentType(response.body().contentType()));

		return httpResponse;

	}

	
	private String getContentType(MediaType mediaType) {
		
		if (mediaType == null) return null;
		
		StringBuilder sb = new StringBuilder(mediaType.type());
		if (mediaType.subtype() != null)
			sb.append('/').append(mediaType.subtype());
		
		return sb.toString();
		
	}

}
