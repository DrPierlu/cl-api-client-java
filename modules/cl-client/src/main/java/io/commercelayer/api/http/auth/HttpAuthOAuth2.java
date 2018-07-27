package io.commercelayer.api.http.auth;

public class HttpAuthOAuth2 implements HttpAuth {

	private String securityToken;

	public HttpAuthOAuth2(String securityToken) {
		this.securityToken = securityToken;
	}

	public String getSecurityToken() {
		return securityToken;
	}

	@Override
	public String getHttpRequestAuthHeader() {
		return "Bearer ".concat(getSecurityToken());
	}

}
