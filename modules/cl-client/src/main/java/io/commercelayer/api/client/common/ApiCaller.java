package io.commercelayer.api.client.common;

import java.io.IOException;
import java.lang.reflect.Field;
import java.time.ZonedDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.exception.ConnectionException;
import io.commercelayer.api.config.ApiConfig;
import io.commercelayer.api.config.ApiConfig.Group;
import io.commercelayer.api.config.ApiConstants;
import io.commercelayer.api.domain.ContentType;
import io.commercelayer.api.exception.ApiException;
import io.commercelayer.api.http.auth.HttpAuthOAuth2;
import io.commercelayer.api.http.ok.HttpLogger;
import io.commercelayer.api.http.ok.OkHttpClientBuilder;
import io.commercelayer.api.http.ok.interceptor.ContentTypeInterceptor;
import io.commercelayer.api.http.ok.interceptor.OAuth2Interceptor;
import io.commercelayer.api.model.adapter.BooleanAdapter;
import io.commercelayer.api.model.adapter.ZonedDateTimeAdapter;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.model.common.ApiResource;
import io.commercelayer.api.model.common.Unknown;
import io.commercelayer.api.model.common.error.ApiError;
import io.commercelayer.api.model.common.error.ApiErrors;
import io.commercelayer.api.util.JSONUtils;
import moe.banana.jsonapi2.JsonApiConverterFactory;
import moe.banana.jsonapi2.Resource;
import moe.banana.jsonapi2.ResourceAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;


public class ApiCaller {

	private static final Logger logger = LoggerFactory.getLogger(ApiCaller.class);

	private static final String PATH_API = ApiConfig.getProperty(Group.api, "service.path");

	private final String apiBaseUrl;
	private final ApiToken apiToken;
	private final OkHttpClient httpClient;


	public ApiCaller(ApiOrganization apiOrg, ApiToken apiToken) {
		this(ApiConfig.getApiBaseUrl(apiOrg).concat(PATH_API), apiToken);
	}
	
	public ApiCaller(String apiBaseUrl, ApiToken apiToken) {
		
		this.apiBaseUrl = apiBaseUrl.concat(apiBaseUrl.endsWith("/")? "" : "/");
		this.apiToken = apiToken;
		this.httpClient = buildHttpClient();

		logger.info("Built client for {}", this.apiBaseUrl);

	}
	

	private OkHttpClient buildHttpClient() {

		OkHttpClientBuilder.Setup clientSetup = new OkHttpClientBuilder.Setup();
		clientSetup.setApiBaseUrl(this.apiBaseUrl);

		boolean added = false;
		added = clientSetup.addInterceptor(new OAuth2Interceptor(new HttpAuthOAuth2(this.apiToken.getAccessToken())));
		logger.debug("Added OAUth2 Inteceptor: {}", added);
		added = clientSetup.addInterceptor(new ContentTypeInterceptor(ContentType.JSON_API));
		logger.debug("Added ContentType Inteceptor: {}", added);
		
		HttpLoggingInterceptor hli = new HttpLoggingInterceptor(new HttpLogger(logger));
		hli.setLevel(ApiConfig.debugModeEnabled()? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.BASIC);
		hli.setLevel(HttpLoggingInterceptor.Level.BASIC);
		added = clientSetup.addInterceptor(hli);
		logger.debug("Added Logging Inteceptor: {}", added);
		
		return new OkHttpClientBuilder(clientSetup).build();

	}
	
	
	public final <T> T getServiceCallFactory(Class<T> service) {
		return getServiceCallFactory(service, (Class<? extends Resource>[])null);
	}
	
	@SafeVarargs
	public final <T> T getServiceCallFactory(Class<T> service, Class<? extends Resource>... resources) {
		return getServiceCallFactory(service, false, resources);
	}

	
	@SuppressWarnings("unchecked")
	@SafeVarargs
	private final void includeRelatedResourcesAdapters(ResourceAdapterFactory.Builder rafBuilder, Class<? extends Resource>... resources) {
		
		for (Class<? extends Resource> resClass : resources) {
			
			if (!ApiResource.class.isAssignableFrom(resClass)) continue;
			
			List<Class<? extends ApiResource>> relResList = null;
			
			if (AdaptersCacheMap.hasCachedAdapters(resClass)) relResList = AdaptersCacheMap.getAdaptersList(resClass);
			else
			try {
				Field relResListField = resClass.getField(ApiConstants.RELATED_RESOURCES_FIELD_NAME);
				relResList = (List<Class<? extends ApiResource>>)relResListField.get(null);
				AdaptersCacheMap.addAdaptersList(resClass, relResList);
			}
			catch (NoSuchFieldException | SecurityException | IllegalAccessException e) {
				logger.warn(e.getMessage());
				relResList = null;
			}
			
			if (relResList != null)
				for (Class<? extends ApiResource> relResClass : relResList) rafBuilder.add(relResClass);
			
		}
		
	}
	

	@SafeVarargs
	public final <T> T getServiceCallFactory(Class<T> service, boolean includeRelatedResources, Class<? extends Resource>... resources) {

		ResourceAdapterFactory.Builder rafBuilder = ResourceAdapterFactory.builder();
		// Add declared resources
		if ((resources != null) && (resources.length > 0)) rafBuilder.add(resources);
		// Eventually add undeclared but related resources
		if (includeRelatedResources) includeRelatedResourcesAdapters(rafBuilder, resources);
		
		JsonAdapter.Factory jsonApiAdapterFactory = rafBuilder.add(Unknown.class).build();

		Moshi moshi = new Moshi.Builder()
			.add(jsonApiAdapterFactory)
			.add(ZonedDateTime.class, new ZonedDateTimeAdapter())
			.add(Boolean.class, new BooleanAdapter())
			.build();

		Retrofit retrofit = new Retrofit.Builder()
			.baseUrl(this.apiBaseUrl)
			.client(this.httpClient)
			.addConverterFactory(JsonApiConverterFactory.create(moshi))
			.build();
		
		logger.debug("Created CL Api Raw Client");

		return retrofit.create(service);

	}
	
	
	public <T> T readServiceResponse(Response<T> response) throws ConnectionException, ApiException {
		
		if (response.isSuccessful()) return response.body();
		else {
			if (response.code() == 404) throw new ConnectionException(String.format("%d - %s", response.code(), response.message()));
			else throw new ApiException(getErrors(response));
		}
		
	}
	
	public List<ApiError> getErrors(Response<?> response) {
		
		if ((response == null) || response.isSuccessful() || response.errorBody() == null) return null;
		else
			try {
				ApiErrors apiErrors = JSONUtils.fromJSON(response.errorBody().string(), ApiErrors.class);
				return apiErrors.getErrors();
			} catch (IOException ioe) {
				logger.error(ioe.getMessage());
				return null;
			}

	}
	
	public <T> T call(Call<T> apiCall) throws ConnectionException, ApiException {
		logger.info("CL Api Service Sync Call --> {}", apiCall.request().url());
		try {
			Response<T> response = apiCall.execute();
			return readServiceResponse(response);
		} catch (IOException e) {
			throw new ConnectionException(e.getMessage());
		}
	}
	
	public <T> void call(Call<T> apiCall, ApiCallback<T> apiCallback) {
		logger.info("CL Api Service Async Call --> {}", apiCall.request().url());
		apiCall.enqueue(new ApiCallbackAdapter<T>(apiCallback));
	}
	
}
