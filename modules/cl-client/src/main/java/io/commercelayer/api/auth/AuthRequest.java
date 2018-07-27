package io.commercelayer.api.auth;

import io.commercelayer.api.http.auth.HttpAuth;
import io.commercelayer.api.model.common.ApiObject;

public class AuthRequest extends ApiObject {

	private String tokenUrl;
	private ApiAuth apiAuth;
	private HttpAuth httpAuth;

	public AuthRequest() {

	}

	public AuthRequest(ApiAuth auth) {
		this.apiAuth = auth;
	}

	public ApiAuth getApiAuth() {
		return apiAuth;
	}

	public void setApiAuth(ApiAuth apiAuth) {
		this.apiAuth = apiAuth;
	}

	public HttpAuth getHttpAuth() {
		return httpAuth;
	}

	public void setHttpAuth(HttpAuth httpAuth) {
		this.httpAuth = httpAuth;
	}

	public String getTokenUrl() {
		return tokenUrl;
	}

	public void setTokenUrl(String tokenUrl) {
		this.tokenUrl = tokenUrl;
	}

}
