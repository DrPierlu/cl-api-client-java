package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.Sku;
import io.commercelayer.api.model.StockItem;
import io.commercelayer.api.model.StockLocation;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.StockItemService;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

public class StockItemServiceClient extends AbstractServiceClient {
  protected StockItemService service;

  public StockItemServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
    this.service = apiCaller.getServiceCallFactory(StockItemService.class, StockItem.class);
  }

  public StockItemServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
    this.service = apiCaller.getServiceCallFactory(StockItemService.class, StockItem.class);
  }

  public StockItem createStockItem(StockItem stockItem) throws ApiException {
    Call<StockItem> call = service.createStockItem(stockItem);
    return syncCall(call);
  }

  public void createStockItem(StockItem stockItem, ApiCallback<StockItem> callback) {
    Call<StockItem> call = service.createStockItem(stockItem);
    asyncCall(call, callback);
  }

  public List<StockItem> listStockItems(Map<String, String> queryStringParams) throws ApiException {
    Call<List<StockItem>> call = service.listStockItems(queryStringParams);
    return syncCall(call);
  }

  public void listStockItems(Map<String, String> queryStringParams,
      ApiCallback<List<StockItem>> callback) {
    Call<List<StockItem>> call = service.listStockItems(queryStringParams);
    asyncCall(call, callback);
  }

  public List<StockItem> listStockItems() throws ApiException {
    Call<List<StockItem>> call = service.listStockItems();
    return syncCall(call);
  }

  public void listStockItems(ApiCallback<List<StockItem>> callback) {
    Call<List<StockItem>> call = service.listStockItems();
    asyncCall(call, callback);
  }

  public void deleteStockItem(String stockItemId) throws ApiException {
    Call<Void> call = service.deleteStockItem(stockItemId);
    syncCall(call);
  }

  public void deleteStockItem(String stockItemId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteStockItem(stockItemId);
    asyncCall(call, callback);
  }

  public StockItem updateStockItem(String stockItemId, StockItem stockItem) throws ApiException {
    Call<StockItem> call = service.updateStockItem(stockItemId, stockItem);
    return syncCall(call);
  }

  public void updateStockItem(String stockItemId, StockItem stockItem,
      ApiCallback<StockItem> callback) {
    Call<StockItem> call = service.updateStockItem(stockItemId, stockItem);
    asyncCall(call, callback);
  }

  public StockItem retrieveStockItem(String stockItemId, Map<String, String> queryStringParams)
      throws ApiException {
    Call<StockItem> call = service.retrieveStockItem(stockItemId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveStockItem(String stockItemId, Map<String, String> queryStringParams,
      ApiCallback<StockItem> callback) {
    Call<StockItem> call = service.retrieveStockItem(stockItemId, queryStringParams);
    asyncCall(call, callback);
  }

  public StockItem retrieveStockItem(String stockItemId) throws ApiException {
    Call<StockItem> call = service.retrieveStockItem(stockItemId);
    return syncCall(call);
  }

  public void retrieveStockItem(String stockItemId, ApiCallback<StockItem> callback) {
    Call<StockItem> call = service.retrieveStockItem(stockItemId);
    asyncCall(call, callback);
  }

  public Sku retrieveStockItemSku(String stockItemId, Map<String, String> queryStringParams) throws
      ApiException {
    Call<Sku> call = service.retrieveStockItemSku(stockItemId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveStockItemSku(String stockItemId, Map<String, String> queryStringParams,
      ApiCallback<Sku> callback) {
    Call<Sku> call = service.retrieveStockItemSku(stockItemId, queryStringParams);
    asyncCall(call, callback);
  }

  public Sku retrieveStockItemSku(String stockItemId) throws ApiException {
    Call<Sku> call = service.retrieveStockItemSku(stockItemId);
    return syncCall(call);
  }

  public void retrieveStockItemSku(String stockItemId, ApiCallback<Sku> callback) {
    Call<Sku> call = service.retrieveStockItemSku(stockItemId);
    asyncCall(call, callback);
  }

  public StockLocation retrieveStockItemStockLocation(String stockItemId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<StockLocation> call = service.retrieveStockItemStockLocation(stockItemId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveStockItemStockLocation(String stockItemId,
      Map<String, String> queryStringParams, ApiCallback<StockLocation> callback) {
    Call<StockLocation> call = service.retrieveStockItemStockLocation(stockItemId, queryStringParams);
    asyncCall(call, callback);
  }

  public StockLocation retrieveStockItemStockLocation(String stockItemId) throws ApiException {
    Call<StockLocation> call = service.retrieveStockItemStockLocation(stockItemId);
    return syncCall(call);
  }

  public void retrieveStockItemStockLocation(String stockItemId,
      ApiCallback<StockLocation> callback) {
    Call<StockLocation> call = service.retrieveStockItemStockLocation(stockItemId);
    asyncCall(call, callback);
  }
}
