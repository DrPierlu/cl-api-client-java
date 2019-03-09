package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.common.query.QueryFilter;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.exception.ApiException;
import io.commercelayer.api.model.Sku;
import io.commercelayer.api.model.StockItem;
import io.commercelayer.api.model.StockLocation;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.StockItemService;
import java.util.List;
import retrofit2.Call;

public class StockItemServiceClient extends AbstractServiceClient<StockItemService> {
  {
    initServiceCallFactory(StockItemService.class, StockItem.class);
  }

  public StockItemServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
  }

  public StockItemServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
  }

  public List<StockItem> listStockItems(QueryFilter queryFilter) throws ApiException {
    Call<List<StockItem>> call = service.listStockItems(queryFilter);
    return syncCall(call);
  }

  public void listStockItems(QueryFilter queryFilter, ApiCallback<List<StockItem>> callback) {
    Call<List<StockItem>> call = service.listStockItems(queryFilter);
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

  public StockItem createStockItem(StockItem stockItem, QueryFilter queryFilter) throws
      ApiException {
    Call<StockItem> call = service.createStockItem(stockItem, queryFilter);
    return syncCall(call);
  }

  public void createStockItem(StockItem stockItem, QueryFilter queryFilter,
      ApiCallback<StockItem> callback) {
    Call<StockItem> call = service.createStockItem(stockItem, queryFilter);
    asyncCall(call, callback);
  }

  public StockItem createStockItem(StockItem stockItem) throws ApiException {
    Call<StockItem> call = service.createStockItem(stockItem);
    return syncCall(call);
  }

  public void createStockItem(StockItem stockItem, ApiCallback<StockItem> callback) {
    Call<StockItem> call = service.createStockItem(stockItem);
    asyncCall(call, callback);
  }

  public StockItem updateStockItem(String stockItemId, StockItem stockItem, QueryFilter queryFilter)
      throws ApiException {
    Call<StockItem> call = service.updateStockItem(stockItemId, stockItem, queryFilter);
    return syncCall(call);
  }

  public void updateStockItem(String stockItemId, StockItem stockItem, QueryFilter queryFilter,
      ApiCallback<StockItem> callback) {
    Call<StockItem> call = service.updateStockItem(stockItemId, stockItem, queryFilter);
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

  public StockItem retrieveStockItem(String stockItemId, QueryFilter queryFilter) throws
      ApiException {
    Call<StockItem> call = service.retrieveStockItem(stockItemId, queryFilter);
    return syncCall(call);
  }

  public void retrieveStockItem(String stockItemId, QueryFilter queryFilter,
      ApiCallback<StockItem> callback) {
    Call<StockItem> call = service.retrieveStockItem(stockItemId, queryFilter);
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

  public void deleteStockItem(String stockItemId) throws ApiException {
    Call<Void> call = service.deleteStockItem(stockItemId);
    syncCall(call);
  }

  public void deleteStockItem(String stockItemId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteStockItem(stockItemId);
    asyncCall(call, callback);
  }

  public Sku retrieveStockItemSku(String stockItemId, QueryFilter queryFilter) throws ApiException {
    Call<Sku> call = service.retrieveStockItemSku(stockItemId, queryFilter);
    return syncCall(call);
  }

  public void retrieveStockItemSku(String stockItemId, QueryFilter queryFilter,
      ApiCallback<Sku> callback) {
    Call<Sku> call = service.retrieveStockItemSku(stockItemId, queryFilter);
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

  public StockLocation retrieveStockItemStockLocation(String stockItemId, QueryFilter queryFilter)
      throws ApiException {
    Call<StockLocation> call = service.retrieveStockItemStockLocation(stockItemId, queryFilter);
    return syncCall(call);
  }

  public void retrieveStockItemStockLocation(String stockItemId, QueryFilter queryFilter,
      ApiCallback<StockLocation> callback) {
    Call<StockLocation> call = service.retrieveStockItemStockLocation(stockItemId, queryFilter);
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
