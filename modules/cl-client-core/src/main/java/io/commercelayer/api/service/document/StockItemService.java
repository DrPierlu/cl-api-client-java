package io.commercelayer.api.service.document;

import io.commercelayer.api.model.StockItem;
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

public interface StockItemService {
  @GET("/stock_items")
  Call<Document> listStockItems();

  @GET("/stock_items")
  Call<Document> listStockItems(@QueryMap Map<String, String> queryStringParams);

  @POST("/stock_items")
  Call<Document> createStockItem(@Body StockItem stockItem);

  @GET("/stock_items/{stockItemId}")
  Call<Document> retrieveStockItem(@Path("stockItemId") String stockItemId);

  @GET("/stock_items/{stockItemId}")
  Call<Document> retrieveStockItem(@Path("stockItemId") String stockItemId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/stock_items/{stockItemId}")
  Call<Document> updateStockItem(@Path("stockItemId") String stockItemId,
      @Body StockItem stockItem);

  @DELETE("/stock_items/{stockItemId}")
  Call<Void> deleteStockItem(@Path("stockItemId") String stockItemId);

  @GET("/stock_items/{stockItemId}/sku")
  Call<Document> retrieveStockItemSku(@Path("stockItemId") String stockItemId);

  @GET("/stock_items/{stockItemId}/sku")
  Call<Document> retrieveStockItemSku(@Path("stockItemId") String stockItemId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/stock_items/{stockItemId}/stock_location")
  Call<Document> retrieveStockItemStockLocation(@Path("stockItemId") String stockItemId);

  @GET("/stock_items/{stockItemId}/stock_location")
  Call<Document> retrieveStockItemStockLocation(@Path("stockItemId") String stockItemId,
      @QueryMap Map<String, String> queryStringParams);
}
