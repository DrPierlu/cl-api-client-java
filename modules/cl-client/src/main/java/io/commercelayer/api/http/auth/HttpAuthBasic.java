package io.commercelayer.api.http.auth;

import java.util.Base64;

public class HttpAuthBasic implements HttpAuth {

	private String username;
	private String password;
	
	public HttpAuthBasic() {
		super();
	}
	
	
	public HttpAuthBasic(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String getHttpRequestAuthHeader() {
		return "Basic " + Base64.getEncoder().encodeToString(new String(getUsername().concat(":").concat(getPassword())).getBytes());
	}

}
