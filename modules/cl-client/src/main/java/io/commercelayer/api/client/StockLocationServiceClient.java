package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.Address;
import io.commercelayer.api.model.StockItem;
import io.commercelayer.api.model.StockLevel;
import io.commercelayer.api.model.StockLocation;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.StockLocationService;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

public class StockLocationServiceClient extends AbstractServiceClient {
  protected StockLocationService service;

  public StockLocationServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
    this.service = apiCaller.getServiceCallFactory(StockLocationService.class, StockLocation.class);
  }

  public StockLocationServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws
      AuthException {
    super(apiOrg, apiToken);
    this.service = apiCaller.getServiceCallFactory(StockLocationService.class, StockLocation.class);
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

  public List<StockLocation> listStockLocations(Map<String, String> queryStringParams) throws
      ApiException {
    Call<List<StockLocation>> call = service.listStockLocations(queryStringParams);
    return syncCall(call);
  }

  public void listStockLocations(Map<String, String> queryStringParams,
      ApiCallback<List<StockLocation>> callback) {
    Call<List<StockLocation>> call = service.listStockLocations(queryStringParams);
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

  public void deleteStockLocation(String stockLocationId) throws ApiException {
    Call<Void> call = service.deleteStockLocation(stockLocationId);
    syncCall(call);
  }

  public void deleteStockLocation(String stockLocationId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteStockLocation(stockLocationId);
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

  public StockLocation retrieveStockLocation(String stockLocationId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<StockLocation> call = service.retrieveStockLocation(stockLocationId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveStockLocation(String stockLocationId, Map<String, String> queryStringParams,
      ApiCallback<StockLocation> callback) {
    Call<StockLocation> call = service.retrieveStockLocation(stockLocationId, queryStringParams);
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

  public Address retrieveStockLocationAddress(String stockLocationId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<Address> call = service.retrieveStockLocationAddress(stockLocationId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveStockLocationAddress(String stockLocationId,
      Map<String, String> queryStringParams, ApiCallback<Address> callback) {
    Call<Address> call = service.retrieveStockLocationAddress(stockLocationId, queryStringParams);
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
      Map<String, String> queryStringParams) throws ApiException {
    Call<List<StockItem>> call = service.listStockLocationStockItems(stockLocationId, queryStringParams);
    return syncCall(call);
  }

  public void listStockLocationStockItems(String stockLocationId,
      Map<String, String> queryStringParams, ApiCallback<List<StockItem>> callback) {
    Call<List<StockItem>> call = service.listStockLocationStockItems(stockLocationId, queryStringParams);
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
      Map<String, String> queryStringParams) throws ApiException {
    Call<List<StockLevel>> call = service.listStockLocationStockLevels(stockLocationId, queryStringParams);
    return syncCall(call);
  }

  public void listStockLocationStockLevels(String stockLocationId,
      Map<String, String> queryStringParams, ApiCallback<List<StockLevel>> callback) {
    Call<List<StockLevel>> call = service.listStockLocationStockLevels(stockLocationId, queryStringParams);
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
