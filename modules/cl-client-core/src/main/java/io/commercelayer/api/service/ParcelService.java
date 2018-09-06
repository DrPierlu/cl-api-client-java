package io.commercelayer.api.service;

import io.commercelayer.api.model.Parcel;
import io.commercelayer.api.model.Shipment;
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

public interface ParcelService {
  @POST("parcels")
  Call<Parcel> createParcel(@Body Parcel parcel);

  @GET("parcels")
  Call<List<Parcel>> listParcels();

  @GET("parcels")
  Call<List<Parcel>> listParcels(@QueryMap Map<String, String> queryStringParams);

  @DELETE("parcels/{parcelId}")
  Call<Void> deleteParcel(@Path("parcelId") String parcelId);

  @PATCH("parcels/{parcelId}")
  Call<Parcel> updateParcel(@Path("parcelId") String parcelId, @Body Parcel parcel);

  @GET("parcels/{parcelId}")
  Call<Parcel> retrieveParcel(@Path("parcelId") String parcelId);

  @GET("parcels/{parcelId}")
  Call<Parcel> retrieveParcel(@Path("parcelId") String parcelId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("parcels/{parcelId}/shipment")
  Call<Shipment> retrieveParcelShipment(@Path("parcelId") String parcelId);

  @GET("parcels/{parcelId}/shipment")
  Call<Shipment> retrieveParcelShipment(@Path("parcelId") String parcelId,
      @QueryMap Map<String, String> queryStringParams);
}
