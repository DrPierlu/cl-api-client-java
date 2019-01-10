package io.commercelayer.api.test;

import java.security.SecureRandom;

import org.apache.commons.lang3.StringUtils;

import io.commercelayer.api.auth.ClientCredentials;
import io.commercelayer.api.model.common.ApiOrganization;

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
	
	
	public static String getRandomId(int maxLenght) {
		
		if (maxLenght < 1) maxLenght = 1;
		else
		if (maxLenght > 5) maxLenght = 5;
		
		int maxRand = 1;
		for (int i = 1; i <= maxLenght; i++) maxRand *= 10;
		
		SecureRandom sr = new SecureRandom();
		
		return StringUtils.leftPad(String.valueOf(sr.nextInt(maxRand)), maxLenght, '0');
		
	}
	
}
