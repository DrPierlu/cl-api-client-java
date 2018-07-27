package io.commercelayer.api.client;

import java.util.LinkedHashMap;
import java.util.Map;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import io.commercelayer.api.auth.ApiOrganization;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.config.ApiConfig;
import io.commercelayer.api.http.auth.HttpAuthOAuth2;
import io.commercelayer.api.http.ok.OkHttpClientBuilder;
import io.commercelayer.api.http.ok.interceptor.OAuth2Interceptor;
import io.commercelayer.api.service.CLApiService;
import moe.banana.jsonapi2.JsonApiConverterFactory;
import moe.banana.jsonapi2.Resource;
import moe.banana.jsonapi2.ResourceAdapterFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class CLApiClient {
	
	private final String apiBaseUrl;
	private final ApiToken apiToken;
	private final OkHttpClient httpClient;
	
	private Map<String, String> queryStringParams;
	
	
	public CLApiClient(ApiOrganization apiOrg, ApiToken apiToken) {
		this.apiBaseUrl = ApiConfig.getApiBaseUrl(apiOrg.getSubdomain());
		this.apiToken = apiToken;
		this.httpClient = buildHttpClient();
	}
	
	
	private OkHttpClient buildHttpClient() {
		
		OkHttpClientBuilder.Setup clientSetup = new OkHttpClientBuilder.Setup();
		clientSetup.setApiBaseUrl(this.apiBaseUrl);
		
		clientSetup.addInterceptor(new OAuth2Interceptor(new HttpAuthOAuth2(this.apiToken.getAccessToken())));
		
		return new OkHttpClientBuilder().build();
		
	}

	
	public Map<String, String> getQueryStringParams() {
		return queryStringParams;
	}

	public void setQueryStringParams(Map<String, String> queryStringParams) {
		this.queryStringParams = queryStringParams;
	}
	
	public Map<String, String> addQueryStringParam(String key, String value) {
		if (this.queryStringParams == null) this.queryStringParams = new LinkedHashMap<>();
		this.queryStringParams.put(key, value);
		return this.queryStringParams;
	}
	
	@SuppressWarnings("unchecked")
	public CLApiService getRawClient(Class<? extends Resource>... resourceClasses) {
		
		JsonAdapter.Factory jsonApiAdapterFactory = ResourceAdapterFactory.builder()
	        .add(resourceClasses)
	        .build();
		
		Moshi moshi = new Moshi.Builder()
	        .add(jsonApiAdapterFactory)
	        .build();
		
		Retrofit retrofit = new Retrofit.Builder()
		    .baseUrl(this.apiBaseUrl)
		    .client(this.httpClient)
		    .addConverterFactory(JsonApiConverterFactory.create(moshi))
		    .build();
		
		CLApiService clApi = retrofit.create(CLApiService.class);
		
		return clApi;
		
	}

}
