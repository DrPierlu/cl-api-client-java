package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.ShippingCategory;
import io.commercelayer.api.model.Sku;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.ShippingCategoryService;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

public class ShippingCategoryServiceClient extends AbstractServiceClient {
  protected final ShippingCategoryService service;

  {
    this.service = initServiceCallFactory(ShippingCategoryService.class, ShippingCategory.class);
  }

  public ShippingCategoryServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws
      AuthException {
    super(apiOrg, apiAuth);
  }

  public ShippingCategoryServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws
      AuthException {
    super(apiOrg, apiToken);
  }

  public List<ShippingCategory> listShippingCategories(Map<String, String> queryStringParams) throws
      ApiException {
    Call<List<ShippingCategory>> call = service.listShippingCategories(queryStringParams);
    return syncCall(call);
  }

  public void listShippingCategories(Map<String, String> queryStringParams,
      ApiCallback<List<ShippingCategory>> callback) {
    Call<List<ShippingCategory>> call = service.listShippingCategories(queryStringParams);
    asyncCall(call, callback);
  }

  public List<ShippingCategory> listShippingCategories() throws ApiException {
    Call<List<ShippingCategory>> call = service.listShippingCategories();
    return syncCall(call);
  }

  public void listShippingCategories(ApiCallback<List<ShippingCategory>> callback) {
    Call<List<ShippingCategory>> call = service.listShippingCategories();
    asyncCall(call, callback);
  }

  public ShippingCategory createShippingCategory(ShippingCategory shippingCategory) throws
      ApiException {
    Call<ShippingCategory> call = service.createShippingCategory(shippingCategory);
    return syncCall(call);
  }

  public void createShippingCategory(ShippingCategory shippingCategory,
      ApiCallback<ShippingCategory> callback) {
    Call<ShippingCategory> call = service.createShippingCategory(shippingCategory);
    asyncCall(call, callback);
  }

  public void deleteShippingCategory(String shippingCategoryId) throws ApiException {
    Call<Void> call = service.deleteShippingCategory(shippingCategoryId);
    syncCall(call);
  }

  public void deleteShippingCategory(String shippingCategoryId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteShippingCategory(shippingCategoryId);
    asyncCall(call, callback);
  }

  public ShippingCategory updateShippingCategory(String shippingCategoryId,
      ShippingCategory shippingCategory) throws ApiException {
    Call<ShippingCategory> call = service.updateShippingCategory(shippingCategoryId, shippingCategory);
    return syncCall(call);
  }

  public void updateShippingCategory(String shippingCategoryId, ShippingCategory shippingCategory,
      ApiCallback<ShippingCategory> callback) {
    Call<ShippingCategory> call = service.updateShippingCategory(shippingCategoryId, shippingCategory);
    asyncCall(call, callback);
  }

  public ShippingCategory retrieveShippingCategory(String shippingCategoryId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<ShippingCategory> call = service.retrieveShippingCategory(shippingCategoryId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveShippingCategory(String shippingCategoryId,
      Map<String, String> queryStringParams, ApiCallback<ShippingCategory> callback) {
    Call<ShippingCategory> call = service.retrieveShippingCategory(shippingCategoryId, queryStringParams);
    asyncCall(call, callback);
  }

  public ShippingCategory retrieveShippingCategory(String shippingCategoryId) throws ApiException {
    Call<ShippingCategory> call = service.retrieveShippingCategory(shippingCategoryId);
    return syncCall(call);
  }

  public void retrieveShippingCategory(String shippingCategoryId,
      ApiCallback<ShippingCategory> callback) {
    Call<ShippingCategory> call = service.retrieveShippingCategory(shippingCategoryId);
    asyncCall(call, callback);
  }

  public List<Sku> listShippingCategorySkus(String shippingCategoryId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<List<Sku>> call = service.listShippingCategorySkus(shippingCategoryId, queryStringParams);
    return syncCall(call);
  }

  public void listShippingCategorySkus(String shippingCategoryId,
      Map<String, String> queryStringParams, ApiCallback<List<Sku>> callback) {
    Call<List<Sku>> call = service.listShippingCategorySkus(shippingCategoryId, queryStringParams);
    asyncCall(call, callback);
  }

  public List<Sku> listShippingCategorySkus(String shippingCategoryId) throws ApiException {
    Call<List<Sku>> call = service.listShippingCategorySkus(shippingCategoryId);
    return syncCall(call);
  }

  public void listShippingCategorySkus(String shippingCategoryId, ApiCallback<List<Sku>> callback) {
    Call<List<Sku>> call = service.listShippingCategorySkus(shippingCategoryId);
    asyncCall(call, callback);
  }
}
