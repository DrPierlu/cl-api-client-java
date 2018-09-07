package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.Customer;
import io.commercelayer.api.model.CustomerSubscription;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.CustomerSubscriptionService;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

public class CustomerSubscriptionServiceClient extends AbstractServiceClient {
  protected final CustomerSubscriptionService service;

  {
    this.service = initServiceCallFactory(CustomerSubscriptionService.class, CustomerSubscription.class);
  }

  public CustomerSubscriptionServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws
      AuthException {
    super(apiOrg, apiAuth);
  }

  public CustomerSubscriptionServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws
      AuthException {
    super(apiOrg, apiToken);
  }

  public List<CustomerSubscription> listCustomerSubscriptions(Map<String, String> queryStringParams)
      throws ApiException {
    Call<List<CustomerSubscription>> call = service.listCustomerSubscriptions(queryStringParams);
    return syncCall(call);
  }

  public void listCustomerSubscriptions(Map<String, String> queryStringParams,
      ApiCallback<List<CustomerSubscription>> callback) {
    Call<List<CustomerSubscription>> call = service.listCustomerSubscriptions(queryStringParams);
    asyncCall(call, callback);
  }

  public List<CustomerSubscription> listCustomerSubscriptions() throws ApiException {
    Call<List<CustomerSubscription>> call = service.listCustomerSubscriptions();
    return syncCall(call);
  }

  public void listCustomerSubscriptions(ApiCallback<List<CustomerSubscription>> callback) {
    Call<List<CustomerSubscription>> call = service.listCustomerSubscriptions();
    asyncCall(call, callback);
  }

  public CustomerSubscription createCustomerSubscription(CustomerSubscription customerSubscription)
      throws ApiException {
    Call<CustomerSubscription> call = service.createCustomerSubscription(customerSubscription);
    return syncCall(call);
  }

  public void createCustomerSubscription(CustomerSubscription customerSubscription,
      ApiCallback<CustomerSubscription> callback) {
    Call<CustomerSubscription> call = service.createCustomerSubscription(customerSubscription);
    asyncCall(call, callback);
  }

  public void deleteCustomerSubscription(String customerSubscriptionId) throws ApiException {
    Call<Void> call = service.deleteCustomerSubscription(customerSubscriptionId);
    syncCall(call);
  }

  public void deleteCustomerSubscription(String customerSubscriptionId,
      ApiCallback<Void> callback) {
    Call<Void> call = service.deleteCustomerSubscription(customerSubscriptionId);
    asyncCall(call, callback);
  }

  public CustomerSubscription updateCustomerSubscription(String customerSubscriptionId,
      CustomerSubscription customerSubscription) throws ApiException {
    Call<CustomerSubscription> call = service.updateCustomerSubscription(customerSubscriptionId, customerSubscription);
    return syncCall(call);
  }

  public void updateCustomerSubscription(String customerSubscriptionId,
      CustomerSubscription customerSubscription, ApiCallback<CustomerSubscription> callback) {
    Call<CustomerSubscription> call = service.updateCustomerSubscription(customerSubscriptionId, customerSubscription);
    asyncCall(call, callback);
  }

  public CustomerSubscription retrieveCustomerSubscription(String customerSubscriptionId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<CustomerSubscription> call = service.retrieveCustomerSubscription(customerSubscriptionId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveCustomerSubscription(String customerSubscriptionId,
      Map<String, String> queryStringParams, ApiCallback<CustomerSubscription> callback) {
    Call<CustomerSubscription> call = service.retrieveCustomerSubscription(customerSubscriptionId, queryStringParams);
    asyncCall(call, callback);
  }

  public CustomerSubscription retrieveCustomerSubscription(String customerSubscriptionId) throws
      ApiException {
    Call<CustomerSubscription> call = service.retrieveCustomerSubscription(customerSubscriptionId);
    return syncCall(call);
  }

  public void retrieveCustomerSubscription(String customerSubscriptionId,
      ApiCallback<CustomerSubscription> callback) {
    Call<CustomerSubscription> call = service.retrieveCustomerSubscription(customerSubscriptionId);
    asyncCall(call, callback);
  }

  public Customer retrieveCustomerSubscriptionCustomer(String customerSubscriptionId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<Customer> call = service.retrieveCustomerSubscriptionCustomer(customerSubscriptionId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveCustomerSubscriptionCustomer(String customerSubscriptionId,
      Map<String, String> queryStringParams, ApiCallback<Customer> callback) {
    Call<Customer> call = service.retrieveCustomerSubscriptionCustomer(customerSubscriptionId, queryStringParams);
    asyncCall(call, callback);
  }

  public Customer retrieveCustomerSubscriptionCustomer(String customerSubscriptionId) throws
      ApiException {
    Call<Customer> call = service.retrieveCustomerSubscriptionCustomer(customerSubscriptionId);
    return syncCall(call);
  }

  public void retrieveCustomerSubscriptionCustomer(String customerSubscriptionId,
      ApiCallback<Customer> callback) {
    Call<Customer> call = service.retrieveCustomerSubscriptionCustomer(customerSubscriptionId);
    asyncCall(call, callback);
  }
}
