package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.common.query.QueryFilter;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.exception.ApiException;
import io.commercelayer.api.model.Address;
import io.commercelayer.api.model.Geocoder;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.AddressService;
import java.util.List;
import retrofit2.Call;

public class AddressServiceClient extends AbstractServiceClient<AddressService> {
  {
    initServiceCallFactory(AddressService.class, Address.class);
  }

  public AddressServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
  }

  public AddressServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
  }

  public List<Address> listAddresses(QueryFilter queryFilter) throws ApiException {
    Call<List<Address>> call = service.listAddresses(queryFilter);
    return syncCall(call);
  }

  public void listAddresses(QueryFilter queryFilter, ApiCallback<List<Address>> callback) {
    Call<List<Address>> call = service.listAddresses(queryFilter);
    asyncCall(call, callback);
  }

  public List<Address> listAddresses() throws ApiException {
    Call<List<Address>> call = service.listAddresses();
    return syncCall(call);
  }

  public void listAddresses(ApiCallback<List<Address>> callback) {
    Call<List<Address>> call = service.listAddresses();
    asyncCall(call, callback);
  }

  public Address createAddress(Address address, QueryFilter queryFilter) throws ApiException {
    Call<Address> call = service.createAddress(address, queryFilter);
    return syncCall(call);
  }

  public void createAddress(Address address, QueryFilter queryFilter,
      ApiCallback<Address> callback) {
    Call<Address> call = service.createAddress(address, queryFilter);
    asyncCall(call, callback);
  }

  public Address createAddress(Address address) throws ApiException {
    Call<Address> call = service.createAddress(address);
    return syncCall(call);
  }

  public void createAddress(Address address, ApiCallback<Address> callback) {
    Call<Address> call = service.createAddress(address);
    asyncCall(call, callback);
  }

  public Address updateAddress(String addressId, Address address, QueryFilter queryFilter) throws
      ApiException {
    Call<Address> call = service.updateAddress(addressId, address, queryFilter);
    return syncCall(call);
  }

  public void updateAddress(String addressId, Address address, QueryFilter queryFilter,
      ApiCallback<Address> callback) {
    Call<Address> call = service.updateAddress(addressId, address, queryFilter);
    asyncCall(call, callback);
  }

  public Address updateAddress(String addressId, Address address) throws ApiException {
    Call<Address> call = service.updateAddress(addressId, address);
    return syncCall(call);
  }

  public void updateAddress(String addressId, Address address, ApiCallback<Address> callback) {
    Call<Address> call = service.updateAddress(addressId, address);
    asyncCall(call, callback);
  }

  public Address retrieveAddress(String addressId, QueryFilter queryFilter) throws ApiException {
    Call<Address> call = service.retrieveAddress(addressId, queryFilter);
    return syncCall(call);
  }

  public void retrieveAddress(String addressId, QueryFilter queryFilter,
      ApiCallback<Address> callback) {
    Call<Address> call = service.retrieveAddress(addressId, queryFilter);
    asyncCall(call, callback);
  }

  public Address retrieveAddress(String addressId) throws ApiException {
    Call<Address> call = service.retrieveAddress(addressId);
    return syncCall(call);
  }

  public void retrieveAddress(String addressId, ApiCallback<Address> callback) {
    Call<Address> call = service.retrieveAddress(addressId);
    asyncCall(call, callback);
  }

  public void deleteAddress(String addressId) throws ApiException {
    Call<Void> call = service.deleteAddress(addressId);
    syncCall(call);
  }

  public void deleteAddress(String addressId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteAddress(addressId);
    asyncCall(call, callback);
  }

  public Geocoder retrieveAddressGeocoder(String addressId, QueryFilter queryFilter) throws
      ApiException {
    Call<Geocoder> call = service.retrieveAddressGeocoder(addressId, queryFilter);
    return syncCall(call);
  }

  public void retrieveAddressGeocoder(String addressId, QueryFilter queryFilter,
      ApiCallback<Geocoder> callback) {
    Call<Geocoder> call = service.retrieveAddressGeocoder(addressId, queryFilter);
    asyncCall(call, callback);
  }

  public Geocoder retrieveAddressGeocoder(String addressId) throws ApiException {
    Call<Geocoder> call = service.retrieveAddressGeocoder(addressId);
    return syncCall(call);
  }

  public void retrieveAddressGeocoder(String addressId, ApiCallback<Geocoder> callback) {
    Call<Geocoder> call = service.retrieveAddressGeocoder(addressId);
    asyncCall(call, callback);
  }
}
