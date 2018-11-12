package io.commercelayer.api.service;

import io.commercelayer.api.model.Address;
import io.commercelayer.api.model.LineItem;
import io.commercelayer.api.model.Parcel;
import io.commercelayer.api.model.Shipment;
import io.commercelayer.api.model.ShippingCategory;
import io.commercelayer.api.model.ShippingMethod;
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

public interface ShipmentService {
  @GET("shipments")
  Call<List<Shipment>> listShipments();

  @GET("shipments")
  Call<List<Shipment>> listShipments(@QueryMap Map<String, String> queryStringParams);

  @POST("shipments")
  Call<Shipment> createShipment(@Body Shipment shipment);

  @PATCH("shipments/{shipmentId}")
  Call<Shipment> updateShipment(@Path("shipmentId") String shipmentId, @Body Shipment shipment);

  @DELETE("shipments/{shipmentId}")
  Call<Void> deleteShipment(@Path("shipmentId") String shipmentId);

  @GET("shipments/{shipmentId}")
  Call<Shipment> retrieveShipment(@Path("shipmentId") String shipmentId);

  @GET("shipments/{shipmentId}")
  Call<Shipment> retrieveShipment(@Path("shipmentId") String shipmentId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("shipments/{shipmentId}/available_shipping_methods")
  Call<List<ShippingMethod>> listShipmentAvailableShippingMethods(
      @Path("shipmentId") String shipmentId);

  @GET("shipments/{shipmentId}/available_shipping_methods")
  Call<List<ShippingMethod>> listShipmentAvailableShippingMethods(
      @Path("shipmentId") String shipmentId, @QueryMap Map<String, String> queryStringParams);

  @GET("shipments/{shipmentId}/parcels")
  Call<List<Parcel>> listShipmentParcels(@Path("shipmentId") String shipmentId);

  @GET("shipments/{shipmentId}/parcels")
  Call<List<Parcel>> listShipmentParcels(@Path("shipmentId") String shipmentId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("shipments/{shipmentId}/shipment_line_items")
  Call<List<LineItem>> listShipmentShipmentLineItems(@Path("shipmentId") String shipmentId);

  @GET("shipments/{shipmentId}/shipment_line_items")
  Call<List<LineItem>> listShipmentShipmentLineItems(@Path("shipmentId") String shipmentId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("shipments/{shipmentId}/shipping_address")
  Call<List<Address>> retrieveShipmentShippingAddress(@Path("shipmentId") String shipmentId);

  @GET("shipments/{shipmentId}/shipping_address")
  Call<List<Address>> retrieveShipmentShippingAddress(@Path("shipmentId") String shipmentId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("shipments/{shipmentId}/shipping_category")
  Call<ShippingCategory> retrieveShipmentShippingCategory(@Path("shipmentId") String shipmentId);

  @GET("shipments/{shipmentId}/shipping_category")
  Call<ShippingCategory> retrieveShipmentShippingCategory(@Path("shipmentId") String shipmentId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("shipments/{shipmentId}/shipping_method")
  Call<ShippingMethod> retrieveShipmentShippingMethod(@Path("shipmentId") String shipmentId);

  @GET("shipments/{shipmentId}/shipping_method")
  Call<ShippingMethod> retrieveShipmentShippingMethod(@Path("shipmentId") String shipmentId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("shipments/{shipmentId}/stock_location")
  Call<StockLocation> retrieveShipmentStockLocation(@Path("shipmentId") String shipmentId);

  @GET("shipments/{shipmentId}/stock_location")
  Call<StockLocation> retrieveShipmentStockLocation(@Path("shipmentId") String shipmentId,
      @QueryMap Map<String, String> queryStringParams);
}
