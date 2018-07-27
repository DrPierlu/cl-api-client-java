package io.commercelayer.api.test.model;

import io.commercelayer.api.auth.ApiOrganization;
import io.commercelayer.api.auth.ClientCredentials;

public final class TestData {

	private TestData() {
		
	}
	
	public static ApiOrganization getOrganization() {
		return new ApiOrganization("the-orange-brand-5");
	}
	
	public static ClientCredentials getClientCredentials() {
		
		ClientCredentials auth = new ClientCredentials();
		
		auth.setClientId("ee681994dcef7de5baeee50a54a047e4013a046177a1a324c1f732bd1160dcda");
		auth.setClientSecret("353fed7dfdb7158902ff306b7c2d0a553697c31f73b98e5df1b302bf22528a3d");
		
		return auth;
		
	}
	
}
