package io.commercelayer.api.service.document;

import io.commercelayer.api.model.StockLevel;
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

public interface StockLevelService {
  @GET("/stock_levels")
  Call<Document> listStockLevels();

  @GET("/stock_levels")
  Call<Document> listStockLevels(@QueryMap Map<String, String> queryStringParams);

  @POST("/stock_levels")
  Call<Document> createStockLevel(@Body StockLevel stockLevel);

  @GET("/stock_levels/{stockLevelId}")
  Call<Document> retrieveStockLevel(@Path("stockLevelId") String stockLevelId);

  @GET("/stock_levels/{stockLevelId}")
  Call<Document> retrieveStockLevel(@Path("stockLevelId") String stockLevelId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/stock_levels/{stockLevelId}")
  Call<Document> updateStockLevel(@Path("stockLevelId") String stockLevelId,
      @Body StockLevel stockLevel);

  @DELETE("/stock_levels/{stockLevelId}")
  Call<Void> deleteStockLevel(@Path("stockLevelId") String stockLevelId);

  @GET("/stock_levels/{stockLevelId}/inventory_model")
  Call<Document> retrieveStockLevelInventoryModel(@Path("stockLevelId") String stockLevelId);

  @GET("/stock_levels/{stockLevelId}/inventory_model")
  Call<Document> retrieveStockLevelInventoryModel(@Path("stockLevelId") String stockLevelId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/stock_levels/{stockLevelId}/stock_location")
  Call<Document> retrieveStockLevelStockLocation(@Path("stockLevelId") String stockLevelId);

  @GET("/stock_levels/{stockLevelId}/stock_location")
  Call<Document> retrieveStockLevelStockLocation(@Path("stockLevelId") String stockLevelId,
      @QueryMap Map<String, String> queryStringParams);
}
