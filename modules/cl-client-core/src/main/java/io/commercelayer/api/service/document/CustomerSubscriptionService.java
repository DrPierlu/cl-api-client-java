package io.commercelayer.api.service.document;

import io.commercelayer.api.model.CustomerSubscription;
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

public interface CustomerSubscriptionService {
  @GET("/customer_subscriptions")
  Call<Document> listCustomerSubscriptions();

  @GET("/customer_subscriptions")
  Call<Document> listCustomerSubscriptions(@QueryMap Map<String, String> queryStringParams);

  @POST("/customer_subscriptions")
  Call<Document> createCustomerSubscription(@Body CustomerSubscription customerSubscription);

  @GET("/customer_subscriptions/{customerSubscriptionId}")
  Call<Document> retrieveCustomerSubscription(
      @Path("customerSubscriptionId") String customerSubscriptionId);

  @GET("/customer_subscriptions/{customerSubscriptionId}")
  Call<Document> retrieveCustomerSubscription(
      @Path("customerSubscriptionId") String customerSubscriptionId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/customer_subscriptions/{customerSubscriptionId}")
  Call<Document> updateCustomerSubscription(
      @Path("customerSubscriptionId") String customerSubscriptionId,
      @Body CustomerSubscription customerSubscription);

  @DELETE("/customer_subscriptions/{customerSubscriptionId}")
  Call<Void> deleteCustomerSubscription(
      @Path("customerSubscriptionId") String customerSubscriptionId);

  @GET("/customer_subscriptions/{customerSubscriptionId}/customer")
  Call<Document> retrieveCustomerSubscriptionCustomer(
      @Path("customerSubscriptionId") String customerSubscriptionId);

  @GET("/customer_subscriptions/{customerSubscriptionId}/customer")
  Call<Document> retrieveCustomerSubscriptionCustomer(
      @Path("customerSubscriptionId") String customerSubscriptionId,
      @QueryMap Map<String, String> queryStringParams);
}
