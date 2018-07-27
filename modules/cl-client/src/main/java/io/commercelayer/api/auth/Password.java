package io.commercelayer.api.auth;

public class Password extends ClientCredentials {

	private String username;
	private String password;


	public Password() {
		super();
		this.grantType = GrantType.PASSWORD;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
