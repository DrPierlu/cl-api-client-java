package io.commercelayer.api.service.document;

import io.commercelayer.api.model.PaymentMethod;
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

public interface PaymentMethodService {
  @GET("/payment_methods")
  Call<Document> listPaymentMethods();

  @GET("/payment_methods")
  Call<Document> listPaymentMethods(@QueryMap Map<String, String> queryStringParams);

  @POST("/payment_methods")
  Call<Document> createPaymentMethod(@Body PaymentMethod paymentMethod);

  @GET("/payment_methods/{paymentMethodId}")
  Call<Document> retrievePaymentMethod(@Path("paymentMethodId") String paymentMethodId);

  @GET("/payment_methods/{paymentMethodId}")
  Call<Document> retrievePaymentMethod(@Path("paymentMethodId") String paymentMethodId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/payment_methods/{paymentMethodId}")
  Call<Document> updatePaymentMethod(@Path("paymentMethodId") String paymentMethodId,
      @Body PaymentMethod paymentMethod);

  @DELETE("/payment_methods/{paymentMethodId}")
  Call<Void> deletePaymentMethod(@Path("paymentMethodId") String paymentMethodId);

  @GET("/payment_methods/{paymentMethodId}/market")
  Call<Document> retrievePaymentMethodMarket(@Path("paymentMethodId") String paymentMethodId);

  @GET("/payment_methods/{paymentMethodId}/market")
  Call<Document> retrievePaymentMethodMarket(@Path("paymentMethodId") String paymentMethodId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/payment_methods/{paymentMethodId}/payment_gateway")
  Call<Document> retrievePaymentMethodPaymentGateway(
      @Path("paymentMethodId") String paymentMethodId);

  @GET("/payment_methods/{paymentMethodId}/payment_gateway")
  Call<Document> retrievePaymentMethodPaymentGateway(
      @Path("paymentMethodId") String paymentMethodId,
      @QueryMap Map<String, String> queryStringParams);
}
