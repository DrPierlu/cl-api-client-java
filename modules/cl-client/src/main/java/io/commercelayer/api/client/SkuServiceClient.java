package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.DeliveryLeadTime;
import io.commercelayer.api.model.Price;
import io.commercelayer.api.model.ShippingCategory;
import io.commercelayer.api.model.Sku;
import io.commercelayer.api.model.SkuOption;
import io.commercelayer.api.model.StockItem;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.SkuService;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

public class SkuServiceClient extends AbstractServiceClient {
  protected SkuService service;

  public SkuServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
    this.service = apiCaller.getServiceCallFactory(SkuService.class, Sku.class);
  }

  public SkuServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
    this.service = apiCaller.getServiceCallFactory(SkuService.class, Sku.class);
  }

  public List<Sku> listSkus(Map<String, String> queryStringParams) throws ApiException {
    Call<List<Sku>> call = service.listSkus(queryStringParams);
    return syncCall(call);
  }

  public void listSkus(Map<String, String> queryStringParams, ApiCallback<List<Sku>> callback) {
    Call<List<Sku>> call = service.listSkus(queryStringParams);
    asyncCall(call, callback);
  }

  public List<Sku> listSkus() throws ApiException {
    Call<List<Sku>> call = service.listSkus();
    return syncCall(call);
  }

  public void listSkus(ApiCallback<List<Sku>> callback) {
    Call<List<Sku>> call = service.listSkus();
    asyncCall(call, callback);
  }

  public Sku createSku(Sku sku) throws ApiException {
    Call<Sku> call = service.createSku(sku);
    return syncCall(call);
  }

  public void createSku(Sku sku, ApiCallback<Sku> callback) {
    Call<Sku> call = service.createSku(sku);
    asyncCall(call, callback);
  }

  public void deleteSku(String skuId) throws ApiException {
    Call<Void> call = service.deleteSku(skuId);
    syncCall(call);
  }

  public void deleteSku(String skuId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteSku(skuId);
    asyncCall(call, callback);
  }

  public Sku updateSku(String skuId, Sku sku) throws ApiException {
    Call<Sku> call = service.updateSku(skuId, sku);
    return syncCall(call);
  }

  public void updateSku(String skuId, Sku sku, ApiCallback<Sku> callback) {
    Call<Sku> call = service.updateSku(skuId, sku);
    asyncCall(call, callback);
  }

  public Sku retrieveSku(String skuId, Map<String, String> queryStringParams) throws ApiException {
    Call<Sku> call = service.retrieveSku(skuId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveSku(String skuId, Map<String, String> queryStringParams,
      ApiCallback<Sku> callback) {
    Call<Sku> call = service.retrieveSku(skuId, queryStringParams);
    asyncCall(call, callback);
  }

  public Sku retrieveSku(String skuId) throws ApiException {
    Call<Sku> call = service.retrieveSku(skuId);
    return syncCall(call);
  }

  public void retrieveSku(String skuId, ApiCallback<Sku> callback) {
    Call<Sku> call = service.retrieveSku(skuId);
    asyncCall(call, callback);
  }

  public List<DeliveryLeadTime> listSkuDeliveryLeadTimes(String skuId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<List<DeliveryLeadTime>> call = service.listSkuDeliveryLeadTimes(skuId, queryStringParams);
    return syncCall(call);
  }

  public void listSkuDeliveryLeadTimes(String skuId, Map<String, String> queryStringParams,
      ApiCallback<List<DeliveryLeadTime>> callback) {
    Call<List<DeliveryLeadTime>> call = service.listSkuDeliveryLeadTimes(skuId, queryStringParams);
    asyncCall(call, callback);
  }

  public List<DeliveryLeadTime> listSkuDeliveryLeadTimes(String skuId) throws ApiException {
    Call<List<DeliveryLeadTime>> call = service.listSkuDeliveryLeadTimes(skuId);
    return syncCall(call);
  }

  public void listSkuDeliveryLeadTimes(String skuId, ApiCallback<List<DeliveryLeadTime>> callback) {
    Call<List<DeliveryLeadTime>> call = service.listSkuDeliveryLeadTimes(skuId);
    asyncCall(call, callback);
  }

  public List<Price> listSkuPrices(String skuId, Map<String, String> queryStringParams) throws
      ApiException {
    Call<List<Price>> call = service.listSkuPrices(skuId, queryStringParams);
    return syncCall(call);
  }

  public void listSkuPrices(String skuId, Map<String, String> queryStringParams,
      ApiCallback<List<Price>> callback) {
    Call<List<Price>> call = service.listSkuPrices(skuId, queryStringParams);
    asyncCall(call, callback);
  }

  public List<Price> listSkuPrices(String skuId) throws ApiException {
    Call<List<Price>> call = service.listSkuPrices(skuId);
    return syncCall(call);
  }

  public void listSkuPrices(String skuId, ApiCallback<List<Price>> callback) {
    Call<List<Price>> call = service.listSkuPrices(skuId);
    asyncCall(call, callback);
  }

  public ShippingCategory retrieveSkuShippingCategory(String skuId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<ShippingCategory> call = service.retrieveSkuShippingCategory(skuId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveSkuShippingCategory(String skuId, Map<String, String> queryStringParams,
      ApiCallback<ShippingCategory> callback) {
    Call<ShippingCategory> call = service.retrieveSkuShippingCategory(skuId, queryStringParams);
    asyncCall(call, callback);
  }

  public ShippingCategory retrieveSkuShippingCategory(String skuId) throws ApiException {
    Call<ShippingCategory> call = service.retrieveSkuShippingCategory(skuId);
    return syncCall(call);
  }

  public void retrieveSkuShippingCategory(String skuId, ApiCallback<ShippingCategory> callback) {
    Call<ShippingCategory> call = service.retrieveSkuShippingCategory(skuId);
    asyncCall(call, callback);
  }

  public List<SkuOption> listSkuSkuOptions(String skuId, Map<String, String> queryStringParams)
      throws ApiException {
    Call<List<SkuOption>> call = service.listSkuSkuOptions(skuId, queryStringParams);
    return syncCall(call);
  }

  public void listSkuSkuOptions(String skuId, Map<String, String> queryStringParams,
      ApiCallback<List<SkuOption>> callback) {
    Call<List<SkuOption>> call = service.listSkuSkuOptions(skuId, queryStringParams);
    asyncCall(call, callback);
  }

  public List<SkuOption> listSkuSkuOptions(String skuId) throws ApiException {
    Call<List<SkuOption>> call = service.listSkuSkuOptions(skuId);
    return syncCall(call);
  }

  public void listSkuSkuOptions(String skuId, ApiCallback<List<SkuOption>> callback) {
    Call<List<SkuOption>> call = service.listSkuSkuOptions(skuId);
    asyncCall(call, callback);
  }

  public List<StockItem> listSkuStockItems(String skuId, Map<String, String> queryStringParams)
      throws ApiException {
    Call<List<StockItem>> call = service.listSkuStockItems(skuId, queryStringParams);
    return syncCall(call);
  }

  public void listSkuStockItems(String skuId, Map<String, String> queryStringParams,
      ApiCallback<List<StockItem>> callback) {
    Call<List<StockItem>> call = service.listSkuStockItems(skuId, queryStringParams);
    asyncCall(call, callback);
  }

  public List<StockItem> listSkuStockItems(String skuId) throws ApiException {
    Call<List<StockItem>> call = service.listSkuStockItems(skuId);
    return syncCall(call);
  }

  public void listSkuStockItems(String skuId, ApiCallback<List<StockItem>> callback) {
    Call<List<StockItem>> call = service.listSkuStockItems(skuId);
    asyncCall(call, callback);
  }
}
