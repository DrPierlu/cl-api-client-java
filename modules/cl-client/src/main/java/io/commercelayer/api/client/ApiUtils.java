package io.commercelayer.api.client;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.ConnectionException;
import io.commercelayer.api.model.common.error.ApiError;
import io.commercelayer.api.model.common.error.ApiErrors;
import io.commercelayer.api.util.JSONUtils;
import moe.banana.jsonapi2.Resource;
import retrofit2.Response;

public class ApiUtils {

	private static final Logger logger = LoggerFactory.getLogger(ApiUtils.class);

	private ApiUtils() {

	}

	public static <T extends Resource> T readServiceResponse(Response<T> response) throws ConnectionException, ApiException {
		
		if (response.isSuccessful()) return response.body();
		else {
			if (response.code() == 404) throw new ConnectionException(response.message());
			else throw new ApiException(getErrors(response));
		}
		
	}
	
	public static List<ApiError> getErrors(Response<? extends Resource> response) {
		
		if ((response == null) || response.isSuccessful() || response.errorBody() == null) return null;
		else
			try {
				ApiErrors apiErrors = JSONUtils.fromJSON(response.errorBody().string(), ApiErrors.class);
				return apiErrors.getErrors();
			} catch (IOException ioe) {
				logger.error(ioe.getMessage());
				return null;
			}

	}

}
