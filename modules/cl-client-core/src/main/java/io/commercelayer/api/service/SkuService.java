package io.commercelayer.api.service;

import io.commercelayer.api.model.DeliveryLeadTime;
import io.commercelayer.api.model.Price;
import io.commercelayer.api.model.ShippingCategory;
import io.commercelayer.api.model.Sku;
import io.commercelayer.api.model.SkuOption;
import io.commercelayer.api.model.StockItem;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface SkuService {
  @POST("skus")
  Call<Sku> createSku(@Body Sku sku);

  @GET("skus")
  Call<List<Sku>> listSkus();

  @GET("skus")
  Call<List<Sku>> listSkus(@QueryMap Map<String, String> queryStringParams);

  @PATCH("skus/{skuId}")
  Call<Sku> updateSku(@Path("skuId") String skuId, @Body Sku sku);

  @DELETE("skus/{skuId}")
  Call<Void> deleteSku(@Path("skuId") String skuId);

  @GET("skus/{skuId}")
  Call<Sku> retrieveSku(@Path("skuId") String skuId);

  @GET("skus/{skuId}")
  Call<Sku> retrieveSku(@Path("skuId") String skuId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("skus/{skuId}/delivery_lead_times")
  Call<List<DeliveryLeadTime>> listSkuDeliveryLeadTimes(@Path("skuId") String skuId);

  @GET("skus/{skuId}/delivery_lead_times")
  Call<List<DeliveryLeadTime>> listSkuDeliveryLeadTimes(@Path("skuId") String skuId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("skus/{skuId}/prices")
  Call<List<Price>> listSkuPrices(@Path("skuId") String skuId);

  @GET("skus/{skuId}/prices")
  Call<List<Price>> listSkuPrices(@Path("skuId") String skuId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("skus/{skuId}/shipping_category")
  Call<ShippingCategory> retrieveSkuShippingCategory(@Path("skuId") String skuId);

  @GET("skus/{skuId}/shipping_category")
  Call<ShippingCategory> retrieveSkuShippingCategory(@Path("skuId") String skuId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("skus/{skuId}/sku_options")
  Call<List<SkuOption>> listSkuSkuOptions(@Path("skuId") String skuId);

  @GET("skus/{skuId}/sku_options")
  Call<List<SkuOption>> listSkuSkuOptions(@Path("skuId") String skuId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("skus/{skuId}/stock_items")
  Call<List<StockItem>> listSkuStockItems(@Path("skuId") String skuId);

  @GET("skus/{skuId}/stock_items")
  Call<List<StockItem>> listSkuStockItems(@Path("skuId") String skuId,
      @QueryMap Map<String, String> queryStringParams);
}
