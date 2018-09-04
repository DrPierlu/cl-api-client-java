package io.commercelayer.api.test;

import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.ApiAuthenticator;
import io.commercelayer.api.client.exception.AuthException;


public class AuthenticationTest {

	public static void main(String[] args) {
		ApiToken token = new AuthenticationTest().authenticate();
		System.out.println(token);	
	}
	
	
	public ApiToken authenticate() {
		
		ApiAuthenticator client = new ApiAuthenticator(TestData.getOrganization());
		
		ApiToken token = null;
		
		try {
			token = client.authenticate(TestData.getClientCredentials());
		} catch (AuthException e) {
			e.printStackTrace();
		}
		
		return token;
		
	}
	
}
