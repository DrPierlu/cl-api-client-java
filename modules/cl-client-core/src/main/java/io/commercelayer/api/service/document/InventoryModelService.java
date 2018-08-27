package io.commercelayer.api.service.document;

import io.commercelayer.api.model.InventoryModel;
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

public interface InventoryModelService {
  @GET("/inventory_models")
  Call<Document> listInventoryModels();

  @GET("/inventory_models")
  Call<Document> listInventoryModels(@QueryMap Map<String, String> queryStringParams);

  @POST("/inventory_models")
  Call<Document> createInventoryModel(@Body InventoryModel inventoryModel);

  @GET("/inventory_models/{inventoryModelId}")
  Call<Document> retrieveInventoryModel(@Path("inventoryModelId") String inventoryModelId);

  @GET("/inventory_models/{inventoryModelId}")
  Call<Document> retrieveInventoryModel(@Path("inventoryModelId") String inventoryModelId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/inventory_models/{inventoryModelId}")
  Call<Document> updateInventoryModel(@Path("inventoryModelId") String inventoryModelId,
      @Body InventoryModel inventoryModel);

  @DELETE("/inventory_models/{inventoryModelId}")
  Call<Void> deleteInventoryModel(@Path("inventoryModelId") String inventoryModelId);

  @GET("/inventory_models/{inventoryModelId}/stock_levels")
  Call<Document> listInventoryModelStockLevels(@Path("inventoryModelId") String inventoryModelId);

  @GET("/inventory_models/{inventoryModelId}/stock_levels")
  Call<Document> listInventoryModelStockLevels(@Path("inventoryModelId") String inventoryModelId,
      @QueryMap Map<String, String> queryStringParams);
}
