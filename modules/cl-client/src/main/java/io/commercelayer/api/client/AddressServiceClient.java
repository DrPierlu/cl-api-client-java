package io.commercelayer.api.client;

import java.util.List;
import java.util.Map;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.Address;
import io.commercelayer.api.model.Geocoder;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.AddressService;
import retrofit2.Call;

public class AddressServiceClient extends AbstractServiceClient {
	
	protected AddressService service;
	
	public AddressServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
		super(apiOrg, apiAuth);
		this.service = apiCaller.getRawClient(AddressService.class, Address.class);
	}
	
	public AddressServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
		super(apiOrg, apiToken);
		this.service = apiCaller.getRawClient(AddressService.class, Address.class);
	}

	
	public Address createAddress(Address address) throws ApiException {
		Call<Address> call = service.createAddress(address);
		return execute(call);
	}

	
	public List<Address> listAddresses() throws ApiException {
		Call<List<Address>> call = service.listAddresses();
		return execute(call);
	}
	
	public void listAddresses(ApiCallback<List<Address>> callback) {
		Call<List<Address>> call = service.listAddresses();
		enqueue(call, callback);
	}

	public List<Address> listAddresses(Map<String, String> queryStringParams) throws ApiException {
		Call<List<Address>> call = service.listAddresses(queryStringParams);
		return execute(call);
	}

	public Address updateAddress(String addressId, Address address) throws ApiException {
		Call<Address> call = service.updateAddress(addressId, address);
		return execute(call);
	}

	public void deleteAddress(String addressId) throws ApiException {
		Call<Void> call = service.deleteAddress(addressId);
		execute(call);
	}


	public Address retrieveAddress(String addressId) throws ApiException {
		Call<Address> call = service.retrieveAddress(addressId);
		return execute(call);
	}

	public Address retrieveAddress(String addressId, Map<String, String> queryStringParams) throws ApiException {
		Call<Address> call = service.retrieveAddress(addressId, queryStringParams);
		return execute(call);
	}


	public Geocoder retrieveAddressGeocoder(String addressId) throws ApiException {
		Call<Geocoder> call = service.retrieveAddressGeocoder(addressId);
		return execute(call);
	}

	public Geocoder retrieveAddressGeocoder(String addressId, Map<String, String> queryStringParams) throws ApiException {
		Call<Geocoder> call = service.retrieveAddressGeocoder(addressId, queryStringParams);
		return execute(call);
	}

}
