package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.LineItem;
import io.commercelayer.api.model.LineItemOption;
import io.commercelayer.api.model.Order;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.LineItemService;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

public class LineItemServiceClient extends AbstractServiceClient {
  protected LineItemService service;

  public LineItemServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
    this.service = apiCaller.getServiceCallFactory(LineItemService.class, LineItem.class);
  }

  public LineItemServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
    this.service = apiCaller.getServiceCallFactory(LineItemService.class, LineItem.class);
  }

  public List<LineItem> listLineItems(Map<String, String> queryStringParams) throws ApiException {
    Call<List<LineItem>> call = service.listLineItems(queryStringParams);
    return syncCall(call);
  }

  public void listLineItems(Map<String, String> queryStringParams,
      ApiCallback<List<LineItem>> callback) {
    Call<List<LineItem>> call = service.listLineItems(queryStringParams);
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

  public LineItem retrieveLineItem(String lineItemId, Map<String, String> queryStringParams) throws
      ApiException {
    Call<LineItem> call = service.retrieveLineItem(lineItemId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveLineItem(String lineItemId, Map<String, String> queryStringParams,
      ApiCallback<LineItem> callback) {
    Call<LineItem> call = service.retrieveLineItem(lineItemId, queryStringParams);
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
      Map<String, String> queryStringParams) throws ApiException {
    Call<List<LineItemOption>> call = service.listLineItemLineItemOptions(lineItemId, queryStringParams);
    return syncCall(call);
  }

  public void listLineItemLineItemOptions(String lineItemId, Map<String, String> queryStringParams,
      ApiCallback<List<LineItemOption>> callback) {
    Call<List<LineItemOption>> call = service.listLineItemLineItemOptions(lineItemId, queryStringParams);
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

  public Order retrieveLineItemOrder(String lineItemId, Map<String, String> queryStringParams)
      throws ApiException {
    Call<Order> call = service.retrieveLineItemOrder(lineItemId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveLineItemOrder(String lineItemId, Map<String, String> queryStringParams,
      ApiCallback<Order> callback) {
    Call<Order> call = service.retrieveLineItemOrder(lineItemId, queryStringParams);
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
