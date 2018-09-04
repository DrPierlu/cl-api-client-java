package io.commercelayer.api.client.common;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.client.exception.ConnectionException;
import io.commercelayer.api.model.common.ApiOrganization;
import retrofit2.Call;

public abstract class AbstractServiceClient {

	protected ApiCaller apiCaller;
	
	public AbstractServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
		ApiToken token = new ApiAuthenticator(apiOrg).authenticate(apiAuth);
		this.apiCaller = new ApiCaller(apiOrg, token);
	}
	
	public AbstractServiceClient(ApiOrganization apiOrg, ApiToken apiToken) {
		this.apiCaller = new ApiCaller(apiOrg, apiToken);
	}
	
	protected <T> T execute(Call<T> apiCall) throws ConnectionException, ApiException {
		return apiCaller.execute(apiCall);
	}
	
	protected <T> void enqueue(Call<T> apiCall, ApiCallback<T> apiCallback) {
		apiCaller.enqueue(apiCall, apiCallback);
	}
	
}
