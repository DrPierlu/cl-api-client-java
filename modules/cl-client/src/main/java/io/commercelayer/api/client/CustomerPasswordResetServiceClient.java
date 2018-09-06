package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.Customer;
import io.commercelayer.api.model.CustomerPasswordReset;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.CustomerPasswordResetService;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

public class CustomerPasswordResetServiceClient extends AbstractServiceClient {
  protected CustomerPasswordResetService service;

  public CustomerPasswordResetServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws
      AuthException {
    super(apiOrg, apiAuth);
    this.service = apiCaller.getServiceCallFactory(CustomerPasswordResetService.class, CustomerPasswordReset.class);
  }

  public CustomerPasswordResetServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws
      AuthException {
    super(apiOrg, apiToken);
    this.service = apiCaller.getServiceCallFactory(CustomerPasswordResetService.class, CustomerPasswordReset.class);
  }

  public CustomerPasswordReset createCustomerPasswordReset(
      CustomerPasswordReset customerPasswordReset) throws ApiException {
    Call<CustomerPasswordReset> call = service.createCustomerPasswordReset(customerPasswordReset);
    return syncCall(call);
  }

  public void createCustomerPasswordReset(CustomerPasswordReset customerPasswordReset,
      ApiCallback<CustomerPasswordReset> callback) {
    Call<CustomerPasswordReset> call = service.createCustomerPasswordReset(customerPasswordReset);
    asyncCall(call, callback);
  }

  public List<CustomerPasswordReset> listCustomerPasswordResets(
      Map<String, String> queryStringParams) throws ApiException {
    Call<List<CustomerPasswordReset>> call = service.listCustomerPasswordResets(queryStringParams);
    return syncCall(call);
  }

  public void listCustomerPasswordResets(Map<String, String> queryStringParams,
      ApiCallback<List<CustomerPasswordReset>> callback) {
    Call<List<CustomerPasswordReset>> call = service.listCustomerPasswordResets(queryStringParams);
    asyncCall(call, callback);
  }

  public List<CustomerPasswordReset> listCustomerPasswordResets() throws ApiException {
    Call<List<CustomerPasswordReset>> call = service.listCustomerPasswordResets();
    return syncCall(call);
  }

  public void listCustomerPasswordResets(ApiCallback<List<CustomerPasswordReset>> callback) {
    Call<List<CustomerPasswordReset>> call = service.listCustomerPasswordResets();
    asyncCall(call, callback);
  }

  public void deleteCustomerPasswordReset(String customerPasswordResetId) throws ApiException {
    Call<Void> call = service.deleteCustomerPasswordReset(customerPasswordResetId);
    syncCall(call);
  }

  public void deleteCustomerPasswordReset(String customerPasswordResetId,
      ApiCallback<Void> callback) {
    Call<Void> call = service.deleteCustomerPasswordReset(customerPasswordResetId);
    asyncCall(call, callback);
  }

  public CustomerPasswordReset updateCustomerPasswordReset(String customerPasswordResetId,
      CustomerPasswordReset customerPasswordReset) throws ApiException {
    Call<CustomerPasswordReset> call = service.updateCustomerPasswordReset(customerPasswordResetId, customerPasswordReset);
    return syncCall(call);
  }

  public void updateCustomerPasswordReset(String customerPasswordResetId,
      CustomerPasswordReset customerPasswordReset, ApiCallback<CustomerPasswordReset> callback) {
    Call<CustomerPasswordReset> call = service.updateCustomerPasswordReset(customerPasswordResetId, customerPasswordReset);
    asyncCall(call, callback);
  }

  public CustomerPasswordReset retrieveCustomerPasswordReset(String customerPasswordResetId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<CustomerPasswordReset> call = service.retrieveCustomerPasswordReset(customerPasswordResetId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveCustomerPasswordReset(String customerPasswordResetId,
      Map<String, String> queryStringParams, ApiCallback<CustomerPasswordReset> callback) {
    Call<CustomerPasswordReset> call = service.retrieveCustomerPasswordReset(customerPasswordResetId, queryStringParams);
    asyncCall(call, callback);
  }

  public CustomerPasswordReset retrieveCustomerPasswordReset(String customerPasswordResetId) throws
      ApiException {
    Call<CustomerPasswordReset> call = service.retrieveCustomerPasswordReset(customerPasswordResetId);
    return syncCall(call);
  }

  public void retrieveCustomerPasswordReset(String customerPasswordResetId,
      ApiCallback<CustomerPasswordReset> callback) {
    Call<CustomerPasswordReset> call = service.retrieveCustomerPasswordReset(customerPasswordResetId);
    asyncCall(call, callback);
  }

  public Customer retrieveCustomerPasswordResetCustomer(String customerPasswordResetId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<Customer> call = service.retrieveCustomerPasswordResetCustomer(customerPasswordResetId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveCustomerPasswordResetCustomer(String customerPasswordResetId,
      Map<String, String> queryStringParams, ApiCallback<Customer> callback) {
    Call<Customer> call = service.retrieveCustomerPasswordResetCustomer(customerPasswordResetId, queryStringParams);
    asyncCall(call, callback);
  }

  public Customer retrieveCustomerPasswordResetCustomer(String customerPasswordResetId) throws
      ApiException {
    Call<Customer> call = service.retrieveCustomerPasswordResetCustomer(customerPasswordResetId);
    return syncCall(call);
  }

  public void retrieveCustomerPasswordResetCustomer(String customerPasswordResetId,
      ApiCallback<Customer> callback) {
    Call<Customer> call = service.retrieveCustomerPasswordResetCustomer(customerPasswordResetId);
    asyncCall(call, callback);
  }
}
