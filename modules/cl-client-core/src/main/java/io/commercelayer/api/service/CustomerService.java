package io.commercelayer.api.service;

import io.commercelayer.api.model.Customer;
import io.commercelayer.api.model.CustomerAddress;
import io.commercelayer.api.model.CustomerPaymentSource;
import io.commercelayer.api.model.CustomerSubscription;
import io.commercelayer.api.model.Order;
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

public interface CustomerService {
  @POST("customers")
  Call<Customer> createCustomer(@Body Customer customer);

  @GET("customers")
  Call<List<Customer>> listCustomers();

  @GET("customers")
  Call<List<Customer>> listCustomers(@QueryMap Map<String, String> queryStringParams);

  @DELETE("customers/{customerId}")
  Call<Void> deleteCustomer(@Path("customerId") String customerId);

  @PATCH("customers/{customerId}")
  Call<Customer> updateCustomer(@Path("customerId") String customerId, @Body Customer customer);

  @GET("customers/{customerId}")
  Call<Customer> retrieveCustomer(@Path("customerId") String customerId);

  @GET("customers/{customerId}")
  Call<Customer> retrieveCustomer(@Path("customerId") String customerId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("customers/{customerId}/customer_addresses")
  Call<List<CustomerAddress>> listCustomerCustomerAddresses(@Path("customerId") String customerId);

  @GET("customers/{customerId}/customer_addresses")
  Call<List<CustomerAddress>> listCustomerCustomerAddresses(@Path("customerId") String customerId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("customers/{customerId}/customer_payment_sources")
  Call<List<CustomerPaymentSource>> listCustomerCustomerPaymentSources(
      @Path("customerId") String customerId);

  @GET("customers/{customerId}/customer_payment_sources")
  Call<List<CustomerPaymentSource>> listCustomerCustomerPaymentSources(
      @Path("customerId") String customerId, @QueryMap Map<String, String> queryStringParams);

  @GET("customers/{customerId}/customer_subscriptions")
  Call<List<CustomerSubscription>> listCustomerCustomerSubscriptions(
      @Path("customerId") String customerId);

  @GET("customers/{customerId}/customer_subscriptions")
  Call<List<CustomerSubscription>> listCustomerCustomerSubscriptions(
      @Path("customerId") String customerId, @QueryMap Map<String, String> queryStringParams);

  @GET("customers/{customerId}/orders")
  Call<List<Order>> listCustomerOrders(@Path("customerId") String customerId);

  @GET("customers/{customerId}/orders")
  Call<List<Order>> listCustomerOrders(@Path("customerId") String customerId,
      @QueryMap Map<String, String> queryStringParams);
}
