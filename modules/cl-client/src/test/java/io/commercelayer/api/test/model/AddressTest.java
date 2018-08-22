package io.commercelayer.api.test.model;

import java.io.IOException;

import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.CLApiClient;
import io.commercelayer.api.client.QueryFilter;
import io.commercelayer.api.exception.ApiException;
import io.commercelayer.api.model.dev.Address;
import io.commercelayer.api.service.dev.AddressService;
import io.commercelayer.api.test.AuthenticationTest;
import io.commercelayer.api.util.ApiUtils;
import io.commercelayer.api.util.LogUtils;
import retrofit2.Call;
import retrofit2.Response;

public class AddressTest {
	
	public static void main(String[] args) throws ApiException {
		
		ApiToken token = new AuthenticationTest().authenticate();
		
		CLApiClient client = new CLApiClient(TestData.getOrganization(), token);

		AddressService rawClient = client.getRawClient(AddressService.class, Address.class);
		
		Call<Address> apiCall = rawClient.listAddresses(QueryFilter.empty());
		
		Response<Address> addresses = null;
		
		
		try {
			addresses = apiCall.execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (addresses != null) {
			if (!addresses.isSuccessful()) {
				throw new ApiException(ApiUtils.getError(addresses));
			}
			Address address = addresses.body();
			System.out.println(LogUtils.toString(address));
		}
		
		System.out.println("TEST OK");
		
	}
	
}
