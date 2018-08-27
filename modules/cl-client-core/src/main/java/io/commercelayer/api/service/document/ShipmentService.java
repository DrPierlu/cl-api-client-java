package io.commercelayer.api.service.document;

import io.commercelayer.api.model.Shipment;
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

public interface ShipmentService {
  @GET("/shipments")
  Call<Document> listShipments();

  @GET("/shipments")
  Call<Document> listShipments(@QueryMap Map<String, String> queryStringParams);

  @POST("/shipments")
  Call<Document> createShipment(@Body Shipment shipment);

  @GET("/shipments/{shipmentId}")
  Call<Document> retrieveShipment(@Path("shipmentId") String shipmentId);

  @GET("/shipments/{shipmentId}")
  Call<Document> retrieveShipment(@Path("shipmentId") String shipmentId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/shipments/{shipmentId}")
  Call<Document> updateShipment(@Path("shipmentId") String shipmentId, @Body Shipment shipment);

  @DELETE("/shipments/{shipmentId}")
  Call<Void> deleteShipment(@Path("shipmentId") String shipmentId);

  @GET("/shipments/{shipmentId}/available_shipping_methods")
  Call<Document> listShipmentAvailableShippingMethods(@Path("shipmentId") String shipmentId);

  @GET("/shipments/{shipmentId}/available_shipping_methods")
  Call<Document> listShipmentAvailableShippingMethods(@Path("shipmentId") String shipmentId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/shipments/{shipmentId}/parcels")
  Call<Document> listShipmentParcels(@Path("shipmentId") String shipmentId);

  @GET("/shipments/{shipmentId}/parcels")
  Call<Document> listShipmentParcels(@Path("shipmentId") String shipmentId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/shipments/{shipmentId}/shipment_line_items")
  Call<Document> listShipmentShipmentLineItems(@Path("shipmentId") String shipmentId);

  @GET("/shipments/{shipmentId}/shipment_line_items")
  Call<Document> listShipmentShipmentLineItems(@Path("shipmentId") String shipmentId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/shipments/{shipmentId}/shipping_address")
  Call<Document> retrieveShipmentShippingAddress(@Path("shipmentId") String shipmentId);

  @GET("/shipments/{shipmentId}/shipping_address")
  Call<Document> retrieveShipmentShippingAddress(@Path("shipmentId") String shipmentId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/shipments/{shipmentId}/shipping_category")
  Call<Document> retrieveShipmentShippingCategory(@Path("shipmentId") String shipmentId);

  @GET("/shipments/{shipmentId}/shipping_category")
  Call<Document> retrieveShipmentShippingCategory(@Path("shipmentId") String shipmentId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/shipments/{shipmentId}/shipping_method")
  Call<Document> retrieveShipmentShippingMethod(@Path("shipmentId") String shipmentId);

  @GET("/shipments/{shipmentId}/shipping_method")
  Call<Document> retrieveShipmentShippingMethod(@Path("shipmentId") String shipmentId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/shipments/{shipmentId}/stock_location")
  Call<Document> retrieveShipmentStockLocation(@Path("shipmentId") String shipmentId);

  @GET("/shipments/{shipmentId}/stock_location")
  Call<Document> retrieveShipmentStockLocation(@Path("shipmentId") String shipmentId,
      @QueryMap Map<String, String> queryStringParams);
}
