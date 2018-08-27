package io.commercelayer.api.service.document;

import io.commercelayer.api.model.Order;
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

public interface OrderService {
  @GET("/orders")
  Call<Document> listOrders();

  @GET("/orders")
  Call<Document> listOrders(@QueryMap Map<String, String> queryStringParams);

  @POST("/orders")
  Call<Document> createOrder(@Body Order order);

  @GET("/orders/{orderId}")
  Call<Document> retrieveOrder(@Path("orderId") String orderId);

  @GET("/orders/{orderId}")
  Call<Document> retrieveOrder(@Path("orderId") String orderId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/orders/{orderId}")
  Call<Document> updateOrder(@Path("orderId") String orderId, @Body Order order);

  @DELETE("/orders/{orderId}")
  Call<Void> deleteOrder(@Path("orderId") String orderId);

  @GET("/orders/{orderId}/billing_address")
  Call<Document> retrieveOrderBillingAddress(@Path("orderId") String orderId);

  @GET("/orders/{orderId}/billing_address")
  Call<Document> retrieveOrderBillingAddress(@Path("orderId") String orderId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/orders/{orderId}/customer")
  Call<Document> retrieveOrderCustomer(@Path("orderId") String orderId);

  @GET("/orders/{orderId}/customer")
  Call<Document> retrieveOrderCustomer(@Path("orderId") String orderId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/orders/{orderId}/line_items")
  Call<Document> listOrderLineItems(@Path("orderId") String orderId);

  @GET("/orders/{orderId}/line_items")
  Call<Document> listOrderLineItems(@Path("orderId") String orderId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/orders/{orderId}/market")
  Call<Document> retrieveOrderMarket(@Path("orderId") String orderId);

  @GET("/orders/{orderId}/market")
  Call<Document> retrieveOrderMarket(@Path("orderId") String orderId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/orders/{orderId}/payment_method")
  Call<Document> retrieveOrderPaymentMethod(@Path("orderId") String orderId);

  @GET("/orders/{orderId}/payment_method")
  Call<Document> retrieveOrderPaymentMethod(@Path("orderId") String orderId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/orders/{orderId}/shipments")
  Call<Document> listOrderShipments(@Path("orderId") String orderId);

  @GET("/orders/{orderId}/shipments")
  Call<Document> listOrderShipments(@Path("orderId") String orderId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/orders/{orderId}/shipping_address")
  Call<Document> retrieveOrderShippingAddress(@Path("orderId") String orderId);

  @GET("/orders/{orderId}/shipping_address")
  Call<Document> retrieveOrderShippingAddress(@Path("orderId") String orderId,
      @QueryMap Map<String, String> queryStringParams);
}
