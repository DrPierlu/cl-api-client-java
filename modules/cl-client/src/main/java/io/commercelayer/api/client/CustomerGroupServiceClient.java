package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.common.query.QueryFilter;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.exception.ApiException;
import io.commercelayer.api.model.Customer;
import io.commercelayer.api.model.CustomerGroup;
import io.commercelayer.api.model.PriceList;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.CustomerGroupService;
import java.util.List;
import retrofit2.Call;

public class CustomerGroupServiceClient extends AbstractServiceClient<CustomerGroupService> {
  {
    initServiceCallFactory(CustomerGroupService.class, CustomerGroup.class);
  }

  public CustomerGroupServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
  }

  public CustomerGroupServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws
      AuthException {
    super(apiOrg, apiToken);
  }

  public List<CustomerGroup> listCustomerGroups(QueryFilter queryFilter) throws ApiException {
    Call<List<CustomerGroup>> call = service.listCustomerGroups(queryFilter);
    return syncCall(call);
  }

  public void listCustomerGroups(QueryFilter queryFilter,
      ApiCallback<List<CustomerGroup>> callback) {
    Call<List<CustomerGroup>> call = service.listCustomerGroups(queryFilter);
    asyncCall(call, callback);
  }

  public List<CustomerGroup> listCustomerGroups() throws ApiException {
    Call<List<CustomerGroup>> call = service.listCustomerGroups();
    return syncCall(call);
  }

  public void listCustomerGroups(ApiCallback<List<CustomerGroup>> callback) {
    Call<List<CustomerGroup>> call = service.listCustomerGroups();
    asyncCall(call, callback);
  }

  public CustomerGroup createCustomerGroup(CustomerGroup customerGroup) throws ApiException {
    Call<CustomerGroup> call = service.createCustomerGroup(customerGroup);
    return syncCall(call);
  }

  public void createCustomerGroup(CustomerGroup customerGroup,
      ApiCallback<CustomerGroup> callback) {
    Call<CustomerGroup> call = service.createCustomerGroup(customerGroup);
    asyncCall(call, callback);
  }

  public CustomerGroup updateCustomerGroup(String customerGroupId, CustomerGroup customerGroup)
      throws ApiException {
    Call<CustomerGroup> call = service.updateCustomerGroup(customerGroupId, customerGroup);
    return syncCall(call);
  }

  public void updateCustomerGroup(String customerGroupId, CustomerGroup customerGroup,
      ApiCallback<CustomerGroup> callback) {
    Call<CustomerGroup> call = service.updateCustomerGroup(customerGroupId, customerGroup);
    asyncCall(call, callback);
  }

  public CustomerGroup retrieveCustomerGroup(String customerGroupId, QueryFilter queryFilter) throws
      ApiException {
    Call<CustomerGroup> call = service.retrieveCustomerGroup(customerGroupId, queryFilter);
    return syncCall(call);
  }

  public void retrieveCustomerGroup(String customerGroupId, QueryFilter queryFilter,
      ApiCallback<CustomerGroup> callback) {
    Call<CustomerGroup> call = service.retrieveCustomerGroup(customerGroupId, queryFilter);
    asyncCall(call, callback);
  }

  public CustomerGroup retrieveCustomerGroup(String customerGroupId) throws ApiException {
    Call<CustomerGroup> call = service.retrieveCustomerGroup(customerGroupId);
    return syncCall(call);
  }

  public void retrieveCustomerGroup(String customerGroupId, ApiCallback<CustomerGroup> callback) {
    Call<CustomerGroup> call = service.retrieveCustomerGroup(customerGroupId);
    asyncCall(call, callback);
  }

  public void deleteCustomerGroup(String customerGroupId) throws ApiException {
    Call<Void> call = service.deleteCustomerGroup(customerGroupId);
    syncCall(call);
  }

  public void deleteCustomerGroup(String customerGroupId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteCustomerGroup(customerGroupId);
    asyncCall(call, callback);
  }

  public List<Customer> listCustomerGroupCustomers(String customerGroupId, QueryFilter queryFilter)
      throws ApiException {
    Call<List<Customer>> call = service.listCustomerGroupCustomers(customerGroupId, queryFilter);
    return syncCall(call);
  }

  public void listCustomerGroupCustomers(String customerGroupId, QueryFilter queryFilter,
      ApiCallback<List<Customer>> callback) {
    Call<List<Customer>> call = service.listCustomerGroupCustomers(customerGroupId, queryFilter);
    asyncCall(call, callback);
  }

  public List<Customer> listCustomerGroupCustomers(String customerGroupId) throws ApiException {
    Call<List<Customer>> call = service.listCustomerGroupCustomers(customerGroupId);
    return syncCall(call);
  }

  public void listCustomerGroupCustomers(String customerGroupId,
      ApiCallback<List<Customer>> callback) {
    Call<List<Customer>> call = service.listCustomerGroupCustomers(customerGroupId);
    asyncCall(call, callback);
  }

  public PriceList retrieveCustomerGroupPriceList(String customerGroupId, QueryFilter queryFilter)
      throws ApiException {
    Call<PriceList> call = service.retrieveCustomerGroupPriceList(customerGroupId, queryFilter);
    return syncCall(call);
  }

  public void retrieveCustomerGroupPriceList(String customerGroupId, QueryFilter queryFilter,
      ApiCallback<PriceList> callback) {
    Call<PriceList> call = service.retrieveCustomerGroupPriceList(customerGroupId, queryFilter);
    asyncCall(call, callback);
  }

  public PriceList retrieveCustomerGroupPriceList(String customerGroupId) throws ApiException {
    Call<PriceList> call = service.retrieveCustomerGroupPriceList(customerGroupId);
    return syncCall(call);
  }

  public void retrieveCustomerGroupPriceList(String customerGroupId,
      ApiCallback<PriceList> callback) {
    Call<PriceList> call = service.retrieveCustomerGroupPriceList(customerGroupId);
    asyncCall(call, callback);
  }
}
