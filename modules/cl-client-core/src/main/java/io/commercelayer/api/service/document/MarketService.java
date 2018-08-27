package io.commercelayer.api.service.document;

import io.commercelayer.api.model.Market;
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

public interface MarketService {
  @GET("/markets")
  Call<Document> listMarkets();

  @GET("/markets")
  Call<Document> listMarkets(@QueryMap Map<String, String> queryStringParams);

  @POST("/markets")
  Call<Document> createMarket(@Body Market market);

  @GET("/markets/{marketId}")
  Call<Document> retrieveMarket(@Path("marketId") String marketId);

  @GET("/markets/{marketId}")
  Call<Document> retrieveMarket(@Path("marketId") String marketId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/markets/{marketId}")
  Call<Document> updateMarket(@Path("marketId") String marketId, @Body Market market);

  @DELETE("/markets/{marketId}")
  Call<Void> deleteMarket(@Path("marketId") String marketId);

  @GET("/markets/{marketId}/inventory_model")
  Call<Document> retrieveMarketInventoryModel(@Path("marketId") String marketId);

  @GET("/markets/{marketId}/inventory_model")
  Call<Document> retrieveMarketInventoryModel(@Path("marketId") String marketId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/markets/{marketId}/merchant")
  Call<Document> retrieveMarketMerchant(@Path("marketId") String marketId);

  @GET("/markets/{marketId}/merchant")
  Call<Document> retrieveMarketMerchant(@Path("marketId") String marketId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/markets/{marketId}/price_list")
  Call<Document> retrieveMarketPriceList(@Path("marketId") String marketId);

  @GET("/markets/{marketId}/price_list")
  Call<Document> retrieveMarketPriceList(@Path("marketId") String marketId,
      @QueryMap Map<String, String> queryStringParams);
}
