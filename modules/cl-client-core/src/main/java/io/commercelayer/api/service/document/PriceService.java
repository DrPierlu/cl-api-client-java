package io.commercelayer.api.service.document;

import io.commercelayer.api.model.Price;
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

public interface PriceService {
  @GET("/prices")
  Call<Document> listPrices();

  @GET("/prices")
  Call<Document> listPrices(@QueryMap Map<String, String> queryStringParams);

  @POST("/prices")
  Call<Document> createPrice(@Body Price price);

  @GET("/prices/{priceId}")
  Call<Document> retrievePrice(@Path("priceId") String priceId);

  @GET("/prices/{priceId}")
  Call<Document> retrievePrice(@Path("priceId") String priceId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/prices/{priceId}")
  Call<Document> updatePrice(@Path("priceId") String priceId, @Body Price price);

  @DELETE("/prices/{priceId}")
  Call<Void> deletePrice(@Path("priceId") String priceId);

  @GET("/prices/{priceId}/price_list")
  Call<Document> retrievePricePriceList(@Path("priceId") String priceId);

  @GET("/prices/{priceId}/price_list")
  Call<Document> retrievePricePriceList(@Path("priceId") String priceId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/prices/{priceId}/sku")
  Call<Document> retrievePriceSku(@Path("priceId") String priceId);

  @GET("/prices/{priceId}/sku")
  Call<Document> retrievePriceSku(@Path("priceId") String priceId,
      @QueryMap Map<String, String> queryStringParams);
}
