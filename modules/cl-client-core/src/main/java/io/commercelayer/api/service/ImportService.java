package io.commercelayer.api.service;

import io.commercelayer.api.model.Import;
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

public interface ImportService {
  @GET("imports")
  Call<List<Import>> listImports();

  @GET("imports")
  Call<List<Import>> listImports(@QueryMap Map<String, String> queryStringParams);

  @POST("imports")
  Call<Import> createImport(@Body Import import_);

  @POST("imports")
  Call<Import> createImport(@Body Import import_, @QueryMap Map<String, String> queryStringParams);

  @PATCH("imports/{importId}")
  Call<Import> updateImport(@Path("importId") String importId, @Body Import import_);

  @PATCH("imports/{importId}")
  Call<Import> updateImport(@Path("importId") String importId, @Body Import import_,
      @QueryMap Map<String, String> queryStringParams);

  @GET("imports/{importId}")
  Call<Import> retrieveImport(@Path("importId") String importId);

  @GET("imports/{importId}")
  Call<Import> retrieveImport(@Path("importId") String importId,
      @QueryMap Map<String, String> queryStringParams);

  @DELETE("imports/{importId}")
  Call<Void> deleteImport(@Path("importId") String importId);
}
