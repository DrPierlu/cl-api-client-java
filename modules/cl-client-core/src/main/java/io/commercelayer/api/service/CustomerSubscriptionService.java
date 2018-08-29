package io.commercelayer.api.service;

import io.commercelayer.api.model.Customer;
import io.commercelayer.api.model.CustomerSubscription;
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

public interface CustomerSubscriptionService {
  @POST("customer_subscriptions")
  Call<CustomerSubscription> createCustomerSubscription(
      @Body CustomerSubscription customerSubscription);

  @GET("customer_subscriptions")
  Call<List<CustomerSubscription>> listCustomerSubscriptions();

  @GET("customer_subscriptions")
  Call<List<CustomerSubscription>> listCustomerSubscriptions(
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("customer_subscriptions/{customerSubscriptionId}")
  Call<CustomerSubscription> updateCustomerSubscription(
      @Path("customerSubscriptionId") String customerSubscriptionId,
      @Body CustomerSubscription customerSubscription);

  @DELETE("customer_subscriptions/{customerSubscriptionId}")
  Call<Void> deleteCustomerSubscription(
      @Path("customerSubscriptionId") String customerSubscriptionId);

  @GET("customer_subscriptions/{customerSubscriptionId}")
  Call<CustomerSubscription> retrieveCustomerSubscription(
      @Path("customerSubscriptionId") String customerSubscriptionId);

  @GET("customer_subscriptions/{customerSubscriptionId}")
  Call<CustomerSubscription> retrieveCustomerSubscription(
      @Path("customerSubscriptionId") String customerSubscriptionId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("customer_subscriptions/{customerSubscriptionId}/customer")
  Call<Customer> retrieveCustomerSubscriptionCustomer(
      @Path("customerSubscriptionId") String customerSubscriptionId);

  @GET("customer_subscriptions/{customerSubscriptionId}/customer")
  Call<Customer> retrieveCustomerSubscriptionCustomer(
      @Path("customerSubscriptionId") String customerSubscriptionId,
      @QueryMap Map<String, String> queryStringParams);
}
