package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.Customer;
import io.commercelayer.api.model.CustomerAddress;
import io.commercelayer.api.model.CustomerPaymentSource;
import io.commercelayer.api.model.CustomerSubscription;
import io.commercelayer.api.model.Order;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.CustomerService;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

public class CustomerServiceClient extends AbstractServiceClient {
  protected CustomerService service;

  public CustomerServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
    this.service = apiCaller.getServiceCallFactory(CustomerService.class, Customer.class);
  }

  public CustomerServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
    this.service = apiCaller.getServiceCallFactory(CustomerService.class, Customer.class);
  }

  public List<Customer> listCustomers(Map<String, String> queryStringParams) throws ApiException {
    Call<List<Customer>> call = service.listCustomers(queryStringParams);
    return syncCall(call);
  }

  public void listCustomers(Map<String, String> queryStringParams,
      ApiCallback<List<Customer>> callback) {
    Call<List<Customer>> call = service.listCustomers(queryStringParams);
    asyncCall(call, callback);
  }

  public List<Customer> listCustomers() throws ApiException {
    Call<List<Customer>> call = service.listCustomers();
    return syncCall(call);
  }

  public void listCustomers(ApiCallback<List<Customer>> callback) {
    Call<List<Customer>> call = service.listCustomers();
    asyncCall(call, callback);
  }

  public Customer createCustomer(Customer customer) throws ApiException {
    Call<Customer> call = service.createCustomer(customer);
    return syncCall(call);
  }

  public void createCustomer(Customer customer, ApiCallback<Customer> callback) {
    Call<Customer> call = service.createCustomer(customer);
    asyncCall(call, callback);
  }

  public void deleteCustomer(String customerId) throws ApiException {
    Call<Void> call = service.deleteCustomer(customerId);
    syncCall(call);
  }

  public void deleteCustomer(String customerId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteCustomer(customerId);
    asyncCall(call, callback);
  }

  public Customer updateCustomer(String customerId, Customer customer) throws ApiException {
    Call<Customer> call = service.updateCustomer(customerId, customer);
    return syncCall(call);
  }

  public void updateCustomer(String customerId, Customer customer, ApiCallback<Customer> callback) {
    Call<Customer> call = service.updateCustomer(customerId, customer);
    asyncCall(call, callback);
  }

  public Customer retrieveCustomer(String customerId, Map<String, String> queryStringParams) throws
      ApiException {
    Call<Customer> call = service.retrieveCustomer(customerId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveCustomer(String customerId, Map<String, String> queryStringParams,
      ApiCallback<Customer> callback) {
    Call<Customer> call = service.retrieveCustomer(customerId, queryStringParams);
    asyncCall(call, callback);
  }

  public Customer retrieveCustomer(String customerId) throws ApiException {
    Call<Customer> call = service.retrieveCustomer(customerId);
    return syncCall(call);
  }

  public void retrieveCustomer(String customerId, ApiCallback<Customer> callback) {
    Call<Customer> call = service.retrieveCustomer(customerId);
    asyncCall(call, callback);
  }

  public List<CustomerAddress> listCustomerCustomerAddresses(String customerId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<List<CustomerAddress>> call = service.listCustomerCustomerAddresses(customerId, queryStringParams);
    return syncCall(call);
  }

  public void listCustomerCustomerAddresses(String customerId,
      Map<String, String> queryStringParams, ApiCallback<List<CustomerAddress>> callback) {
    Call<List<CustomerAddress>> call = service.listCustomerCustomerAddresses(customerId, queryStringParams);
    asyncCall(call, callback);
  }

  public List<CustomerAddress> listCustomerCustomerAddresses(String customerId) throws
      ApiException {
    Call<List<CustomerAddress>> call = service.listCustomerCustomerAddresses(customerId);
    return syncCall(call);
  }

  public void listCustomerCustomerAddresses(String customerId,
      ApiCallback<List<CustomerAddress>> callback) {
    Call<List<CustomerAddress>> call = service.listCustomerCustomerAddresses(customerId);
    asyncCall(call, callback);
  }

  public List<CustomerPaymentSource> listCustomerCustomerPaymentSources(String customerId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<List<CustomerPaymentSource>> call = service.listCustomerCustomerPaymentSources(customerId, queryStringParams);
    return syncCall(call);
  }

  public void listCustomerCustomerPaymentSources(String customerId,
      Map<String, String> queryStringParams, ApiCallback<List<CustomerPaymentSource>> callback) {
    Call<List<CustomerPaymentSource>> call = service.listCustomerCustomerPaymentSources(customerId, queryStringParams);
    asyncCall(call, callback);
  }

  public List<CustomerPaymentSource> listCustomerCustomerPaymentSources(String customerId) throws
      ApiException {
    Call<List<CustomerPaymentSource>> call = service.listCustomerCustomerPaymentSources(customerId);
    return syncCall(call);
  }

  public void listCustomerCustomerPaymentSources(String customerId,
      ApiCallback<List<CustomerPaymentSource>> callback) {
    Call<List<CustomerPaymentSource>> call = service.listCustomerCustomerPaymentSources(customerId);
    asyncCall(call, callback);
  }

  public List<CustomerSubscription> listCustomerCustomerSubscriptions(String customerId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<List<CustomerSubscription>> call = service.listCustomerCustomerSubscriptions(customerId, queryStringParams);
    return syncCall(call);
  }

  public void listCustomerCustomerSubscriptions(String customerId,
      Map<String, String> queryStringParams, ApiCallback<List<CustomerSubscription>> callback) {
    Call<List<CustomerSubscription>> call = service.listCustomerCustomerSubscriptions(customerId, queryStringParams);
    asyncCall(call, callback);
  }

  public List<CustomerSubscription> listCustomerCustomerSubscriptions(String customerId) throws
      ApiException {
    Call<List<CustomerSubscription>> call = service.listCustomerCustomerSubscriptions(customerId);
    return syncCall(call);
  }

  public void listCustomerCustomerSubscriptions(String customerId,
      ApiCallback<List<CustomerSubscription>> callback) {
    Call<List<CustomerSubscription>> call = service.listCustomerCustomerSubscriptions(customerId);
    asyncCall(call, callback);
  }

  public List<Order> listCustomerOrders(String customerId, Map<String, String> queryStringParams)
      throws ApiException {
    Call<List<Order>> call = service.listCustomerOrders(customerId, queryStringParams);
    return syncCall(call);
  }

  public void listCustomerOrders(String customerId, Map<String, String> queryStringParams,
      ApiCallback<List<Order>> callback) {
    Call<List<Order>> call = service.listCustomerOrders(customerId, queryStringParams);
    asyncCall(call, callback);
  }

  public List<Order> listCustomerOrders(String customerId) throws ApiException {
    Call<List<Order>> call = service.listCustomerOrders(customerId);
    return syncCall(call);
  }

  public void listCustomerOrders(String customerId, ApiCallback<List<Order>> callback) {
    Call<List<Order>> call = service.listCustomerOrders(customerId);
    asyncCall(call, callback);
  }
}
