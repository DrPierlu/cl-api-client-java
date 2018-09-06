package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.Customer;
import io.commercelayer.api.model.CustomerPaymentSource;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.CustomerPaymentSourceService;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

public class CustomerPaymentSourceServiceClient extends AbstractServiceClient {
  protected CustomerPaymentSourceService service;

  public CustomerPaymentSourceServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws
      AuthException {
    super(apiOrg, apiAuth);
    this.service = apiCaller.getServiceCallFactory(CustomerPaymentSourceService.class, CustomerPaymentSource.class);
  }

  public CustomerPaymentSourceServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws
      AuthException {
    super(apiOrg, apiToken);
    this.service = apiCaller.getServiceCallFactory(CustomerPaymentSourceService.class, CustomerPaymentSource.class);
  }

  public CustomerPaymentSource createCustomerPaymentSource(
      CustomerPaymentSource customerPaymentSource) throws ApiException {
    Call<CustomerPaymentSource> call = service.createCustomerPaymentSource(customerPaymentSource);
    return syncCall(call);
  }

  public void createCustomerPaymentSource(CustomerPaymentSource customerPaymentSource,
      ApiCallback<CustomerPaymentSource> callback) {
    Call<CustomerPaymentSource> call = service.createCustomerPaymentSource(customerPaymentSource);
    asyncCall(call, callback);
  }

  public List<CustomerPaymentSource> listCustomerPaymentSources(
      Map<String, String> queryStringParams) throws ApiException {
    Call<List<CustomerPaymentSource>> call = service.listCustomerPaymentSources(queryStringParams);
    return syncCall(call);
  }

  public void listCustomerPaymentSources(Map<String, String> queryStringParams,
      ApiCallback<List<CustomerPaymentSource>> callback) {
    Call<List<CustomerPaymentSource>> call = service.listCustomerPaymentSources(queryStringParams);
    asyncCall(call, callback);
  }

  public List<CustomerPaymentSource> listCustomerPaymentSources() throws ApiException {
    Call<List<CustomerPaymentSource>> call = service.listCustomerPaymentSources();
    return syncCall(call);
  }

  public void listCustomerPaymentSources(ApiCallback<List<CustomerPaymentSource>> callback) {
    Call<List<CustomerPaymentSource>> call = service.listCustomerPaymentSources();
    asyncCall(call, callback);
  }

  public void deleteCustomerPaymentSource(String customerPaymentSourceId) throws ApiException {
    Call<Void> call = service.deleteCustomerPaymentSource(customerPaymentSourceId);
    syncCall(call);
  }

  public void deleteCustomerPaymentSource(String customerPaymentSourceId,
      ApiCallback<Void> callback) {
    Call<Void> call = service.deleteCustomerPaymentSource(customerPaymentSourceId);
    asyncCall(call, callback);
  }

  public CustomerPaymentSource updateCustomerPaymentSource(String customerPaymentSourceId,
      CustomerPaymentSource customerPaymentSource) throws ApiException {
    Call<CustomerPaymentSource> call = service.updateCustomerPaymentSource(customerPaymentSourceId, customerPaymentSource);
    return syncCall(call);
  }

  public void updateCustomerPaymentSource(String customerPaymentSourceId,
      CustomerPaymentSource customerPaymentSource, ApiCallback<CustomerPaymentSource> callback) {
    Call<CustomerPaymentSource> call = service.updateCustomerPaymentSource(customerPaymentSourceId, customerPaymentSource);
    asyncCall(call, callback);
  }

  public CustomerPaymentSource retrieveCustomerPaymentSource(String customerPaymentSourceId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<CustomerPaymentSource> call = service.retrieveCustomerPaymentSource(customerPaymentSourceId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveCustomerPaymentSource(String customerPaymentSourceId,
      Map<String, String> queryStringParams, ApiCallback<CustomerPaymentSource> callback) {
    Call<CustomerPaymentSource> call = service.retrieveCustomerPaymentSource(customerPaymentSourceId, queryStringParams);
    asyncCall(call, callback);
  }

  public CustomerPaymentSource retrieveCustomerPaymentSource(String customerPaymentSourceId) throws
      ApiException {
    Call<CustomerPaymentSource> call = service.retrieveCustomerPaymentSource(customerPaymentSourceId);
    return syncCall(call);
  }

  public void retrieveCustomerPaymentSource(String customerPaymentSourceId,
      ApiCallback<CustomerPaymentSource> callback) {
    Call<CustomerPaymentSource> call = service.retrieveCustomerPaymentSource(customerPaymentSourceId);
    asyncCall(call, callback);
  }

  public Customer retrieveCustomerPaymentSourceCustomer(String customerPaymentSourceId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<Customer> call = service.retrieveCustomerPaymentSourceCustomer(customerPaymentSourceId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveCustomerPaymentSourceCustomer(String customerPaymentSourceId,
      Map<String, String> queryStringParams, ApiCallback<Customer> callback) {
    Call<Customer> call = service.retrieveCustomerPaymentSourceCustomer(customerPaymentSourceId, queryStringParams);
    asyncCall(call, callback);
  }

  public Customer retrieveCustomerPaymentSourceCustomer(String customerPaymentSourceId) throws
      ApiException {
    Call<Customer> call = service.retrieveCustomerPaymentSourceCustomer(customerPaymentSourceId);
    return syncCall(call);
  }

  public void retrieveCustomerPaymentSourceCustomer(String customerPaymentSourceId,
      ApiCallback<Customer> callback) {
    Call<Customer> call = service.retrieveCustomerPaymentSourceCustomer(customerPaymentSourceId);
    asyncCall(call, callback);
  }
}
