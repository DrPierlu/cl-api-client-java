package io.commercelayer.api.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.config.ApiConfig;
import io.commercelayer.api.config.ApiConfig.Group;
import io.commercelayer.api.domain.ContentType;
import io.commercelayer.api.http.auth.HttpAuthOAuth2;
import io.commercelayer.api.http.ok.OkHttpClientBuilder;
import io.commercelayer.api.http.ok.interceptor.ContentTypeInterceptor;
import io.commercelayer.api.http.ok.interceptor.OAuth2Interceptor;
import io.commercelayer.api.model.common.ApiOrganization;
import moe.banana.jsonapi2.JsonApiConverterFactory;
import moe.banana.jsonapi2.Resource;
import moe.banana.jsonapi2.ResourceAdapterFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class CLApiClient {

	private static final Logger logger = LoggerFactory.getLogger(CLApiClient.class);

	private static final String PATH_API = ApiConfig.getProperty(Group.api, "service.path");

	private final String apiBaseUrl;
	private final ApiToken apiToken;
	private final OkHttpClient httpClient;


	public CLApiClient(ApiOrganization apiOrg, ApiToken apiToken) {
		this(ApiConfig.getApiBaseUrl(apiOrg).concat(PATH_API), apiToken);
	}
	
	public CLApiClient(String apiBaseUrl, ApiToken apiToken) {

		this.apiBaseUrl = apiBaseUrl;
		this.apiToken = apiToken;
		this.httpClient = buildHttpClient();

		logger.info("Built client for {}", this.apiBaseUrl);

	}
	

	private OkHttpClient buildHttpClient() {

		OkHttpClientBuilder.Setup clientSetup = new OkHttpClientBuilder.Setup();
		clientSetup.setApiBaseUrl(this.apiBaseUrl);

		clientSetup.addInterceptor(new OAuth2Interceptor(new HttpAuthOAuth2(this.apiToken.getAccessToken())));
		clientSetup.addInterceptor(new ContentTypeInterceptor(ContentType.JSON_API));

		return new OkHttpClientBuilder().build();

	}


	@SafeVarargs
	public final <T> T getRawClient(Class<T> service, Class<? extends Resource>... resources) {

		JsonAdapter.Factory jsonApiAdapterFactory = ResourceAdapterFactory.builder().add(resources).build();

		Moshi moshi = new Moshi.Builder()
			.add(jsonApiAdapterFactory)
			.build();

		Retrofit retrofit = new Retrofit.Builder()
			.baseUrl(this.apiBaseUrl)
			.client(this.httpClient)
			.addConverterFactory(JsonApiConverterFactory.create(moshi))
			.build();

		return retrofit.create(service);

	}

}
