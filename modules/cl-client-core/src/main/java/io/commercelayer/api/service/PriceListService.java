package io.commercelayer.api.service;

import io.commercelayer.api.model.Price;
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

public interface PriceListService {
  @GET("price_lists")
  Call<List<PriceList>> listPriceLists();

  @GET("price_lists")
  Call<List<PriceList>> listPriceLists(@QueryMap Map<String, String> queryStringParams);

  @POST("price_lists")
  Call<PriceList> createPriceList(@Body PriceList priceList);

  @DELETE("price_lists/{priceListId}")
  Call<Void> deletePriceList(@Path("priceListId") String priceListId);

  @PATCH("price_lists/{priceListId}")
  Call<PriceList> updatePriceList(@Path("priceListId") String priceListId,
      @Body PriceList priceList);

  @GET("price_lists/{priceListId}")
  Call<PriceList> retrievePriceList(@Path("priceListId") String priceListId);

  @GET("price_lists/{priceListId}")
  Call<PriceList> retrievePriceList(@Path("priceListId") String priceListId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("price_lists/{priceListId}/prices")
  Call<List<Price>> listPriceListPrices(@Path("priceListId") String priceListId);

  @GET("price_lists/{priceListId}/prices")
  Call<List<Price>> listPriceListPrices(@Path("priceListId") String priceListId,
      @QueryMap Map<String, String> queryStringParams);
}
