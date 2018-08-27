package io.commercelayer.api.service.document;

import io.commercelayer.api.model.Parcel;
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

public interface ParcelService {
  @GET("/parcels")
  Call<Document> listParcels();

  @GET("/parcels")
  Call<Document> listParcels(@QueryMap Map<String, String> queryStringParams);

  @POST("/parcels")
  Call<Document> createParcel(@Body Parcel parcel);

  @GET("/parcels/{parcelId}")
  Call<Document> retrieveParcel(@Path("parcelId") String parcelId);

  @GET("/parcels/{parcelId}")
  Call<Document> retrieveParcel(@Path("parcelId") String parcelId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/parcels/{parcelId}")
  Call<Document> updateParcel(@Path("parcelId") String parcelId, @Body Parcel parcel);

  @DELETE("/parcels/{parcelId}")
  Call<Void> deleteParcel(@Path("parcelId") String parcelId);

  @GET("/parcels/{parcelId}/shipment")
  Call<Document> retrieveParcelShipment(@Path("parcelId") String parcelId);

  @GET("/parcels/{parcelId}/shipment")
  Call<Document> retrieveParcelShipment(@Path("parcelId") String parcelId,
      @QueryMap Map<String, String> queryStringParams);
}
