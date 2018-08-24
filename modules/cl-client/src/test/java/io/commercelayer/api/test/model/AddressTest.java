package io.commercelayer.api.test.model;

import java.io.IOException;
import java.util.List;

import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.CLApiClient;
import io.commercelayer.api.client.QueryFilter;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.model.Address;
import io.commercelayer.api.service.AddressService;
import io.commercelayer.api.test.AuthenticationTest;
import io.commercelayer.api.test.TestData;
import io.commercelayer.api.util.ApiUtils;
import retrofit2.Call;
import retrofit2.Response;

public class AddressTest {
	
	public static void main(String[] args) throws ApiException {
		
		ApiToken token = new AuthenticationTest().authenticate();
		
		CLApiClient client = new CLApiClient(TestData.getOrganization(), token);

		AddressService rawClient = client.getRawClient(AddressService.class, Address.class);
		
		Call<List<Address>> apiCall = rawClient.listAddresses(QueryFilter.empty());
		
		Response<List<Address>> response = null;
		
		
		try {
			response = apiCall.execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (response != null) {
			if (!response.isSuccessful()) {
				throw new ApiException(ApiUtils.getError(response));
			}
			List<Address> address = response.body();
			System.out.println("Addresses: " + address.size());
		}
		
		System.out.println("TEST OK");
		
	}
	
}
