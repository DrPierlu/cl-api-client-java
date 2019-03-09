package io.commercelayer.api.service;

import io.commercelayer.api.model.Address;
import io.commercelayer.api.model.StockItem;
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

public interface StockLocationService {
  @GET("stock_locations")
  Call<List<StockLocation>> listStockLocations();

  @GET("stock_locations")
  Call<List<StockLocation>> listStockLocations(@QueryMap Map<String, String> queryStringParams);

  @POST("stock_locations")
  Call<StockLocation> createStockLocation(@Body StockLocation stockLocation);

  @PATCH("stock_locations/{stockLocationId}")
  Call<StockLocation> updateStockLocation(@Path("stockLocationId") String stockLocationId,
      @Body StockLocation stockLocation);

  @GET("stock_locations/{stockLocationId}")
  Call<StockLocation> retrieveStockLocation(@Path("stockLocationId") String stockLocationId);

  @GET("stock_locations/{stockLocationId}")
  Call<StockLocation> retrieveStockLocation(@Path("stockLocationId") String stockLocationId,
      @QueryMap Map<String, String> queryStringParams);

  @DELETE("stock_locations/{stockLocationId}")
  Call<Void> deleteStockLocation(@Path("stockLocationId") String stockLocationId);

  @GET("stock_locations/{stockLocationId}/address")
  Call<Address> retrieveStockLocationAddress(@Path("stockLocationId") String stockLocationId);

  @GET("stock_locations/{stockLocationId}/address")
  Call<Address> retrieveStockLocationAddress(@Path("stockLocationId") String stockLocationId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("stock_locations/{stockLocationId}/stock_items")
  Call<List<StockItem>> listStockLocationStockItems(
      @Path("stockLocationId") String stockLocationId);

  @GET("stock_locations/{stockLocationId}/stock_items")
  Call<List<StockItem>> listStockLocationStockItems(@Path("stockLocationId") String stockLocationId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("stock_locations/{stockLocationId}/stock_levels")
  Call<List<StockLevel>> listStockLocationStockLevels(
      @Path("stockLocationId") String stockLocationId);

  @GET("stock_locations/{stockLocationId}/stock_levels")
  Call<List<StockLevel>> listStockLocationStockLevels(
      @Path("stockLocationId") String stockLocationId,
      @QueryMap Map<String, String> queryStringParams);
}
