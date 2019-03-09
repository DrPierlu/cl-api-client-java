package io.commercelayer.api.service;

import io.commercelayer.api.model.Customer;
import io.commercelayer.api.model.CustomerPasswordReset;
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

public interface CustomerPasswordResetService {
  @GET("customer_password_resets")
  Call<List<CustomerPasswordReset>> listCustomerPasswordResets();

  @GET("customer_password_resets")
  Call<List<CustomerPasswordReset>> listCustomerPasswordResets(
      @QueryMap Map<String, String> queryStringParams);

  @POST("customer_password_resets")
  Call<CustomerPasswordReset> createCustomerPasswordReset(
      @Body CustomerPasswordReset customerPasswordReset);

  @PATCH("customer_password_resets/{customerPasswordResetId}")
  Call<CustomerPasswordReset> updateCustomerPasswordReset(
      @Path("customerPasswordResetId") String customerPasswordResetId,
      @Body CustomerPasswordReset customerPasswordReset);

  @GET("customer_password_resets/{customerPasswordResetId}")
  Call<CustomerPasswordReset> retrieveCustomerPasswordReset(
      @Path("customerPasswordResetId") String customerPasswordResetId);

  @GET("customer_password_resets/{customerPasswordResetId}")
  Call<CustomerPasswordReset> retrieveCustomerPasswordReset(
      @Path("customerPasswordResetId") String customerPasswordResetId,
      @QueryMap Map<String, String> queryStringParams);

  @DELETE("customer_password_resets/{customerPasswordResetId}")
  Call<Void> deleteCustomerPasswordReset(
      @Path("customerPasswordResetId") String customerPasswordResetId);

  @GET("customer_password_resets/{customerPasswordResetId}/customer")
  Call<Customer> retrieveCustomerPasswordResetCustomer(
      @Path("customerPasswordResetId") String customerPasswordResetId);

  @GET("customer_password_resets/{customerPasswordResetId}/customer")
  Call<Customer> retrieveCustomerPasswordResetCustomer(
      @Path("customerPasswordResetId") String customerPasswordResetId,
      @QueryMap Map<String, String> queryStringParams);
}
