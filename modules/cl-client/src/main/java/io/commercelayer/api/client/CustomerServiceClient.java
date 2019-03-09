package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.common.query.QueryFilter;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.exception.ApiException;
import io.commercelayer.api.model.Customer;
import io.commercelayer.api.model.CustomerAddress;
import io.commercelayer.api.model.CustomerGroup;
import io.commercelayer.api.model.CustomerPaymentSource;
import io.commercelayer.api.model.CustomerSubscription;
import io.commercelayer.api.model.Order;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.CustomerService;
import java.util.List;
import retrofit2.Call;

public class CustomerServiceClient extends AbstractServiceClient<CustomerService> {
  {
    initServiceCallFactory(CustomerService.class, Customer.class);
  }

  public CustomerServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
  }

  public CustomerServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
  }

  public List<Customer> listCustomers(QueryFilter queryFilter) throws ApiException {
    Call<List<Customer>> call = service.listCustomers(queryFilter);
    return syncCall(call);
  }

  public void listCustomers(QueryFilter queryFilter, ApiCallback<List<Customer>> callback) {
    Call<List<Customer>> call = service.listCustomers(queryFilter);
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

  public Customer createCustomer(Customer customer, QueryFilter queryFilter) throws ApiException {
    Call<Customer> call = service.createCustomer(customer, queryFilter);
    return syncCall(call);
  }

  public void createCustomer(Customer customer, QueryFilter queryFilter,
      ApiCallback<Customer> callback) {
    Call<Customer> call = service.createCustomer(customer, queryFilter);
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

  public Customer updateCustomer(String customerId, Customer customer, QueryFilter queryFilter)
      throws ApiException {
    Call<Customer> call = service.updateCustomer(customerId, customer, queryFilter);
    return syncCall(call);
  }

  public void updateCustomer(String customerId, Customer customer, QueryFilter queryFilter,
      ApiCallback<Customer> callback) {
    Call<Customer> call = service.updateCustomer(customerId, customer, queryFilter);
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

  public Customer retrieveCustomer(String customerId, QueryFilter queryFilter) throws ApiException {
    Call<Customer> call = service.retrieveCustomer(customerId, queryFilter);
    return syncCall(call);
  }

  public void retrieveCustomer(String customerId, QueryFilter queryFilter,
      ApiCallback<Customer> callback) {
    Call<Customer> call = service.retrieveCustomer(customerId, queryFilter);
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

  public void deleteCustomer(String customerId) throws ApiException {
    Call<Void> call = service.deleteCustomer(customerId);
    syncCall(call);
  }

  public void deleteCustomer(String customerId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteCustomer(customerId);
    asyncCall(call, callback);
  }

  public List<CustomerAddress> listCustomerCustomerAddresses(String customerId,
      QueryFilter queryFilter) throws ApiException {
    Call<List<CustomerAddress>> call = service.listCustomerCustomerAddresses(customerId, queryFilter);
    return syncCall(call);
  }

  public void listCustomerCustomerAddresses(String customerId, QueryFilter queryFilter,
      ApiCallback<List<CustomerAddress>> callback) {
    Call<List<CustomerAddress>> call = service.listCustomerCustomerAddresses(customerId, queryFilter);
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

  public CustomerGroup retrieveCustomerCustomerGroup(String customerId, QueryFilter queryFilter)
      throws ApiException {
    Call<CustomerGroup> call = service.retrieveCustomerCustomerGroup(customerId, queryFilter);
    return syncCall(call);
  }

  public void retrieveCustomerCustomerGroup(String customerId, QueryFilter queryFilter,
      ApiCallback<CustomerGroup> callback) {
    Call<CustomerGroup> call = service.retrieveCustomerCustomerGroup(customerId, queryFilter);
    asyncCall(call, callback);
  }

  public CustomerGroup retrieveCustomerCustomerGroup(String customerId) throws ApiException {
    Call<CustomerGroup> call = service.retrieveCustomerCustomerGroup(customerId);
    return syncCall(call);
  }

  public void retrieveCustomerCustomerGroup(String customerId,
      ApiCallback<CustomerGroup> callback) {
    Call<CustomerGroup> call = service.retrieveCustomerCustomerGroup(customerId);
    asyncCall(call, callback);
  }

  public List<CustomerPaymentSource> listCustomerCustomerPaymentSources(String customerId,
      QueryFilter queryFilter) throws ApiException {
    Call<List<CustomerPaymentSource>> call = service.listCustomerCustomerPaymentSources(customerId, queryFilter);
    return syncCall(call);
  }

  public void listCustomerCustomerPaymentSources(String customerId, QueryFilter queryFilter,
      ApiCallback<List<CustomerPaymentSource>> callback) {
    Call<List<CustomerPaymentSource>> call = service.listCustomerCustomerPaymentSources(customerId, queryFilter);
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
      QueryFilter queryFilter) throws ApiException {
    Call<List<CustomerSubscription>> call = service.listCustomerCustomerSubscriptions(customerId, queryFilter);
    return syncCall(call);
  }

  public void listCustomerCustomerSubscriptions(String customerId, QueryFilter queryFilter,
      ApiCallback<List<CustomerSubscription>> callback) {
    Call<List<CustomerSubscription>> call = service.listCustomerCustomerSubscriptions(customerId, queryFilter);
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

  public List<Order> listCustomerOrders(String customerId, QueryFilter queryFilter) throws
      ApiException {
    Call<List<Order>> call = service.listCustomerOrders(customerId, queryFilter);
    return syncCall(call);
  }

  public void listCustomerOrders(String customerId, QueryFilter queryFilter,
      ApiCallback<List<Order>> callback) {
    Call<List<Order>> call = service.listCustomerOrders(customerId, queryFilter);
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
