package io.commercelayer.api.service.document;

import io.commercelayer.api.model.PriceList;
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

public interface PriceListService {
  @GET("/price_lists")
  Call<Document> listPriceLists();

  @GET("/price_lists")
  Call<Document> listPriceLists(@QueryMap Map<String, String> queryStringParams);

  @POST("/price_lists")
  Call<Document> createPriceList(@Body PriceList priceList);

  @GET("/price_lists/{priceListId}")
  Call<Document> retrievePriceList(@Path("priceListId") String priceListId);

  @GET("/price_lists/{priceListId}")
  Call<Document> retrievePriceList(@Path("priceListId") String priceListId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/price_lists/{priceListId}")
  Call<Document> updatePriceList(@Path("priceListId") String priceListId,
      @Body PriceList priceList);

  @DELETE("/price_lists/{priceListId}")
  Call<Void> deletePriceList(@Path("priceListId") String priceListId);

  @GET("/price_lists/{priceListId}/prices")
  Call<Document> listPriceListPrices(@Path("priceListId") String priceListId);

  @GET("/price_lists/{priceListId}/prices")
  Call<Document> listPriceListPrices(@Path("priceListId") String priceListId,
      @QueryMap Map<String, String> queryStringParams);
}
