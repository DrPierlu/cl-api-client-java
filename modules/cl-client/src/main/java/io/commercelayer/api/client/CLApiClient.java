package io.commercelayer.api.client;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.config.ApiConfig;
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

	private static final String PATH_API = "/api";

	private final String apiBaseUrl;
	private final ApiToken apiToken;
	private final OkHttpClient httpClient;

	private Map<String, String> queryStringParams = new LinkedHashMap<>();
	private List<String> includedResources = new LinkedList<>();
	private Map<String, List<String>> fieldsFilters = new LinkedHashMap<>();
	private Map<String, Boolean> sortFields = new LinkedHashMap<>();

	public CLApiClient(ApiOrganization apiOrg, ApiToken apiToken) {

		this.apiBaseUrl = ApiConfig.getApiBaseUrl(apiOrg).concat(PATH_API);
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

	public Map<String, String> getQueryStringParams() {
		return queryStringParams;
	}

	public void setQueryStringParams(Map<String, String> queryStringParams) {
		this.queryStringParams = queryStringParams;
	}

	public Map<String, String> addQueryStringParam(String key, String value) {
		this.queryStringParams.put(key, value);
		return this.queryStringParams;
	}

	public List<String> getIncludedResources() {
		return includedResources;
	}

	public void setIncludedResources(List<String> includedResources) {
		this.includedResources = includedResources;
	}

	public List<String> addIncludedResource(String resource) {
		this.includedResources.add(resource);
		return this.includedResources;
	}

	public void removeIncludedResource(String resource) {
		if (this.includedResources == null) return;
		this.includedResources.remove(resource);
	}

	protected String getIncludedQueryParam() {

		if (this.includedResources.isEmpty()) return "";

		StringBuilder iqp = new StringBuilder();
		
		for (String ir : this.includedResources) {
			if (iqp.length() == 0) iqp.append("include=");
			else iqp.append(',');
			iqp.append(ir);
		}

		return iqp.toString();

	}
	

	public Map<String, List<String>> getFieldsFilters() {
		return fieldsFilters;
	}

	public void setFieldsFilters(Map<String, List<String>> fieldsFilters) {
		this.fieldsFilters = fieldsFilters;
	}

	public Map<String, List<String>> addFieldsFilter(String resource, String... fields) {
		List<String> filter = this.fieldsFilters.get(resource);
		if (filter == null) filter = new ArrayList<>();
		for (String f : fields) {
			if (!filter.contains(f)) filter.add(f);
		}
		this.fieldsFilters.put(resource, filter);
		return this.fieldsFilters;
	}
	
	public Map<String, Boolean> addSortField(String field, boolean ascending) {
		this.sortFields.put(field, ascending);
		return this.sortFields;
	}
	
	public void removeSortField(String field) {
		if (this.sortFields.containsKey(field)) this.sortFields.remove(field);
	}
	
	
	public Map<String, Boolean> getSortFields() {
		return sortFields;
	}

	public void setSortFields(Map<String, Boolean> sortFields) {
		this.sortFields = sortFields;
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
