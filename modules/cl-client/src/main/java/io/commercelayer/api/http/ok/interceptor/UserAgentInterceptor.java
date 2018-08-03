package io.commercelayer.api.http.ok.interceptor;

import java.io.IOException;

import io.commercelayer.api.http.HttpRequest;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class UserAgentInterceptor implements Interceptor {
	
	private final String userAgent;
	
	public UserAgentInterceptor(String userAgent) {
		this.userAgent = userAgent;
	}

	@Override
	public Response intercept(Chain chain) throws IOException {
		
		Request originalRequest = chain.request();

        Request.Builder builder = originalRequest.newBuilder()
        	.header(HttpRequest.Header.USER_AGENT, userAgent);
        
        Request newRequest = builder.build();
        
        return chain.proceed(newRequest);
		
	}

}
