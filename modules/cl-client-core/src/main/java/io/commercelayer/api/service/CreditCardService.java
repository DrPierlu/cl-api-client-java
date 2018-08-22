package io.commercelayer.api.service;

import io.commercelayer.api.model.CreditCard;
import io.commercelayer.api.model.Order;
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

public interface CreditCardService {
  @GET("/credit_cards")
  Call<List<CreditCard>> listCreditCards();

  @GET("/credit_cards")
  Call<List<CreditCard>> listCreditCards(@QueryMap Map<String, String> queryStringParams);

  @POST("/credit_cards")
  Call<CreditCard> createCreditCard(@Body CreditCard creditCard);

  @GET("/credit_cards/{creditCardId}")
  Call<CreditCard> retrieveCreditCard(@Path("creditCardId") String creditCardId);

  @GET("/credit_cards/{creditCardId}")
  Call<CreditCard> retrieveCreditCard(@Path("creditCardId") String creditCardId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/credit_cards/{creditCardId}")
  Call<CreditCard> updateCreditCard(@Path("creditCardId") String creditCardId,
      @Body CreditCard creditCard);

  @DELETE("/credit_cards/{creditCardId}")
  Call<Void> deleteCreditCard(@Path("creditCardId") String creditCardId);

  @GET("/credit_cards/{creditCardId}/order")
  Call<Order> retrieveCreditCardOrder(@Path("creditCardId") String creditCardId);

  @GET("/credit_cards/{creditCardId}/order")
  Call<Order> retrieveCreditCardOrder(@Path("creditCardId") String creditCardId,
      @QueryMap Map<String, String> queryStringParams);
}
