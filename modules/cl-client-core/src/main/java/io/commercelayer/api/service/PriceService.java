package io.commercelayer.api.service;

import io.commercelayer.api.model.Price;
import io.commercelayer.api.model.PriceList;
import io.commercelayer.api.model.Sku;
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

public interface PriceService {
  @GET("prices")
  Call<List<Price>> listPrices();

  @GET("prices")
  Call<List<Price>> listPrices(@QueryMap Map<String, String> queryStringParams);

  @POST("prices")
  Call<Price> createPrice(@Body Price price);

  @POST("prices")
  Call<Price> createPrice(@Body Price price, @QueryMap Map<String, String> queryStringParams);

  @PATCH("prices/{priceId}")
  Call<Price> updatePrice(@Path("priceId") String priceId, @Body Price price);

  @PATCH("prices/{priceId}")
  Call<Price> updatePrice(@Path("priceId") String priceId, @Body Price price,
      @QueryMap Map<String, String> queryStringParams);

  @GET("prices/{priceId}")
  Call<Price> retrievePrice(@Path("priceId") String priceId);

  @GET("prices/{priceId}")
  Call<Price> retrievePrice(@Path("priceId") String priceId,
      @QueryMap Map<String, String> queryStringParams);

  @DELETE("prices/{priceId}")
  Call<Void> deletePrice(@Path("priceId") String priceId);

  @GET("prices/{priceId}/price_list")
  Call<PriceList> retrievePricePriceList(@Path("priceId") String priceId);

  @GET("prices/{priceId}/price_list")
  Call<PriceList> retrievePricePriceList(@Path("priceId") String priceId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("prices/{priceId}/sku")
  Call<Sku> retrievePriceSku(@Path("priceId") String priceId);

  @GET("prices/{priceId}/sku")
  Call<Sku> retrievePriceSku(@Path("priceId") String priceId,
      @QueryMap Map<String, String> queryStringParams);
}
