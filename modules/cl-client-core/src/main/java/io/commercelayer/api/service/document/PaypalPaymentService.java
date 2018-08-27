package io.commercelayer.api.service.document;

import io.commercelayer.api.model.PaypalPayment;
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

public interface PaypalPaymentService {
  @GET("/paypal_payments")
  Call<Document> listPaypalPayments();

  @GET("/paypal_payments")
  Call<Document> listPaypalPayments(@QueryMap Map<String, String> queryStringParams);

  @POST("/paypal_payments")
  Call<Document> createPaypalPayment(@Body PaypalPayment paypalPayment);

  @GET("/paypal_payments/{paypalPaymentId}")
  Call<Document> retrievePaypalPayment(@Path("paypalPaymentId") String paypalPaymentId);

  @GET("/paypal_payments/{paypalPaymentId}")
  Call<Document> retrievePaypalPayment(@Path("paypalPaymentId") String paypalPaymentId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/paypal_payments/{paypalPaymentId}")
  Call<Document> updatePaypalPayment(@Path("paypalPaymentId") String paypalPaymentId,
      @Body PaypalPayment paypalPayment);

  @DELETE("/paypal_payments/{paypalPaymentId}")
  Call<Void> deletePaypalPayment(@Path("paypalPaymentId") String paypalPaymentId);

  @GET("/paypal_payments/{paypalPaymentId}/order")
  Call<Document> retrievePaypalPaymentOrder(@Path("paypalPaymentId") String paypalPaymentId);

  @GET("/paypal_payments/{paypalPaymentId}/order")
  Call<Document> retrievePaypalPaymentOrder(@Path("paypalPaymentId") String paypalPaymentId,
      @QueryMap Map<String, String> queryStringParams);
}
