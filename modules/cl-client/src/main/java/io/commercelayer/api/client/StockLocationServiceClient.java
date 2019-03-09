package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.common.query.QueryFilter;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.exception.ApiException;
import io.commercelayer.api.model.Address;
import io.commercelayer.api.model.StockItem;
import io.commercelayer.api.model.StockLevel;
import io.commercelayer.api.model.StockLocation;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.StockLocationService;
import java.util.List;
import retrofit2.Call;

public class StockLocationServiceClient extends AbstractServiceClient<StockLocationService> {
  {
    initServiceCallFactory(StockLocationService.class, StockLocation.class);
  }

  public StockLocationServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
  }

  public StockLocationServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws
      AuthException {
    super(apiOrg, apiToken);
  }

  public List<StockLocation> listStockLocations(QueryFilter queryFilter) throws ApiException {
    Call<List<StockLocation>> call = service.listStockLocations(queryFilter);
    return syncCall(call);
  }

  public void listStockLocations(QueryFilter queryFilter,
      ApiCallback<List<StockLocation>> callback) {
    Call<List<StockLocation>> call = service.listStockLocations(queryFilter);
    asyncCall(call, callback);
  }

  public List<StockLocation> listStockLocations() throws ApiException {
    Call<List<StockLocation>> call = service.listStockLocations();
    return syncCall(call);
  }

  public void listStockLocations(ApiCallback<List<StockLocation>> callback) {
    Call<List<StockLocation>> call = service.listStockLocations();
    asyncCall(call, callback);
  }

  public StockLocation createStockLocation(StockLocation stockLocation, QueryFilter queryFilter)
      throws ApiException {
    Call<StockLocation> call = service.createStockLocation(stockLocation, queryFilter);
    return syncCall(call);
  }

  public void createStockLocation(StockLocation stockLocation, QueryFilter queryFilter,
      ApiCallback<StockLocation> callback) {
    Call<StockLocation> call = service.createStockLocation(stockLocation, queryFilter);
    asyncCall(call, callback);
  }

  public StockLocation createStockLocation(StockLocation stockLocation) throws ApiException {
    Call<StockLocation> call = service.createStockLocation(stockLocation);
    return syncCall(call);
  }

  public void createStockLocation(StockLocation stockLocation,
      ApiCallback<StockLocation> callback) {
    Call<StockLocation> call = service.createStockLocation(stockLocation);
    asyncCall(call, callback);
  }

  public StockLocation updateStockLocation(String stockLocationId, StockLocation stockLocation,
      QueryFilter queryFilter) throws ApiException {
    Call<StockLocation> call = service.updateStockLocation(stockLocationId, stockLocation, queryFilter);
    return syncCall(call);
  }

  public void updateStockLocation(String stockLocationId, StockLocation stockLocation,
      QueryFilter queryFilter, ApiCallback<StockLocation> callback) {
    Call<StockLocation> call = service.updateStockLocation(stockLocationId, stockLocation, queryFilter);
    asyncCall(call, callback);
  }

  public StockLocation updateStockLocation(String stockLocationId, StockLocation stockLocation)
      throws ApiException {
    Call<StockLocation> call = service.updateStockLocation(stockLocationId, stockLocation);
    return syncCall(call);
  }

  public void updateStockLocation(String stockLocationId, StockLocation stockLocation,
      ApiCallback<StockLocation> callback) {
    Call<StockLocation> call = service.updateStockLocation(stockLocationId, stockLocation);
    asyncCall(call, callback);
  }

  public StockLocation retrieveStockLocation(String stockLocationId, QueryFilter queryFilter) throws
      ApiException {
    Call<StockLocation> call = service.retrieveStockLocation(stockLocationId, queryFilter);
    return syncCall(call);
  }

  public void retrieveStockLocation(String stockLocationId, QueryFilter queryFilter,
      ApiCallback<StockLocation> callback) {
    Call<StockLocation> call = service.retrieveStockLocation(stockLocationId, queryFilter);
    asyncCall(call, callback);
  }

  public StockLocation retrieveStockLocation(String stockLocationId) throws ApiException {
    Call<StockLocation> call = service.retrieveStockLocation(stockLocationId);
    return syncCall(call);
  }

  public void retrieveStockLocation(String stockLocationId, ApiCallback<StockLocation> callback) {
    Call<StockLocation> call = service.retrieveStockLocation(stockLocationId);
    asyncCall(call, callback);
  }

  public void deleteStockLocation(String stockLocationId) throws ApiException {
    Call<Void> call = service.deleteStockLocation(stockLocationId);
    syncCall(call);
  }

  public void deleteStockLocation(String stockLocationId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteStockLocation(stockLocationId);
    asyncCall(call, callback);
  }

  public Address retrieveStockLocationAddress(String stockLocationId, QueryFilter queryFilter)
      throws ApiException {
    Call<Address> call = service.retrieveStockLocationAddress(stockLocationId, queryFilter);
    return syncCall(call);
  }

  public void retrieveStockLocationAddress(String stockLocationId, QueryFilter queryFilter,
      ApiCallback<Address> callback) {
    Call<Address> call = service.retrieveStockLocationAddress(stockLocationId, queryFilter);
    asyncCall(call, callback);
  }

  public Address retrieveStockLocationAddress(String stockLocationId) throws ApiException {
    Call<Address> call = service.retrieveStockLocationAddress(stockLocationId);
    return syncCall(call);
  }

  public void retrieveStockLocationAddress(String stockLocationId, ApiCallback<Address> callback) {
    Call<Address> call = service.retrieveStockLocationAddress(stockLocationId);
    asyncCall(call, callback);
  }

  public List<StockItem> listStockLocationStockItems(String stockLocationId,
      QueryFilter queryFilter) throws ApiException {
    Call<List<StockItem>> call = service.listStockLocationStockItems(stockLocationId, queryFilter);
    return syncCall(call);
  }

  public void listStockLocationStockItems(String stockLocationId, QueryFilter queryFilter,
      ApiCallback<List<StockItem>> callback) {
    Call<List<StockItem>> call = service.listStockLocationStockItems(stockLocationId, queryFilter);
    asyncCall(call, callback);
  }

  public List<StockItem> listStockLocationStockItems(String stockLocationId) throws ApiException {
    Call<List<StockItem>> call = service.listStockLocationStockItems(stockLocationId);
    return syncCall(call);
  }

  public void listStockLocationStockItems(String stockLocationId,
      ApiCallback<List<StockItem>> callback) {
    Call<List<StockItem>> call = service.listStockLocationStockItems(stockLocationId);
    asyncCall(call, callback);
  }

  public List<StockLevel> listStockLocationStockLevels(String stockLocationId,
      QueryFilter queryFilter) throws ApiException {
    Call<List<StockLevel>> call = service.listStockLocationStockLevels(stockLocationId, queryFilter);
    return syncCall(call);
  }

  public void listStockLocationStockLevels(String stockLocationId, QueryFilter queryFilter,
      ApiCallback<List<StockLevel>> callback) {
    Call<List<StockLevel>> call = service.listStockLocationStockLevels(stockLocationId, queryFilter);
    asyncCall(call, callback);
  }

  public List<StockLevel> listStockLocationStockLevels(String stockLocationId) throws ApiException {
    Call<List<StockLevel>> call = service.listStockLocationStockLevels(stockLocationId);
    return syncCall(call);
  }

  public void listStockLocationStockLevels(String stockLocationId,
      ApiCallback<List<StockLevel>> callback) {
    Call<List<StockLevel>> call = service.listStockLocationStockLevels(stockLocationId);
    asyncCall(call, callback);
  }
}
