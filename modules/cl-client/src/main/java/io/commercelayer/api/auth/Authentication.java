package io.commercelayer.api.auth;

public interface Authentication {
	
	public static interface TokenType {
		String BEARER 				= "bearer";
	}
	
	public static interface GrantType {
		String PASSWORD 			= "password";
		String REFRESH_TOKEN 		= "refresh_token";
		String CLIENT_CREDENTIALS	= "client_credentials";
		String AUTHORIZATION_CODE	= "authorization_code";
	}
	
	
	public static interface OwnerType {
		String CUSTOMER 			= "customer";
		String USER					= "user";
	}

}
