package io.commercelayer.api.service;

import io.commercelayer.api.model.LineItem;
import io.commercelayer.api.model.LineItemOption;
import io.commercelayer.api.model.SkuOption;
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

public interface LineItemOptionService {
  @GET("line_item_options")
  Call<List<LineItemOption>> listLineItemOptions();

  @GET("line_item_options")
  Call<List<LineItemOption>> listLineItemOptions(@QueryMap Map<String, String> queryStringParams);

  @POST("line_item_options")
  Call<LineItemOption> createLineItemOption(@Body LineItemOption lineItemOption);

  @DELETE("line_item_options/{lineItemOptionId}")
  Call<Void> deleteLineItemOption(@Path("lineItemOptionId") String lineItemOptionId);

  @PATCH("line_item_options/{lineItemOptionId}")
  Call<LineItemOption> updateLineItemOption(@Path("lineItemOptionId") String lineItemOptionId,
      @Body LineItemOption lineItemOption);

  @GET("line_item_options/{lineItemOptionId}")
  Call<LineItemOption> retrieveLineItemOption(@Path("lineItemOptionId") String lineItemOptionId);

  @GET("line_item_options/{lineItemOptionId}")
  Call<LineItemOption> retrieveLineItemOption(@Path("lineItemOptionId") String lineItemOptionId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("line_item_options/{lineItemOptionId}/line_item")
  Call<LineItem> retrieveLineItemOptionLineItem(@Path("lineItemOptionId") String lineItemOptionId);

  @GET("line_item_options/{lineItemOptionId}/line_item")
  Call<LineItem> retrieveLineItemOptionLineItem(@Path("lineItemOptionId") String lineItemOptionId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("line_item_options/{lineItemOptionId}/sku_option")
  Call<SkuOption> retrieveLineItemOptionSkuOption(
      @Path("lineItemOptionId") String lineItemOptionId);

  @GET("line_item_options/{lineItemOptionId}/sku_option")
  Call<SkuOption> retrieveLineItemOptionSkuOption(@Path("lineItemOptionId") String lineItemOptionId,
      @QueryMap Map<String, String> queryStringParams);
}
