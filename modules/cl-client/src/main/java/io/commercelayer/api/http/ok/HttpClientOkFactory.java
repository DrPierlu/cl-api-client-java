package io.commercelayer.api.http.ok;

import io.commercelayer.api.http.HttpClient;
import io.commercelayer.api.http.HttpProxy;

public final class HttpClientOkFactory {
	
	private HttpClientOkFactory() {
		super();
	}

	public static HttpClient newHttpClientInstance() {
		return new HttpClientOkHttpImpl();
	}
	
	public static HttpClient newHttpClientInstance(HttpProxy httpProxy) {
		return new HttpClientOkHttpImpl(httpProxy);
	}
	
}
