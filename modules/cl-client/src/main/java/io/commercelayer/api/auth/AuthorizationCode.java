package io.commercelayer.api.auth;

import com.squareup.moshi.Json;

public class AuthorizationCode extends ClientCredentials {

	private String code;
	@Json(name = "redirect_uri")
	private String redirectUri;

	public AuthorizationCode() {
		super();
		this.grantType = GrantType.AUTHORIZATION_CODE;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

}
