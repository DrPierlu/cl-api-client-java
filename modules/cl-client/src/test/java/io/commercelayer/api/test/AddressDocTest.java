package io.commercelayer.api.test;

import java.io.IOException;
import java.util.List;

import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.CLApiClient;
import io.commercelayer.api.client.QueryFilter;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.model.Address;
import io.commercelayer.api.service.document.AddressService;
import io.commercelayer.api.util.ApiUtils;
import moe.banana.jsonapi2.ArrayDocument;
import moe.banana.jsonapi2.Document;
import retrofit2.Call;
import retrofit2.Response;

public class AddressDocTest {
	
	public static void main(String[] args) throws ApiException {
		
		ApiToken token = new AuthenticationTest().authenticate();
		
		CLApiClient client = new CLApiClient(TestData.getOrganization(), token);

		AddressService rawClient = client.getRawClient(AddressService.class, Address.class);
		
		Call<Document> apiCall = rawClient.listAddresses(QueryFilter.empty());
		
		Response<Document> response = null;
		
		
		try {
			response = apiCall.execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (response != null) {
			if (!response.isSuccessful()) {
				List<moe.banana.jsonapi2.Error> errors = response.body().getErrors();
				throw new ApiException(ApiUtils.getError(response));
			}
			ArrayDocument<Address> addresses = response.body().asArrayDocument();
			System.out.println("Addresses: " + addresses.size());
		}
		
		System.out.println("TEST OK");
		
	}
	
}
