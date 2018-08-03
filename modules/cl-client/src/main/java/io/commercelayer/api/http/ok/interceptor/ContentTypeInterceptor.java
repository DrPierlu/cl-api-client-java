package io.commercelayer.api.http.ok.interceptor;

import java.io.IOException;

import io.commercelayer.api.http.HttpRequest;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ContentTypeInterceptor implements Interceptor {
	
	private final String contentType;
	
	public ContentTypeInterceptor(String contentType) {
		super();
		this.contentType = contentType;
	}

	@Override
	public Response intercept(Chain chain) throws IOException {
		
		Request originalRequest = chain.request();

        Request.Builder builder = originalRequest.newBuilder()
        	.header(HttpRequest.Header.CONTENT_TYPE, contentType)
        	.header(HttpRequest.Header.ACCEPT, contentType);
        
        Request newRequest = builder.build();
        
        return chain.proceed(newRequest);
		
	}

}
