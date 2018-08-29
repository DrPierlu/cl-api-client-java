package io.commercelayer.api.service;

import io.commercelayer.api.model.Customer;
import io.commercelayer.api.model.CustomerPaymentSource;
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

public interface CustomerPaymentSourceService {
  @POST("customer_payment_sources")
  Call<CustomerPaymentSource> createCustomerPaymentSource(
      @Body CustomerPaymentSource customerPaymentSource);

  @GET("customer_payment_sources")
  Call<List<CustomerPaymentSource>> listCustomerPaymentSources();

  @GET("customer_payment_sources")
  Call<List<CustomerPaymentSource>> listCustomerPaymentSources(
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("customer_payment_sources/{customerPaymentSourceId}")
  Call<CustomerPaymentSource> updateCustomerPaymentSource(
      @Path("customerPaymentSourceId") String customerPaymentSourceId,
      @Body CustomerPaymentSource customerPaymentSource);

  @DELETE("customer_payment_sources/{customerPaymentSourceId}")
  Call<Void> deleteCustomerPaymentSource(
      @Path("customerPaymentSourceId") String customerPaymentSourceId);

  @GET("customer_payment_sources/{customerPaymentSourceId}")
  Call<CustomerPaymentSource> retrieveCustomerPaymentSource(
      @Path("customerPaymentSourceId") String customerPaymentSourceId);

  @GET("customer_payment_sources/{customerPaymentSourceId}")
  Call<CustomerPaymentSource> retrieveCustomerPaymentSource(
      @Path("customerPaymentSourceId") String customerPaymentSourceId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("customer_payment_sources/{customerPaymentSourceId}/customer")
  Call<Customer> retrieveCustomerPaymentSourceCustomer(
      @Path("customerPaymentSourceId") String customerPaymentSourceId);

  @GET("customer_payment_sources/{customerPaymentSourceId}/customer")
  Call<Customer> retrieveCustomerPaymentSourceCustomer(
      @Path("customerPaymentSourceId") String customerPaymentSourceId,
      @QueryMap Map<String, String> queryStringParams);
}
