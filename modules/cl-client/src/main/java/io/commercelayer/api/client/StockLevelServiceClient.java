package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.common.QueryFilter;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.exception.ApiException;
import io.commercelayer.api.model.InventoryModel;
import io.commercelayer.api.model.StockLevel;
import io.commercelayer.api.model.StockLocation;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.StockLevelService;
import java.util.List;
import retrofit2.Call;

public class StockLevelServiceClient extends AbstractServiceClient<StockLevelService> {
  {
    initServiceCallFactory(StockLevelService.class, StockLevel.class);
  }

  public StockLevelServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
  }

  public StockLevelServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
  }

  public List<StockLevel> listStockLevels(QueryFilter queryFilter) throws ApiException {
    Call<List<StockLevel>> call = service.listStockLevels(queryFilter);
    return syncCall(call);
  }

  public void listStockLevels(QueryFilter queryFilter, ApiCallback<List<StockLevel>> callback) {
    Call<List<StockLevel>> call = service.listStockLevels(queryFilter);
    asyncCall(call, callback);
  }

  public List<StockLevel> listStockLevels() throws ApiException {
    Call<List<StockLevel>> call = service.listStockLevels();
    return syncCall(call);
  }

  public void listStockLevels(ApiCallback<List<StockLevel>> callback) {
    Call<List<StockLevel>> call = service.listStockLevels();
    asyncCall(call, callback);
  }

  public StockLevel createStockLevel(StockLevel stockLevel) throws ApiException {
    Call<StockLevel> call = service.createStockLevel(stockLevel);
    return syncCall(call);
  }

  public void createStockLevel(StockLevel stockLevel, ApiCallback<StockLevel> callback) {
    Call<StockLevel> call = service.createStockLevel(stockLevel);
    asyncCall(call, callback);
  }

  public StockLevel updateStockLevel(String stockLevelId, StockLevel stockLevel) throws
      ApiException {
    Call<StockLevel> call = service.updateStockLevel(stockLevelId, stockLevel);
    return syncCall(call);
  }

  public void updateStockLevel(String stockLevelId, StockLevel stockLevel,
      ApiCallback<StockLevel> callback) {
    Call<StockLevel> call = service.updateStockLevel(stockLevelId, stockLevel);
    asyncCall(call, callback);
  }

  public void deleteStockLevel(String stockLevelId) throws ApiException {
    Call<Void> call = service.deleteStockLevel(stockLevelId);
    syncCall(call);
  }

  public void deleteStockLevel(String stockLevelId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteStockLevel(stockLevelId);
    asyncCall(call, callback);
  }

  public StockLevel retrieveStockLevel(String stockLevelId, QueryFilter queryFilter) throws
      ApiException {
    Call<StockLevel> call = service.retrieveStockLevel(stockLevelId, queryFilter);
    return syncCall(call);
  }

  public void retrieveStockLevel(String stockLevelId, QueryFilter queryFilter,
      ApiCallback<StockLevel> callback) {
    Call<StockLevel> call = service.retrieveStockLevel(stockLevelId, queryFilter);
    asyncCall(call, callback);
  }

  public StockLevel retrieveStockLevel(String stockLevelId) throws ApiException {
    Call<StockLevel> call = service.retrieveStockLevel(stockLevelId);
    return syncCall(call);
  }

  public void retrieveStockLevel(String stockLevelId, ApiCallback<StockLevel> callback) {
    Call<StockLevel> call = service.retrieveStockLevel(stockLevelId);
    asyncCall(call, callback);
  }

  public InventoryModel retrieveStockLevelInventoryModel(String stockLevelId,
      QueryFilter queryFilter) throws ApiException {
    Call<InventoryModel> call = service.retrieveStockLevelInventoryModel(stockLevelId, queryFilter);
    return syncCall(call);
  }

  public void retrieveStockLevelInventoryModel(String stockLevelId, QueryFilter queryFilter,
      ApiCallback<InventoryModel> callback) {
    Call<InventoryModel> call = service.retrieveStockLevelInventoryModel(stockLevelId, queryFilter);
    asyncCall(call, callback);
  }

  public InventoryModel retrieveStockLevelInventoryModel(String stockLevelId) throws ApiException {
    Call<InventoryModel> call = service.retrieveStockLevelInventoryModel(stockLevelId);
    return syncCall(call);
  }

  public void retrieveStockLevelInventoryModel(String stockLevelId,
      ApiCallback<InventoryModel> callback) {
    Call<InventoryModel> call = service.retrieveStockLevelInventoryModel(stockLevelId);
    asyncCall(call, callback);
  }

  public StockLocation retrieveStockLevelStockLocation(String stockLevelId, QueryFilter queryFilter)
      throws ApiException {
    Call<StockLocation> call = service.retrieveStockLevelStockLocation(stockLevelId, queryFilter);
    return syncCall(call);
  }

  public void retrieveStockLevelStockLocation(String stockLevelId, QueryFilter queryFilter,
      ApiCallback<StockLocation> callback) {
    Call<StockLocation> call = service.retrieveStockLevelStockLocation(stockLevelId, queryFilter);
    asyncCall(call, callback);
  }

  public StockLocation retrieveStockLevelStockLocation(String stockLevelId) throws ApiException {
    Call<StockLocation> call = service.retrieveStockLevelStockLocation(stockLevelId);
    return syncCall(call);
  }

  public void retrieveStockLevelStockLocation(String stockLevelId,
      ApiCallback<StockLocation> callback) {
    Call<StockLocation> call = service.retrieveStockLevelStockLocation(stockLevelId);
    asyncCall(call, callback);
  }
}
