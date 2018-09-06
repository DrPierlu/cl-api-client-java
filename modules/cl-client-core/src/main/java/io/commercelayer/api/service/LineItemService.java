package io.commercelayer.api.service;

import io.commercelayer.api.model.LineItem;
import io.commercelayer.api.model.LineItemOption;
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

public interface LineItemService {
  @POST("line_items")
  Call<LineItem> createLineItem(@Body LineItem lineItem);

  @GET("line_items")
  Call<List<LineItem>> listLineItems();

  @GET("line_items")
  Call<List<LineItem>> listLineItems(@QueryMap Map<String, String> queryStringParams);

  @DELETE("line_items/{lineItemId}")
  Call<Void> deleteLineItem(@Path("lineItemId") String lineItemId);

  @PATCH("line_items/{lineItemId}")
  Call<LineItem> updateLineItem(@Path("lineItemId") String lineItemId, @Body LineItem lineItem);

  @GET("line_items/{lineItemId}")
  Call<LineItem> retrieveLineItem(@Path("lineItemId") String lineItemId);

  @GET("line_items/{lineItemId}")
  Call<LineItem> retrieveLineItem(@Path("lineItemId") String lineItemId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("line_items/{lineItemId}/line_item_options")
  Call<List<LineItemOption>> listLineItemLineItemOptions(@Path("lineItemId") String lineItemId);

  @GET("line_items/{lineItemId}/line_item_options")
  Call<List<LineItemOption>> listLineItemLineItemOptions(@Path("lineItemId") String lineItemId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("line_items/{lineItemId}/order")
  Call<Order> retrieveLineItemOrder(@Path("lineItemId") String lineItemId);

  @GET("line_items/{lineItemId}/order")
  Call<Order> retrieveLineItemOrder(@Path("lineItemId") String lineItemId,
      @QueryMap Map<String, String> queryStringParams);
}
