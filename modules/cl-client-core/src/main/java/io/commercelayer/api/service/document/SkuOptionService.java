package io.commercelayer.api.service.document;

import io.commercelayer.api.model.SkuOption;
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

public interface SkuOptionService {
  @GET("/sku_options")
  Call<Document> listSkuOptions();

  @GET("/sku_options")
  Call<Document> listSkuOptions(@QueryMap Map<String, String> queryStringParams);

  @POST("/sku_options")
  Call<Document> createSkuOption(@Body SkuOption skuOption);

  @GET("/sku_options/{skuOptionId}")
  Call<Document> retrieveSkuOption(@Path("skuOptionId") String skuOptionId);

  @GET("/sku_options/{skuOptionId}")
  Call<Document> retrieveSkuOption(@Path("skuOptionId") String skuOptionId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/sku_options/{skuOptionId}")
  Call<Document> updateSkuOption(@Path("skuOptionId") String skuOptionId,
      @Body SkuOption skuOption);

  @DELETE("/sku_options/{skuOptionId}")
  Call<Void> deleteSkuOption(@Path("skuOptionId") String skuOptionId);

  @GET("/sku_options/{skuOptionId}/market")
  Call<Document> retrieveSkuOptionMarket(@Path("skuOptionId") String skuOptionId);

  @GET("/sku_options/{skuOptionId}/market")
  Call<Document> retrieveSkuOptionMarket(@Path("skuOptionId") String skuOptionId,
      @QueryMap Map<String, String> queryStringParams);
}
