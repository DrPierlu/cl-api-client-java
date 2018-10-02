package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.common.QueryFilter;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.LineItem;
import io.commercelayer.api.model.LineItemOption;
import io.commercelayer.api.model.Order;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.LineItemService;
import java.util.List;
import retrofit2.Call;

public class LineItemServiceClient extends AbstractServiceClient {
  protected final LineItemService service;

  {
    this.service = initServiceCallFactory(LineItemService.class, LineItem.class);
  }

  public LineItemServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
  }

  public LineItemServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
  }

  public List<LineItem> listLineItems(QueryFilter queryFilter) throws ApiException {
    Call<List<LineItem>> call = service.listLineItems(queryFilter);
    return syncCall(call);
  }

  public void listLineItems(QueryFilter queryFilter, ApiCallback<List<LineItem>> callback) {
    Call<List<LineItem>> call = service.listLineItems(queryFilter);
    asyncCall(call, callback);
  }

  public List<LineItem> listLineItems() throws ApiException {
    Call<List<LineItem>> call = service.listLineItems();
    return syncCall(call);
  }

  public void listLineItems(ApiCallback<List<LineItem>> callback) {
    Call<List<LineItem>> call = service.listLineItems();
    asyncCall(call, callback);
  }

  public LineItem createLineItem(LineItem lineItem) throws ApiException {
    Call<LineItem> call = service.createLineItem(lineItem);
    return syncCall(call);
  }

  public void createLineItem(LineItem lineItem, ApiCallback<LineItem> callback) {
    Call<LineItem> call = service.createLineItem(lineItem);
    asyncCall(call, callback);
  }

  public void deleteLineItem(String lineItemId) throws ApiException {
    Call<Void> call = service.deleteLineItem(lineItemId);
    syncCall(call);
  }

  public void deleteLineItem(String lineItemId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteLineItem(lineItemId);
    asyncCall(call, callback);
  }

  public LineItem updateLineItem(String lineItemId, LineItem lineItem) throws ApiException {
    Call<LineItem> call = service.updateLineItem(lineItemId, lineItem);
    return syncCall(call);
  }

  public void updateLineItem(String lineItemId, LineItem lineItem, ApiCallback<LineItem> callback) {
    Call<LineItem> call = service.updateLineItem(lineItemId, lineItem);
    asyncCall(call, callback);
  }

  public LineItem retrieveLineItem(String lineItemId, QueryFilter queryFilter) throws ApiException {
    Call<LineItem> call = service.retrieveLineItem(lineItemId, queryFilter);
    return syncCall(call);
  }

  public void retrieveLineItem(String lineItemId, QueryFilter queryFilter,
      ApiCallback<LineItem> callback) {
    Call<LineItem> call = service.retrieveLineItem(lineItemId, queryFilter);
    asyncCall(call, callback);
  }

  public LineItem retrieveLineItem(String lineItemId) throws ApiException {
    Call<LineItem> call = service.retrieveLineItem(lineItemId);
    return syncCall(call);
  }

  public void retrieveLineItem(String lineItemId, ApiCallback<LineItem> callback) {
    Call<LineItem> call = service.retrieveLineItem(lineItemId);
    asyncCall(call, callback);
  }

  public List<LineItemOption> listLineItemLineItemOptions(String lineItemId,
      QueryFilter queryFilter) throws ApiException {
    Call<List<LineItemOption>> call = service.listLineItemLineItemOptions(lineItemId, queryFilter);
    return syncCall(call);
  }

  public void listLineItemLineItemOptions(String lineItemId, QueryFilter queryFilter,
      ApiCallback<List<LineItemOption>> callback) {
    Call<List<LineItemOption>> call = service.listLineItemLineItemOptions(lineItemId, queryFilter);
    asyncCall(call, callback);
  }

  public List<LineItemOption> listLineItemLineItemOptions(String lineItemId) throws ApiException {
    Call<List<LineItemOption>> call = service.listLineItemLineItemOptions(lineItemId);
    return syncCall(call);
  }

  public void listLineItemLineItemOptions(String lineItemId,
      ApiCallback<List<LineItemOption>> callback) {
    Call<List<LineItemOption>> call = service.listLineItemLineItemOptions(lineItemId);
    asyncCall(call, callback);
  }

  public Order retrieveLineItemOrder(String lineItemId, QueryFilter queryFilter) throws
      ApiException {
    Call<Order> call = service.retrieveLineItemOrder(lineItemId, queryFilter);
    return syncCall(call);
  }

  public void retrieveLineItemOrder(String lineItemId, QueryFilter queryFilter,
      ApiCallback<Order> callback) {
    Call<Order> call = service.retrieveLineItemOrder(lineItemId, queryFilter);
    asyncCall(call, callback);
  }

  public Order retrieveLineItemOrder(String lineItemId) throws ApiException {
    Call<Order> call = service.retrieveLineItemOrder(lineItemId);
    return syncCall(call);
  }

  public void retrieveLineItemOrder(String lineItemId, ApiCallback<Order> callback) {
    Call<Order> call = service.retrieveLineItemOrder(lineItemId);
    asyncCall(call, callback);
  }
}
