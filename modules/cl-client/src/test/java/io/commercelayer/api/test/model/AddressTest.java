package io.commercelayer.api.test.model;

import java.io.IOException;
import java.util.HashMap;

import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.CLApiClient;
import io.commercelayer.api.exception.AuthException;
import io.commercelayer.api.model.Address;
import io.commercelayer.api.service.AddressService;
import io.commercelayer.api.util.ApiUtils;
import retrofit2.Call;
import retrofit2.Response;

public class AddressTest {
	
	public static void main(String[] args) throws AuthException {
		
		ApiToken token = new AuthenticationTest().authenticate();
		
		CLApiClient client = new CLApiClient(TestData.getOrganization(), token);

		AddressService api = client.getRawClient(AddressService.class, Address.class);
		
		Call<Address> call = api.listAddresses(new HashMap<>());
		
		Response<Address> addresses = null;
		
		
		try {
			addresses = call.execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (addresses != null) {
			if (!addresses.isSuccessful()) {
				throw new AuthException(ApiUtils.getError(addresses));
			}
		}
		
		System.out.println("TEST OK");
		
	}
	
}
