package io.commercelayer.api.test.model;

import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.CLApiAuthenticator;
import io.commercelayer.api.exception.AuthException;


public class AuthenticationTest {

	public static void main(String[] args) {
		ApiToken token = new AuthenticationTest().authenticate();
		System.out.println(token);	
	}
	
	
	public ApiToken authenticate() {
		
		CLApiAuthenticator client = new CLApiAuthenticator(TestData.getOrganization());
		
		ApiToken token = null;
		
		try {
			token = client.authenticate(TestData.getClientCredentials());
		} catch (AuthException e) {
			e.printStackTrace();
		}
		
		return token;
		
	}
	
}
