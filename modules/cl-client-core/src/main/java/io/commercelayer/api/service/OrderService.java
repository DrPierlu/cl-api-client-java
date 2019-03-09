package io.commercelayer.api.service;

import io.commercelayer.api.model.Address;
import io.commercelayer.api.model.Customer;
import io.commercelayer.api.model.LineItem;
import io.commercelayer.api.model.Market;
import io.commercelayer.api.model.Order;
import io.commercelayer.api.model.PaymentMethod;
import io.commercelayer.api.model.Shipment;
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

public interface OrderService {
  @GET("orders")
  Call<List<Order>> listOrders();

  @GET("orders")
  Call<List<Order>> listOrders(@QueryMap Map<String, String> queryStringParams);

  @POST("orders")
  Call<Order> createOrder(@Body Order order);

  @POST("orders")
  Call<Order> createOrder(@Body Order order, @QueryMap Map<String, String> queryStringParams);

  @PATCH("orders/{orderId}")
  Call<Order> updateOrder(@Path("orderId") String orderId, @Body Order order);

  @PATCH("orders/{orderId}")
  Call<Order> updateOrder(@Path("orderId") String orderId, @Body Order order,
      @QueryMap Map<String, String> queryStringParams);

  @GET("orders/{orderId}")
  Call<Order> retrieveOrder(@Path("orderId") String orderId);

  @GET("orders/{orderId}")
  Call<Order> retrieveOrder(@Path("orderId") String orderId,
      @QueryMap Map<String, String> queryStringParams);

  @DELETE("orders/{orderId}")
  Call<Void> deleteOrder(@Path("orderId") String orderId);

  @GET("orders/{orderId}/billing_address")
  Call<List<Address>> retrieveOrderBillingAddress(@Path("orderId") String orderId);

  @GET("orders/{orderId}/billing_address")
  Call<List<Address>> retrieveOrderBillingAddress(@Path("orderId") String orderId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("orders/{orderId}/customer")
  Call<Customer> retrieveOrderCustomer(@Path("orderId") String orderId);

  @GET("orders/{orderId}/customer")
  Call<Customer> retrieveOrderCustomer(@Path("orderId") String orderId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("orders/{orderId}/line_items")
  Call<List<LineItem>> listOrderLineItems(@Path("orderId") String orderId);

  @GET("orders/{orderId}/line_items")
  Call<List<LineItem>> listOrderLineItems(@Path("orderId") String orderId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("orders/{orderId}/market")
  Call<Market> retrieveOrderMarket(@Path("orderId") String orderId);

  @GET("orders/{orderId}/market")
  Call<Market> retrieveOrderMarket(@Path("orderId") String orderId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("orders/{orderId}/payment_method")
  Call<PaymentMethod> retrieveOrderPaymentMethod(@Path("orderId") String orderId);

  @GET("orders/{orderId}/payment_method")
  Call<PaymentMethod> retrieveOrderPaymentMethod(@Path("orderId") String orderId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("orders/{orderId}/shipments")
  Call<List<Shipment>> listOrderShipments(@Path("orderId") String orderId);

  @GET("orders/{orderId}/shipments")
  Call<List<Shipment>> listOrderShipments(@Path("orderId") String orderId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("orders/{orderId}/shipping_address")
  Call<List<Address>> retrieveOrderShippingAddress(@Path("orderId") String orderId);

  @GET("orders/{orderId}/shipping_address")
  Call<List<Address>> retrieveOrderShippingAddress(@Path("orderId") String orderId,
      @QueryMap Map<String, String> queryStringParams);
}
