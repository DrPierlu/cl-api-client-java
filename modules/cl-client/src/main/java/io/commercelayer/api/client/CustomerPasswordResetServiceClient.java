package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.common.QueryFilter;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.Customer;
import io.commercelayer.api.model.CustomerPasswordReset;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.CustomerPasswordResetService;
import java.util.List;
import retrofit2.Call;

public class CustomerPasswordResetServiceClient extends AbstractServiceClient {
  protected final CustomerPasswordResetService service;

  {
    this.service = initServiceCallFactory(CustomerPasswordResetService.class, CustomerPasswordReset.class);
  }

  public CustomerPasswordResetServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws
      AuthException {
    super(apiOrg, apiAuth);
  }

  public CustomerPasswordResetServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws
      AuthException {
    super(apiOrg, apiToken);
  }

  public List<CustomerPasswordReset> listCustomerPasswordResets(QueryFilter queryFilter) throws
      ApiException {
    Call<List<CustomerPasswordReset>> call = service.listCustomerPasswordResets(queryFilter);
    return syncCall(call);
  }

  public void listCustomerPasswordResets(QueryFilter queryFilter,
      ApiCallback<List<CustomerPasswordReset>> callback) {
    Call<List<CustomerPasswordReset>> call = service.listCustomerPasswordResets(queryFilter);
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
      QueryFilter queryFilter) throws ApiException {
    Call<CustomerPasswordReset> call = service.retrieveCustomerPasswordReset(customerPasswordResetId, queryFilter);
    return syncCall(call);
  }

  public void retrieveCustomerPasswordReset(String customerPasswordResetId, QueryFilter queryFilter,
      ApiCallback<CustomerPasswordReset> callback) {
    Call<CustomerPasswordReset> call = service.retrieveCustomerPasswordReset(customerPasswordResetId, queryFilter);
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
      QueryFilter queryFilter) throws ApiException {
    Call<Customer> call = service.retrieveCustomerPasswordResetCustomer(customerPasswordResetId, queryFilter);
    return syncCall(call);
  }

  public void retrieveCustomerPasswordResetCustomer(String customerPasswordResetId,
      QueryFilter queryFilter, ApiCallback<Customer> callback) {
    Call<Customer> call = service.retrieveCustomerPasswordResetCustomer(customerPasswordResetId, queryFilter);
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
