package io.commercelayer.api.service;

import io.commercelayer.api.model.Market;
import io.commercelayer.api.model.SkuOption;
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

public interface SkuOptionService {
  @GET("sku_options")
  Call<List<SkuOption>> listSkuOptions();

  @GET("sku_options")
  Call<List<SkuOption>> listSkuOptions(@QueryMap Map<String, String> queryStringParams);

  @POST("sku_options")
  Call<SkuOption> createSkuOption(@Body SkuOption skuOption);

  @DELETE("sku_options/{skuOptionId}")
  Call<Void> deleteSkuOption(@Path("skuOptionId") String skuOptionId);

  @PATCH("sku_options/{skuOptionId}")
  Call<SkuOption> updateSkuOption(@Path("skuOptionId") String skuOptionId,
      @Body SkuOption skuOption);

  @GET("sku_options/{skuOptionId}")
  Call<SkuOption> retrieveSkuOption(@Path("skuOptionId") String skuOptionId);

  @GET("sku_options/{skuOptionId}")
  Call<SkuOption> retrieveSkuOption(@Path("skuOptionId") String skuOptionId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("sku_options/{skuOptionId}/market")
  Call<Market> retrieveSkuOptionMarket(@Path("skuOptionId") String skuOptionId);

  @GET("sku_options/{skuOptionId}/market")
  Call<Market> retrieveSkuOptionMarket(@Path("skuOptionId") String skuOptionId,
      @QueryMap Map<String, String> queryStringParams);
}
