package io.commercelayer.api.service.document;

import io.commercelayer.api.model.Sku;
import java.lang.String;
import java.lang.Void;
import java.util.Map;
import moe.banana.jsonapi2.Document;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface SkuService {
  @GET("/skus")
  Call<Document> listSkus();

  @GET("/skus")
  Call<Document> listSkus(@QueryMap Map<String, String> queryStringParams);

  @POST("/skus")
  Call<Document> createSku(@Body Sku sku);

  @GET("/skus/{skuId}")
  Call<Document> retrieveSku(@Path("skuId") String skuId);

  @GET("/skus/{skuId}")
  Call<Document> retrieveSku(@Path("skuId") String skuId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/skus/{skuId}")
  Call<Document> updateSku(@Path("skuId") String skuId, @Body Sku sku);

  @DELETE("/skus/{skuId}")
  Call<Void> deleteSku(@Path("skuId") String skuId);

  @GET("/skus/{skuId}/delivery_lead_times")
  Call<Document> listSkuDeliveryLeadTimes(@Path("skuId") String skuId);

  @GET("/skus/{skuId}/delivery_lead_times")
  Call<Document> listSkuDeliveryLeadTimes(@Path("skuId") String skuId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/skus/{skuId}/prices")
  Call<Document> listSkuPrices(@Path("skuId") String skuId);

  @GET("/skus/{skuId}/prices")
  Call<Document> listSkuPrices(@Path("skuId") String skuId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/skus/{skuId}/shipping_category")
  Call<Document> retrieveSkuShippingCategory(@Path("skuId") String skuId);

  @GET("/skus/{skuId}/shipping_category")
  Call<Document> retrieveSkuShippingCategory(@Path("skuId") String skuId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/skus/{skuId}/sku_options")
  Call<Document> listSkuSkuOptions(@Path("skuId") String skuId);

  @GET("/skus/{skuId}/sku_options")
  Call<Document> listSkuSkuOptions(@Path("skuId") String skuId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/skus/{skuId}/stock_items")
  Call<Document> listSkuStockItems(@Path("skuId") String skuId);

  @GET("/skus/{skuId}/stock_items")
  Call<Document> listSkuStockItems(@Path("skuId") String skuId,
      @QueryMap Map<String, String> queryStringParams);
}
