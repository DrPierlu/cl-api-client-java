package io.commercelayer.api.test.model;

import java.io.IOException;
import java.util.HashMap;

import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.CLApiClient;
import io.commercelayer.api.model.Address;
import io.commercelayer.api.service.CLApiService;
import retrofit2.Call;
import retrofit2.Response;

public class AddressTest {
	
	public static void main(String[] args) {
		
		ApiToken token = new AuthenticationTest().authenticate();
		
		CLApiClient client = new CLApiClient(TestData.getOrganization(), token);
		@SuppressWarnings("unchecked")
		CLApiService api = client.getRawClient();
		
		Call<Address> call = api.getAddresses(new HashMap<>());
		
		Response<Address> addresses = null;
		
		try {
			addresses = call.execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (addresses != null) System.out.println("NOT NULL");
		
		System.out.println("TEST OK");
		
	}
	
}
