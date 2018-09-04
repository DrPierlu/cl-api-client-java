package io.commercelayer.api.test;

import java.util.List;

import io.commercelayer.api.client.AddressServiceClient;
import io.commercelayer.api.client.common.ApiCallback;

import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.client.exception.ConnectionException;
import io.commercelayer.api.model.Address;
import io.commercelayer.api.model.common.error.ApiError;
import okhttp3.Request;

public class TestX implements ApiCallback<List<Address>> {

	public static void main(String[] args) throws AuthException, ApiException {
		
		AddressServiceClient client = new AddressServiceClient(TestData.getOrganization(), TestData.getClientCredentials());

//		List<Address> addresses = client.listAddresses();
//		printList(addresses);
		
		client.listAddresses(new TestX());

	}

	@Override
	public void onSuccess(Request request, List<Address> response) {
		System.out.println("**** onSuccess ****");
		printList(response);		
	}

	@Override
	public void onError(Request request, List<ApiError> errors) {
		System.out.println("**** onError ****");
		System.out.println(errors);		
	}

	@Override
	public void onFailure(Request request, ConnectionException ce) {
		System.out.println("**** onFailure ****");
		System.out.println(ce);
	}
	
	private static void printList(List<Address> addresses) {
		for (Address a : addresses) System.out.println(a);
	}
	
}
