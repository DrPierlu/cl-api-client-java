package io.commercelayer.api.service;

import io.commercelayer.api.model.InventoryModel;
import io.commercelayer.api.model.Market;
import io.commercelayer.api.model.Merchant;
import io.commercelayer.api.model.PriceList;
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

public interface MarketService {
  @GET("markets")
  Call<List<Market>> listMarkets();

  @GET("markets")
  Call<List<Market>> listMarkets(@QueryMap Map<String, String> queryStringParams);

  @POST("markets")
  Call<Market> createMarket(@Body Market market);

  @DELETE("markets/{marketId}")
  Call<Void> deleteMarket(@Path("marketId") String marketId);

  @PATCH("markets/{marketId}")
  Call<Market> updateMarket(@Path("marketId") String marketId, @Body Market market);

  @GET("markets/{marketId}")
  Call<Market> retrieveMarket(@Path("marketId") String marketId);

  @GET("markets/{marketId}")
  Call<Market> retrieveMarket(@Path("marketId") String marketId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("markets/{marketId}/inventory_model")
  Call<InventoryModel> retrieveMarketInventoryModel(@Path("marketId") String marketId);

  @GET("markets/{marketId}/inventory_model")
  Call<InventoryModel> retrieveMarketInventoryModel(@Path("marketId") String marketId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("markets/{marketId}/merchant")
  Call<Merchant> retrieveMarketMerchant(@Path("marketId") String marketId);

  @GET("markets/{marketId}/merchant")
  Call<Merchant> retrieveMarketMerchant(@Path("marketId") String marketId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("markets/{marketId}/price_list")
  Call<PriceList> retrieveMarketPriceList(@Path("marketId") String marketId);

  @GET("markets/{marketId}/price_list")
  Call<PriceList> retrieveMarketPriceList(@Path("marketId") String marketId,
      @QueryMap Map<String, String> queryStringParams);
}
