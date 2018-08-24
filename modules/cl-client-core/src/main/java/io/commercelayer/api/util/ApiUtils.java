package io.commercelayer.api.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.commercelayer.api.model.common.error.ApiError;
import retrofit2.Response;

public class ApiUtils {

	private static final Logger logger = LoggerFactory.getLogger(ApiUtils.class);

	private ApiUtils() {

	}

	public static ApiError getError(Response<?> response) {
		
		if ((response == null) || response.isSuccessful() || (response.errorBody() == null))
			return null;
		else
			try {
				ApiError apiError = JSONUtils.fromJSON(String.valueOf(response.errorBody().bytes()), ApiError.class);
				return apiError;
			} catch (IOException ioe) {
				logger.error(ioe.getMessage());
				return null;
			}

	}

}
