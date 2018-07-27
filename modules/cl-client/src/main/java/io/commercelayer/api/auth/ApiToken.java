package io.commercelayer.api.auth;

import com.squareup.moshi.Json;

import io.commercelayer.api.auth.Authentication.TokenType;
import io.commercelayer.api.model.common.ApiObject;

public final class ApiToken extends ApiObject {

	@Json(name = "access_token")
	private String accessToken;
	@Json(name = "token_type")
	private String tokenType = TokenType.BEARER;
	@Json(name = "refresh_token")
	private String refreshToken;
	private String scope;
	@Json(name = "owner_type")
	private String ownerType;
	@Json(name = "owner_id")
	private Long ownerId;
	@Json(name = "created_at")
	private String createdAt;
	@Json(name = "expires_in")
	private Long expiresIn;

	ApiToken() {
		super();
	}

	public String getAccessToken() {
		return accessToken;
	}

	void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getScope() {
		return scope;
	}

	void setScope(String scope) {
		this.scope = scope;
	}

	public String getOwnerType() {
		return ownerType;
	}

	void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}

}
