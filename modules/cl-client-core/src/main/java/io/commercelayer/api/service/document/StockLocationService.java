package io.commercelayer.api.service.document;

import io.commercelayer.api.model.StockLocation;
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

public interface StockLocationService {
  @GET("/stock_locations")
  Call<Document> listStockLocations();

  @GET("/stock_locations")
  Call<Document> listStockLocations(@QueryMap Map<String, String> queryStringParams);

  @POST("/stock_locations")
  Call<Document> createStockLocation(@Body StockLocation stockLocation);

  @GET("/stock_locations/{stockLocationId}")
  Call<Document> retrieveStockLocation(@Path("stockLocationId") String stockLocationId);

  @GET("/stock_locations/{stockLocationId}")
  Call<Document> retrieveStockLocation(@Path("stockLocationId") String stockLocationId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/stock_locations/{stockLocationId}")
  Call<Document> updateStockLocation(@Path("stockLocationId") String stockLocationId,
      @Body StockLocation stockLocation);

  @DELETE("/stock_locations/{stockLocationId}")
  Call<Void> deleteStockLocation(@Path("stockLocationId") String stockLocationId);

  @GET("/stock_locations/{stockLocationId}/address")
  Call<Document> retrieveStockLocationAddress(@Path("stockLocationId") String stockLocationId);

  @GET("/stock_locations/{stockLocationId}/address")
  Call<Document> retrieveStockLocationAddress(@Path("stockLocationId") String stockLocationId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/stock_locations/{stockLocationId}/stock_items")
  Call<Document> listStockLocationStockItems(@Path("stockLocationId") String stockLocationId);

  @GET("/stock_locations/{stockLocationId}/stock_items")
  Call<Document> listStockLocationStockItems(@Path("stockLocationId") String stockLocationId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/stock_locations/{stockLocationId}/stock_levels")
  Call<Document> listStockLocationStockLevels(@Path("stockLocationId") String stockLocationId);

  @GET("/stock_locations/{stockLocationId}/stock_levels")
  Call<Document> listStockLocationStockLevels(@Path("stockLocationId") String stockLocationId,
      @QueryMap Map<String, String> queryStringParams);
}
