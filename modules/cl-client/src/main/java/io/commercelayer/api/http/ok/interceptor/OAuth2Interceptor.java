package io.commercelayer.api.http.ok.interceptor;

import java.io.IOException;

import io.commercelayer.api.http.HttpRequest;
import io.commercelayer.api.http.auth.HttpAuthOAuth2;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class OAuth2Interceptor implements Interceptor {

	private HttpAuthOAuth2 httpAuth;
	
	public OAuth2Interceptor(HttpAuthOAuth2 httpAuth) {
		super();
		this.httpAuth = httpAuth;
	}
	
	@Override
	public Response intercept(Chain chain) throws IOException {
		
		 Request originalRequest = chain.request();

         Request.Builder builder = originalRequest.newBuilder().header(HttpRequest.Header.AUTHORIZATION, httpAuth.getHttpRequestAuthHeader());

         Request newRequest = builder.build();
         
         return chain.proceed(newRequest);
		
	}

}
