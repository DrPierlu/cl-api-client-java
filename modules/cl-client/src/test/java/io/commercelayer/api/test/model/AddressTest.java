package io.commercelayer.api.test.model;

import java.io.IOException;
import java.util.List;

import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.ApiUtils;
import io.commercelayer.api.client.CLApiClient;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.ConnectionException;
import io.commercelayer.api.model.Address;
import io.commercelayer.api.model.Geocoder;
import io.commercelayer.api.service.AddressService;
import io.commercelayer.api.test.AuthenticationTest;
import io.commercelayer.api.test.TestData;
import retrofit2.Call;
import retrofit2.Response;

public class AddressTest {
	
	private static CLApiClient apiClient;
	private static AddressService service;
	
	private static void initServiceClient() {
		ApiToken token = new AuthenticationTest().authenticate();
		apiClient = new CLApiClient(TestData.getOrganization(), token);
		service = apiClient.getRawClient(AddressService.class);
	}
	
	public static void main(String[] args) {
		
		initServiceClient();
		
		Address address = null;
		
		System.out.println("********** CREATE");
		try {
			address = createAddress();
			System.out.println(address);
		} catch (ConnectionException | ApiException e) {
			e.printStackTrace();
		}
		
		System.out.println("********** LIST");
		try {
			List<Address> addresses = listAddresses();
			System.out.println(addresses);
		} catch (ConnectionException | ApiException e) {
			e.printStackTrace();
		}
		
		System.out.println("********** UPDATE");
		try {
			address = updateAddress(address.getId());
			System.out.println(address);
		} catch (ConnectionException | ApiException e) {
			e.printStackTrace();
		}
		
	}
	
	
	private static Address createAddress() throws ApiException, ConnectionException {
		
		Address a = new Address();
		
		a.setLine1("Via Roma");
		a.setCity("Siena");
		a.setZipCode("53100");
		a.setStateCode("SI");
		a.setCountryCode("IT");
		a.setPhone("0577123456789");
		a.setFirstName("Mario");
		a.setLastName("Rossi");
		
		Call<Address> call = service.createAddress(a);
		
		return apiClient.execute(call);
		
	}
	
	private static Address updateAddress(String id) throws ApiException, ConnectionException {
		
		Address a = new Address();
		
		a.setId(id);
		
		a.setLine1("Via Milano");
		a.setCity("Poggibonsi");
		a.setZipCode("53036");
		a.setStateCode("SI");
		a.setCountryCode("IT");
		a.setPhone("0577123456789");
		a.setFirstName("Mario");
		a.setLastName("Rossi");
		
		Call<Address> call = service.updateAddress(id, a);
		
		return apiClient.execute(call);
		
	}
	
	private static List<Address> listAddresses() throws ApiException, ConnectionException {
		
		Call<List<Address>> apiCall = service.listAddresses();
		
		return apiClient.execute(apiCall);
		
	}
	
}
