package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.InventoryModel;
import io.commercelayer.api.model.StockLevel;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.InventoryModelService;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

public class InventoryModelServiceClient extends AbstractServiceClient {
  protected InventoryModelService service;

  public InventoryModelServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
    this.service = apiCaller.getServiceCallFactory(InventoryModelService.class, InventoryModel.class);
  }

  public InventoryModelServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws
      AuthException {
    super(apiOrg, apiToken);
    this.service = apiCaller.getServiceCallFactory(InventoryModelService.class, InventoryModel.class);
  }

  public InventoryModel createInventoryModel(InventoryModel inventoryModel) throws ApiException {
    Call<InventoryModel> call = service.createInventoryModel(inventoryModel);
    return syncCall(call);
  }

  public void createInventoryModel(InventoryModel inventoryModel,
      ApiCallback<InventoryModel> callback) {
    Call<InventoryModel> call = service.createInventoryModel(inventoryModel);
    asyncCall(call, callback);
  }

  public List<InventoryModel> listInventoryModels(Map<String, String> queryStringParams) throws
      ApiException {
    Call<List<InventoryModel>> call = service.listInventoryModels(queryStringParams);
    return syncCall(call);
  }

  public void listInventoryModels(Map<String, String> queryStringParams,
      ApiCallback<List<InventoryModel>> callback) {
    Call<List<InventoryModel>> call = service.listInventoryModels(queryStringParams);
    asyncCall(call, callback);
  }

  public List<InventoryModel> listInventoryModels() throws ApiException {
    Call<List<InventoryModel>> call = service.listInventoryModels();
    return syncCall(call);
  }

  public void listInventoryModels(ApiCallback<List<InventoryModel>> callback) {
    Call<List<InventoryModel>> call = service.listInventoryModels();
    asyncCall(call, callback);
  }

  public void deleteInventoryModel(String inventoryModelId) throws ApiException {
    Call<Void> call = service.deleteInventoryModel(inventoryModelId);
    syncCall(call);
  }

  public void deleteInventoryModel(String inventoryModelId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteInventoryModel(inventoryModelId);
    asyncCall(call, callback);
  }

  public InventoryModel updateInventoryModel(String inventoryModelId, InventoryModel inventoryModel)
      throws ApiException {
    Call<InventoryModel> call = service.updateInventoryModel(inventoryModelId, inventoryModel);
    return syncCall(call);
  }

  public void updateInventoryModel(String inventoryModelId, InventoryModel inventoryModel,
      ApiCallback<InventoryModel> callback) {
    Call<InventoryModel> call = service.updateInventoryModel(inventoryModelId, inventoryModel);
    asyncCall(call, callback);
  }

  public InventoryModel retrieveInventoryModel(String inventoryModelId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<InventoryModel> call = service.retrieveInventoryModel(inventoryModelId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveInventoryModel(String inventoryModelId, Map<String, String> queryStringParams,
      ApiCallback<InventoryModel> callback) {
    Call<InventoryModel> call = service.retrieveInventoryModel(inventoryModelId, queryStringParams);
    asyncCall(call, callback);
  }

  public InventoryModel retrieveInventoryModel(String inventoryModelId) throws ApiException {
    Call<InventoryModel> call = service.retrieveInventoryModel(inventoryModelId);
    return syncCall(call);
  }

  public void retrieveInventoryModel(String inventoryModelId,
      ApiCallback<InventoryModel> callback) {
    Call<InventoryModel> call = service.retrieveInventoryModel(inventoryModelId);
    asyncCall(call, callback);
  }

  public List<StockLevel> listInventoryModelStockLevels(String inventoryModelId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<List<StockLevel>> call = service.listInventoryModelStockLevels(inventoryModelId, queryStringParams);
    return syncCall(call);
  }

  public void listInventoryModelStockLevels(String inventoryModelId,
      Map<String, String> queryStringParams, ApiCallback<List<StockLevel>> callback) {
    Call<List<StockLevel>> call = service.listInventoryModelStockLevels(inventoryModelId, queryStringParams);
    asyncCall(call, callback);
  }

  public List<StockLevel> listInventoryModelStockLevels(String inventoryModelId) throws
      ApiException {
    Call<List<StockLevel>> call = service.listInventoryModelStockLevels(inventoryModelId);
    return syncCall(call);
  }

  public void listInventoryModelStockLevels(String inventoryModelId,
      ApiCallback<List<StockLevel>> callback) {
    Call<List<StockLevel>> call = service.listInventoryModelStockLevels(inventoryModelId);
    asyncCall(call, callback);
  }
}
