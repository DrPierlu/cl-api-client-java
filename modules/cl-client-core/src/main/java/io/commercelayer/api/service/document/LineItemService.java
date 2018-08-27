package io.commercelayer.api.service.document;

import io.commercelayer.api.model.LineItem;
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

public interface LineItemService {
  @GET("/line_items")
  Call<Document> listLineItems();

  @GET("/line_items")
  Call<Document> listLineItems(@QueryMap Map<String, String> queryStringParams);

  @POST("/line_items")
  Call<Document> createLineItem(@Body LineItem lineItem);

  @GET("/line_items/{lineItemId}")
  Call<Document> retrieveLineItem(@Path("lineItemId") String lineItemId);

  @GET("/line_items/{lineItemId}")
  Call<Document> retrieveLineItem(@Path("lineItemId") String lineItemId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/line_items/{lineItemId}")
  Call<Document> updateLineItem(@Path("lineItemId") String lineItemId, @Body LineItem lineItem);

  @DELETE("/line_items/{lineItemId}")
  Call<Void> deleteLineItem(@Path("lineItemId") String lineItemId);

  @GET("/line_items/{lineItemId}/line_item_options")
  Call<Document> listLineItemLineItemOptions(@Path("lineItemId") String lineItemId);

  @GET("/line_items/{lineItemId}/line_item_options")
  Call<Document> listLineItemLineItemOptions(@Path("lineItemId") String lineItemId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/line_items/{lineItemId}/order")
  Call<Document> retrieveLineItemOrder(@Path("lineItemId") String lineItemId);

  @GET("/line_items/{lineItemId}/order")
  Call<Document> retrieveLineItemOrder(@Path("lineItemId") String lineItemId,
      @QueryMap Map<String, String> queryStringParams);
}
