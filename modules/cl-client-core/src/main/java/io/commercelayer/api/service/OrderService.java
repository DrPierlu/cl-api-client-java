package io.commercelayer.api.service;

import io.commercelayer.api.model.BillingAddress;
import io.commercelayer.api.model.Customer;
import io.commercelayer.api.model.LineItem;
import io.commercelayer.api.model.Market;
import io.commercelayer.api.model.Order;
import io.commercelayer.api.model.PaymentMethod;
import io.commercelayer.api.model.Shipment;
import io.commercelayer.api.model.ShippingAddress;
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

public interface OrderService {
  @POST("orders")
  Call<Order> createOrder(@Body Order order);

  @GET("orders")
  Call<List<Order>> listOrders();

  @GET("orders")
  Call<List<Order>> listOrders(@QueryMap Map<String, String> queryStringParams);

  @PATCH("orders/{orderId}")
  Call<Order> updateOrder(@Path("orderId") String orderId, @Body Order order);

  @DELETE("orders/{orderId}")
  Call<Void> deleteOrder(@Path("orderId") String orderId);

  @GET("orders/{orderId}")
  Call<Order> retrieveOrder(@Path("orderId") String orderId);

  @GET("orders/{orderId}")
  Call<Order> retrieveOrder(@Path("orderId") String orderId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("orders/{orderId}/billing_address")
  Call<BillingAddress> retrieveOrderBillingAddress(@Path("orderId") String orderId);

  @GET("orders/{orderId}/billing_address")
  Call<BillingAddress> retrieveOrderBillingAddress(@Path("orderId") String orderId,
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
  Call<ShippingAddress> retrieveOrderShippingAddress(@Path("orderId") String orderId);

  @GET("orders/{orderId}/shipping_address")
  Call<ShippingAddress> retrieveOrderShippingAddress(@Path("orderId") String orderId,
      @QueryMap Map<String, String> queryStringParams);
}
