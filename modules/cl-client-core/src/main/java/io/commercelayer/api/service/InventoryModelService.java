package io.commercelayer.api.service;

import io.commercelayer.api.model.InventoryModel;
import io.commercelayer.api.model.StockLevel;
import java.lang.String;
import java.lang.Void;
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

public interface InventoryModelService {
  @POST("inventory_models")
  Call<InventoryModel> createInventoryModel(@Body InventoryModel inventoryModel);

  @GET("inventory_models")
  Call<List<InventoryModel>> listInventoryModels();

  @GET("inventory_models")
  Call<List<InventoryModel>> listInventoryModels(@QueryMap Map<String, String> queryStringParams);

  @PATCH("inventory_models/{inventoryModelId}")
  Call<InventoryModel> updateInventoryModel(@Path("inventoryModelId") String inventoryModelId,
      @Body InventoryModel inventoryModel);

  @DELETE("inventory_models/{inventoryModelId}")
  Call<Void> deleteInventoryModel(@Path("inventoryModelId") String inventoryModelId);

  @GET("inventory_models/{inventoryModelId}")
  Call<InventoryModel> retrieveInventoryModel(@Path("inventoryModelId") String inventoryModelId);

  @GET("inventory_models/{inventoryModelId}")
  Call<InventoryModel> retrieveInventoryModel(@Path("inventoryModelId") String inventoryModelId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("inventory_models/{inventoryModelId}/stock_levels")
  Call<List<StockLevel>> listInventoryModelStockLevels(
      @Path("inventoryModelId") String inventoryModelId);

  @GET("inventory_models/{inventoryModelId}/stock_levels")
  Call<List<StockLevel>> listInventoryModelStockLevels(
      @Path("inventoryModelId") String inventoryModelId,
      @QueryMap Map<String, String> queryStringParams);
}
