package io.commercelayer.api.service.document;

import io.commercelayer.api.model.Customer;
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

public interface CustomerService {
  @GET("/customers")
  Call<Document> listCustomers();

  @GET("/customers")
  Call<Document> listCustomers(@QueryMap Map<String, String> queryStringParams);

  @POST("/customers")
  Call<Document> createCustomer(@Body Customer customer);

  @GET("/customers/{customerId}")
  Call<Document> retrieveCustomer(@Path("customerId") String customerId);

  @GET("/customers/{customerId}")
  Call<Document> retrieveCustomer(@Path("customerId") String customerId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/customers/{customerId}")
  Call<Document> updateCustomer(@Path("customerId") String customerId, @Body Customer customer);

  @DELETE("/customers/{customerId}")
  Call<Void> deleteCustomer(@Path("customerId") String customerId);

  @GET("/customers/{customerId}/customer_addresses")
  Call<Document> listCustomerCustomerAddresses(@Path("customerId") String customerId);

  @GET("/customers/{customerId}/customer_addresses")
  Call<Document> listCustomerCustomerAddresses(@Path("customerId") String customerId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/customers/{customerId}/customer_payment_sources")
  Call<Document> listCustomerCustomerPaymentSources(@Path("customerId") String customerId);

  @GET("/customers/{customerId}/customer_payment_sources")
  Call<Document> listCustomerCustomerPaymentSources(@Path("customerId") String customerId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/customers/{customerId}/customer_subscriptions")
  Call<Document> listCustomerCustomerSubscriptions(@Path("customerId") String customerId);

  @GET("/customers/{customerId}/customer_subscriptions")
  Call<Document> listCustomerCustomerSubscriptions(@Path("customerId") String customerId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/customers/{customerId}/orders")
  Call<Document> listCustomerOrders(@Path("customerId") String customerId);

  @GET("/customers/{customerId}/orders")
  Call<Document> listCustomerOrders(@Path("customerId") String customerId,
      @QueryMap Map<String, String> queryStringParams);
}
