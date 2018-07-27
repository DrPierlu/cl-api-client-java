package io.commercelayer.api.http;

import io.commercelayer.api.http.ok.HttpClientOkFactory;

public final class HttpClientFactory {

	public static HttpClient getHttpClientInstance() {
		return HttpClientOkFactory.newHttpClientInstance();
	}

	public static HttpClient getHttpClientInstance(HttpProxy httpProxy) {
		return HttpClientOkFactory.newHttpClientInstance(httpProxy);
	}

	private HttpClientFactory() {

	}

}
