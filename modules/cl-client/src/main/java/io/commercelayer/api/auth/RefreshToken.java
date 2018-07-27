package io.commercelayer.api.auth;

import com.squareup.moshi.Json;

public class RefreshToken extends ApiAuth {

	@Json(name = "refresh_token")
	private String refreshToken;
	
	public RefreshToken() {
		super();
		this.grantType = GrantType.REFRESH_TOKEN;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

}
