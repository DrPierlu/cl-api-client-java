package io.commercelayer.api.service;

import io.commercelayer.api.model.Order;
import io.commercelayer.api.model.PaypalPayment;
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

public interface PaypalPaymentService {
  @GET("/paypal_payments")
  Call<List<PaypalPayment>> listPaypalPayments();

  @GET("/paypal_payments")
  Call<List<PaypalPayment>> listPaypalPayments(@QueryMap Map<String, String> queryStringParams);

  @POST("/paypal_payments")
  Call<PaypalPayment> createPaypalPayment(@Body PaypalPayment paypalPayment);

  @GET("/paypal_payments/{paypalPaymentId}")
  Call<PaypalPayment> retrievePaypalPayment(@Path("paypalPaymentId") String paypalPaymentId);

  @GET("/paypal_payments/{paypalPaymentId}")
  Call<PaypalPayment> retrievePaypalPayment(@Path("paypalPaymentId") String paypalPaymentId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/paypal_payments/{paypalPaymentId}")
  Call<PaypalPayment> updatePaypalPayment(@Path("paypalPaymentId") String paypalPaymentId,
      @Body PaypalPayment paypalPayment);

  @DELETE("/paypal_payments/{paypalPaymentId}")
  Call<Void> deletePaypalPayment(@Path("paypalPaymentId") String paypalPaymentId);

  @GET("/paypal_payments/{paypalPaymentId}/order")
  Call<Order> retrievePaypalPaymentOrder(@Path("paypalPaymentId") String paypalPaymentId);

  @GET("/paypal_payments/{paypalPaymentId}/order")
  Call<Order> retrievePaypalPaymentOrder(@Path("paypalPaymentId") String paypalPaymentId,
      @QueryMap Map<String, String> queryStringParams);
}
