package io.commercelayer.api.service.document;

import io.commercelayer.api.model.CreditCard;
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

public interface CreditCardService {
  @GET("/credit_cards")
  Call<Document> listCreditCards();

  @GET("/credit_cards")
  Call<Document> listCreditCards(@QueryMap Map<String, String> queryStringParams);

  @POST("/credit_cards")
  Call<Document> createCreditCard(@Body CreditCard creditCard);

  @GET("/credit_cards/{creditCardId}")
  Call<Document> retrieveCreditCard(@Path("creditCardId") String creditCardId);

  @GET("/credit_cards/{creditCardId}")
  Call<Document> retrieveCreditCard(@Path("creditCardId") String creditCardId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/credit_cards/{creditCardId}")
  Call<Document> updateCreditCard(@Path("creditCardId") String creditCardId,
      @Body CreditCard creditCard);

  @DELETE("/credit_cards/{creditCardId}")
  Call<Void> deleteCreditCard(@Path("creditCardId") String creditCardId);

  @GET("/credit_cards/{creditCardId}/order")
  Call<Document> retrieveCreditCardOrder(@Path("creditCardId") String creditCardId);

  @GET("/credit_cards/{creditCardId}/order")
  Call<Document> retrieveCreditCardOrder(@Path("creditCardId") String creditCardId,
      @QueryMap Map<String, String> queryStringParams);
}
