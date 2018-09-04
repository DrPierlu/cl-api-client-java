package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.Address;
import io.commercelayer.api.model.Customer;
import io.commercelayer.api.model.CustomerAddress;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.CustomerAddressService;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

public class CustomerAddressServiceClient extends AbstractServiceClient {
  protected CustomerAddressService service;

  public CustomerAddressServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws
      AuthException {
    super(apiOrg, apiAuth);
    this.service = apiCaller.getServiceCallFactory(CustomerAddressService.class, CustomerAddress.class);
  }

  public CustomerAddressServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws
      AuthException {
    super(apiOrg, apiToken);
    this.service = apiCaller.getServiceCallFactory(CustomerAddressService.class, CustomerAddress.class);
  }

  public List<CustomerAddress> listCustomerAddresses(Map<String, String> queryStringParams) throws
      ApiException {
    Call<List<CustomerAddress>> call = service.listCustomerAddresses(queryStringParams);
    return syncCall(call);
  }

  public void listCustomerAddresses(Map<String, String> queryStringParams,
      ApiCallback<List<CustomerAddress>> callback) {
    Call<List<CustomerAddress>> call = service.listCustomerAddresses(queryStringParams);
    asyncCall(call, callback);
  }

  public List<CustomerAddress> listCustomerAddresses() throws ApiException {
    Call<List<CustomerAddress>> call = service.listCustomerAddresses();
    return syncCall(call);
  }

  public void listCustomerAddresses(ApiCallback<List<CustomerAddress>> callback) {
    Call<List<CustomerAddress>> call = service.listCustomerAddresses();
    asyncCall(call, callback);
  }

  public CustomerAddress createCustomerAddress(CustomerAddress customerAddress) throws
      ApiException {
    Call<CustomerAddress> call = service.createCustomerAddress(customerAddress);
    return syncCall(call);
  }

  public void createCustomerAddress(CustomerAddress customerAddress,
      ApiCallback<CustomerAddress> callback) {
    Call<CustomerAddress> call = service.createCustomerAddress(customerAddress);
    asyncCall(call, callback);
  }

  public void deleteCustomerAddress(String customerAddressId) throws ApiException {
    Call<Void> call = service.deleteCustomerAddress(customerAddressId);
    syncCall(call);
  }

  public void deleteCustomerAddress(String customerAddressId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteCustomerAddress(customerAddressId);
    asyncCall(call, callback);
  }

  public CustomerAddress updateCustomerAddress(String customerAddressId,
      CustomerAddress customerAddress) throws ApiException {
    Call<CustomerAddress> call = service.updateCustomerAddress(customerAddressId, customerAddress);
    return syncCall(call);
  }

  public void updateCustomerAddress(String customerAddressId, CustomerAddress customerAddress,
      ApiCallback<CustomerAddress> callback) {
    Call<CustomerAddress> call = service.updateCustomerAddress(customerAddressId, customerAddress);
    asyncCall(call, callback);
  }

  public CustomerAddress retrieveCustomerAddress(String customerAddressId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<CustomerAddress> call = service.retrieveCustomerAddress(customerAddressId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveCustomerAddress(String customerAddressId,
      Map<String, String> queryStringParams, ApiCallback<CustomerAddress> callback) {
    Call<CustomerAddress> call = service.retrieveCustomerAddress(customerAddressId, queryStringParams);
    asyncCall(call, callback);
  }

  public CustomerAddress retrieveCustomerAddress(String customerAddressId) throws ApiException {
    Call<CustomerAddress> call = service.retrieveCustomerAddress(customerAddressId);
    return syncCall(call);
  }

  public void retrieveCustomerAddress(String customerAddressId,
      ApiCallback<CustomerAddress> callback) {
    Call<CustomerAddress> call = service.retrieveCustomerAddress(customerAddressId);
    asyncCall(call, callback);
  }

  public Address retrieveCustomerAddressAddress(String customerAddressId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<Address> call = service.retrieveCustomerAddressAddress(customerAddressId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveCustomerAddressAddress(String customerAddressId,
      Map<String, String> queryStringParams, ApiCallback<Address> callback) {
    Call<Address> call = service.retrieveCustomerAddressAddress(customerAddressId, queryStringParams);
    asyncCall(call, callback);
  }

  public Address retrieveCustomerAddressAddress(String customerAddressId) throws ApiException {
    Call<Address> call = service.retrieveCustomerAddressAddress(customerAddressId);
    return syncCall(call);
  }

  public void retrieveCustomerAddressAddress(String customerAddressId,
      ApiCallback<Address> callback) {
    Call<Address> call = service.retrieveCustomerAddressAddress(customerAddressId);
    asyncCall(call, callback);
  }

  public Customer retrieveCustomerAddressCustomer(String customerAddressId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<Customer> call = service.retrieveCustomerAddressCustomer(customerAddressId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveCustomerAddressCustomer(String customerAddressId,
      Map<String, String> queryStringParams, ApiCallback<Customer> callback) {
    Call<Customer> call = service.retrieveCustomerAddressCustomer(customerAddressId, queryStringParams);
    asyncCall(call, callback);
  }

  public Customer retrieveCustomerAddressCustomer(String customerAddressId) throws ApiException {
    Call<Customer> call = service.retrieveCustomerAddressCustomer(customerAddressId);
    return syncCall(call);
  }

  public void retrieveCustomerAddressCustomer(String customerAddressId,
      ApiCallback<Customer> callback) {
    Call<Customer> call = service.retrieveCustomerAddressCustomer(customerAddressId);
    asyncCall(call, callback);
  }
}
