package io.commercelayer.api.service;

import java.util.Map;

import io.commercelayer.api.model.Order;
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
	Call<Order> listOrders(@QueryMap Map<String, String> queryStringParams);
	
	@GET("orders/{id}")
	Call<Order> retrieveOrder(@Path("id") String id, @QueryMap Map<String, String> queryStringParams);
	
	@PATCH("orders/{id}")
	Call<Order> updateOrder(@Path("id") String id, @Body Order order);
	
	@DELETE("orders/{id}")
	Call<Order> deleteOrder(@Path("id") String id);
	
}
