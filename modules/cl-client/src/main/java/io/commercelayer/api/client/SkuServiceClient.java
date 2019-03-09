package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.common.query.QueryFilter;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.exception.ApiException;
import io.commercelayer.api.model.DeliveryLeadTime;
import io.commercelayer.api.model.Price;
import io.commercelayer.api.model.ShippingCategory;
import io.commercelayer.api.model.Sku;
import io.commercelayer.api.model.SkuOption;
import io.commercelayer.api.model.StockItem;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.SkuService;
import java.util.List;
import retrofit2.Call;

public class SkuServiceClient extends AbstractServiceClient<SkuService> {
  {
    initServiceCallFactory(SkuService.class, Sku.class);
  }

  public SkuServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
  }

  public SkuServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
  }

  public List<Sku> listSkus(QueryFilter queryFilter) throws ApiException {
    Call<List<Sku>> call = service.listSkus(queryFilter);
    return syncCall(call);
  }

  public void listSkus(QueryFilter queryFilter, ApiCallback<List<Sku>> callback) {
    Call<List<Sku>> call = service.listSkus(queryFilter);
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

  public Sku createSku(Sku sku, QueryFilter queryFilter) throws ApiException {
    Call<Sku> call = service.createSku(sku, queryFilter);
    return syncCall(call);
  }

  public void createSku(Sku sku, QueryFilter queryFilter, ApiCallback<Sku> callback) {
    Call<Sku> call = service.createSku(sku, queryFilter);
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

  public Sku updateSku(String skuId, Sku sku, QueryFilter queryFilter) throws ApiException {
    Call<Sku> call = service.updateSku(skuId, sku, queryFilter);
    return syncCall(call);
  }

  public void updateSku(String skuId, Sku sku, QueryFilter queryFilter, ApiCallback<Sku> callback) {
    Call<Sku> call = service.updateSku(skuId, sku, queryFilter);
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

  public Sku retrieveSku(String skuId, QueryFilter queryFilter) throws ApiException {
    Call<Sku> call = service.retrieveSku(skuId, queryFilter);
    return syncCall(call);
  }

  public void retrieveSku(String skuId, QueryFilter queryFilter, ApiCallback<Sku> callback) {
    Call<Sku> call = service.retrieveSku(skuId, queryFilter);
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

  public void deleteSku(String skuId) throws ApiException {
    Call<Void> call = service.deleteSku(skuId);
    syncCall(call);
  }

  public void deleteSku(String skuId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteSku(skuId);
    asyncCall(call, callback);
  }

  public List<DeliveryLeadTime> listSkuDeliveryLeadTimes(String skuId, QueryFilter queryFilter)
      throws ApiException {
    Call<List<DeliveryLeadTime>> call = service.listSkuDeliveryLeadTimes(skuId, queryFilter);
    return syncCall(call);
  }

  public void listSkuDeliveryLeadTimes(String skuId, QueryFilter queryFilter,
      ApiCallback<List<DeliveryLeadTime>> callback) {
    Call<List<DeliveryLeadTime>> call = service.listSkuDeliveryLeadTimes(skuId, queryFilter);
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

  public List<Price> listSkuPrices(String skuId, QueryFilter queryFilter) throws ApiException {
    Call<List<Price>> call = service.listSkuPrices(skuId, queryFilter);
    return syncCall(call);
  }

  public void listSkuPrices(String skuId, QueryFilter queryFilter,
      ApiCallback<List<Price>> callback) {
    Call<List<Price>> call = service.listSkuPrices(skuId, queryFilter);
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

  public ShippingCategory retrieveSkuShippingCategory(String skuId, QueryFilter queryFilter) throws
      ApiException {
    Call<ShippingCategory> call = service.retrieveSkuShippingCategory(skuId, queryFilter);
    return syncCall(call);
  }

  public void retrieveSkuShippingCategory(String skuId, QueryFilter queryFilter,
      ApiCallback<ShippingCategory> callback) {
    Call<ShippingCategory> call = service.retrieveSkuShippingCategory(skuId, queryFilter);
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

  public List<SkuOption> listSkuSkuOptions(String skuId, QueryFilter queryFilter) throws
      ApiException {
    Call<List<SkuOption>> call = service.listSkuSkuOptions(skuId, queryFilter);
    return syncCall(call);
  }

  public void listSkuSkuOptions(String skuId, QueryFilter queryFilter,
      ApiCallback<List<SkuOption>> callback) {
    Call<List<SkuOption>> call = service.listSkuSkuOptions(skuId, queryFilter);
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

  public List<StockItem> listSkuStockItems(String skuId, QueryFilter queryFilter) throws
      ApiException {
    Call<List<StockItem>> call = service.listSkuStockItems(skuId, queryFilter);
    return syncCall(call);
  }

  public void listSkuStockItems(String skuId, QueryFilter queryFilter,
      ApiCallback<List<StockItem>> callback) {
    Call<List<StockItem>> call = service.listSkuStockItems(skuId, queryFilter);
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
