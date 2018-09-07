package io.commercelayer.api.client.common;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.client.exception.ConnectionException;
import io.commercelayer.api.model.common.ApiOrganization;
import moe.banana.jsonapi2.Resource;
import retrofit2.Call;

public abstract class AbstractServiceClient {

	private ApiCaller apiCaller;
	
	
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
	protected final <T> T initServiceCallFactory(Class<T> service, Class<? extends Resource>... resources) {
		return this.apiCaller.getServiceCallFactory(service, resources);
	}
	
	protected <T> T syncCall(Call<T> apiCall) throws ConnectionException, ApiException {
		return this.apiCaller.call(apiCall);
	}
	
	protected <T> void asyncCall(Call<T> apiCall, ApiCallback<T> apiCallback) {
		this.apiCaller.call(apiCall, apiCallback);
	}
	
}
