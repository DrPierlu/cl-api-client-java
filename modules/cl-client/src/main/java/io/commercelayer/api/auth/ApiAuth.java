package io.commercelayer.api.auth;

import com.squareup.moshi.Json;

import io.commercelayer.api.model.common.ApiObject;

public abstract class ApiAuth extends ApiObject implements Authentication {

	@Json(name = "grant_type")
	protected String grantType;
	@Json(name = "client_id")
	protected String clientId;
	@Json(name = "client_secret")
	protected String clientSecret;
	
	public String getGrantType() {
		return grantType;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

}
