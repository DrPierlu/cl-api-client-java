package io.commercelayer.api.test;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.ApiAuthenticator;
import io.commercelayer.api.client.exception.AuthException;


public class AuthenticationTest {

	public static void main(String[] args) {
		new AuthenticationTest().authenticateTest();
	}
	
	@Test
	public void authenticateTest() {
		
		ApiToken token;
		try {
			token = authenticate();
			System.out.println(token);
		} catch (AuthException e) {
			e.printStackTrace();
			token = null;
		}
		
		assertNotNull(token);
		assertNotNull(token.getAccessToken());
		
	}
	
	public ApiToken authenticate() throws AuthException {
		
		ApiAuthenticator client = new ApiAuthenticator(TestData.getOrganization());
		
		ApiToken token = client.authenticate(TestData.getClientCredentials());
		
		return token;
		
	}
	
}
