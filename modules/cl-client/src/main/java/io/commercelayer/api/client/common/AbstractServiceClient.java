package io.commercelayer.api.client.common;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.query.QueryFilter;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.client.exception.ConnectionException;
import io.commercelayer.api.exception.ApiException;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.model.common.ApiResource;
import retrofit2.Call;

public abstract class AbstractServiceClient<SERVICE> {

	private ApiCaller apiCaller;
	protected SERVICE service;
	
	
	public AbstractServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
		ApiToken apiToken = new ApiAuthenticator(apiOrg).authenticate(apiAuth);
		initApiCaller(apiOrg, apiToken);
	}
	
	public AbstractServiceClient(ApiOrganization apiOrg, ApiToken apiToken) {
		initApiCaller(apiOrg, apiToken);
	}
	
	private void initApiCaller(ApiOrganization apiOrg, ApiToken apiToken) {
		this.apiCaller = new ApiCaller(apiOrg, apiToken);
	}
	
	@SafeVarargs
	protected final void initServiceCallFactory(Class<SERVICE> service, boolean includeRelatedResources, Class<? extends ApiResource>... resources) {
		this.service = this.apiCaller.getServiceCallFactory(service, includeRelatedResources, resources);
	}
	
	@SafeVarargs
	protected final void initServiceCallFactory(Class<SERVICE> service, Class<? extends ApiResource>... resources) {
		this.service = this.apiCaller.getServiceCallFactory(service, resources);
	}
	
	protected <MODEL> MODEL syncCall(Call<MODEL> apiCall) throws ConnectionException, ApiException {
		return this.apiCaller.call(apiCall);
	}
	
	protected <MODEL> void asyncCall(Call<MODEL> apiCall, ApiCallback<MODEL> apiCallback) {
		this.apiCaller.call(apiCall, apiCallback);
	}
	
	public QueryFilter.Builder queryFilterBuilder() {
		return QueryFilter.builder();
	}
	
}
