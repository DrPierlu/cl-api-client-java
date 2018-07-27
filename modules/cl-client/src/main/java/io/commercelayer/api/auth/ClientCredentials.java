package io.commercelayer.api.auth;

import io.commercelayer.api.util.LogUtils;

public class ClientCredentials extends ApiAuth {

	private String scope;

	public ClientCredentials() {
		super();
		this.grantType = GrantType.CLIENT_CREDENTIALS;
	}
	
	public String getScope() {
		return scope;
	}
	
	public void setScope(String scope) {
		this.scope = scope;
	}

	public void setMarketScope(Long marketId) {
		String s = (marketId == null)? null : String.format("market:%d", marketId);
		this.scope = s;
	}
	
	public Long getMarketScope() {
		if (this.scope == null) return null;
		String[] tokens = this.scope.split(":");
		try {
			return Long.valueOf(tokens[1]);
		}
		catch (Exception e) {
			LogUtils.singleErrorMessage(this, e.getMessage());;
			return null;
		}
	}
	
}
