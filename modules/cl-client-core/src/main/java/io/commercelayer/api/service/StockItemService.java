package io.commercelayer.api.service;

import io.commercelayer.api.model.Sku;
import io.commercelayer.api.model.StockItem;
import io.commercelayer.api.model.StockLocation;
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

public interface StockItemService {
  @GET("stock_items")
  Call<List<StockItem>> listStockItems();

  @GET("stock_items")
  Call<List<StockItem>> listStockItems(@QueryMap Map<String, String> queryStringParams);

  @POST("stock_items")
  Call<StockItem> createStockItem(@Body StockItem stockItem);

  @PATCH("stock_items/{stockItemId}")
  Call<StockItem> updateStockItem(@Path("stockItemId") String stockItemId,
      @Body StockItem stockItem);

  @GET("stock_items/{stockItemId}")
  Call<StockItem> retrieveStockItem(@Path("stockItemId") String stockItemId);

  @GET("stock_items/{stockItemId}")
  Call<StockItem> retrieveStockItem(@Path("stockItemId") String stockItemId,
      @QueryMap Map<String, String> queryStringParams);

  @DELETE("stock_items/{stockItemId}")
  Call<Void> deleteStockItem(@Path("stockItemId") String stockItemId);

  @GET("stock_items/{stockItemId}/sku")
  Call<Sku> retrieveStockItemSku(@Path("stockItemId") String stockItemId);

  @GET("stock_items/{stockItemId}/sku")
  Call<Sku> retrieveStockItemSku(@Path("stockItemId") String stockItemId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("stock_items/{stockItemId}/stock_location")
  Call<StockLocation> retrieveStockItemStockLocation(@Path("stockItemId") String stockItemId);

  @GET("stock_items/{stockItemId}/stock_location")
  Call<StockLocation> retrieveStockItemStockLocation(@Path("stockItemId") String stockItemId,
      @QueryMap Map<String, String> queryStringParams);
}
