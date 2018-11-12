package io.commercelayer.api.service;

import io.commercelayer.api.model.InventoryModel;
import io.commercelayer.api.model.StockLevel;
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

public interface StockLevelService {
  @GET("stock_levels")
  Call<List<StockLevel>> listStockLevels();

  @GET("stock_levels")
  Call<List<StockLevel>> listStockLevels(@QueryMap Map<String, String> queryStringParams);

  @POST("stock_levels")
  Call<StockLevel> createStockLevel(@Body StockLevel stockLevel);

  @PATCH("stock_levels/{stockLevelId}")
  Call<StockLevel> updateStockLevel(@Path("stockLevelId") String stockLevelId,
      @Body StockLevel stockLevel);

  @DELETE("stock_levels/{stockLevelId}")
  Call<Void> deleteStockLevel(@Path("stockLevelId") String stockLevelId);

  @GET("stock_levels/{stockLevelId}")
  Call<StockLevel> retrieveStockLevel(@Path("stockLevelId") String stockLevelId);

  @GET("stock_levels/{stockLevelId}")
  Call<StockLevel> retrieveStockLevel(@Path("stockLevelId") String stockLevelId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("stock_levels/{stockLevelId}/inventory_model")
  Call<InventoryModel> retrieveStockLevelInventoryModel(@Path("stockLevelId") String stockLevelId);

  @GET("stock_levels/{stockLevelId}/inventory_model")
  Call<InventoryModel> retrieveStockLevelInventoryModel(@Path("stockLevelId") String stockLevelId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("stock_levels/{stockLevelId}/stock_location")
  Call<StockLocation> retrieveStockLevelStockLocation(@Path("stockLevelId") String stockLevelId);

  @GET("stock_levels/{stockLevelId}/stock_location")
  Call<StockLocation> retrieveStockLevelStockLocation(@Path("stockLevelId") String stockLevelId,
      @QueryMap Map<String, String> queryStringParams);
}
