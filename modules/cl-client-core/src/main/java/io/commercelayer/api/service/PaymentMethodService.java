package io.commercelayer.api.service;

import io.commercelayer.api.model.Market;
import io.commercelayer.api.model.PaymentGateway;
import io.commercelayer.api.model.PaymentMethod;
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

public interface PaymentMethodService {
  @GET("payment_methods")
  Call<List<PaymentMethod>> listPaymentMethods();

  @GET("payment_methods")
  Call<List<PaymentMethod>> listPaymentMethods(@QueryMap Map<String, String> queryStringParams);

  @POST("payment_methods")
  Call<PaymentMethod> createPaymentMethod(@Body PaymentMethod paymentMethod);

  @DELETE("payment_methods/{paymentMethodId}")
  Call<Void> deletePaymentMethod(@Path("paymentMethodId") String paymentMethodId);

  @PATCH("payment_methods/{paymentMethodId}")
  Call<PaymentMethod> updatePaymentMethod(@Path("paymentMethodId") String paymentMethodId,
      @Body PaymentMethod paymentMethod);

  @GET("payment_methods/{paymentMethodId}")
  Call<PaymentMethod> retrievePaymentMethod(@Path("paymentMethodId") String paymentMethodId);

  @GET("payment_methods/{paymentMethodId}")
  Call<PaymentMethod> retrievePaymentMethod(@Path("paymentMethodId") String paymentMethodId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("payment_methods/{paymentMethodId}/market")
  Call<Market> retrievePaymentMethodMarket(@Path("paymentMethodId") String paymentMethodId);

  @GET("payment_methods/{paymentMethodId}/market")
  Call<Market> retrievePaymentMethodMarket(@Path("paymentMethodId") String paymentMethodId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("payment_methods/{paymentMethodId}/payment_gateway")
  Call<PaymentGateway> retrievePaymentMethodPaymentGateway(
      @Path("paymentMethodId") String paymentMethodId);

  @GET("payment_methods/{paymentMethodId}/payment_gateway")
  Call<PaymentGateway> retrievePaymentMethodPaymentGateway(
      @Path("paymentMethodId") String paymentMethodId,
      @QueryMap Map<String, String> queryStringParams);
}
