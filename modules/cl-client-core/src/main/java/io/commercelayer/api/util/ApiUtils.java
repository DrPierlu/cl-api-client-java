package io.commercelayer.api.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.commercelayer.api.model.common.error.ApiError;
import moe.banana.jsonapi2.Resource;
import retrofit2.Response;

public class ApiUtils {

	private static final Logger logger = LoggerFactory.getLogger(ApiUtils.class);

	private ApiUtils() {

	}

	public static ApiError getError(Response<? extends Resource> response) {
		
		// Moshi-JsonApi implementation: see Commerce Layer API Reference (HAndling Errors)
		return null;
		
//		if ((response == null) || response.isSuccessful() || (response.errorBody() == null))
//			return null;
//		else
//			try {
//				ApiError apiError = JSONUtils.fromJSON(String.valueOf(response.errorBody().bytes()), ApiError.class);
//				apiError.setHttpErrorCode(response.code());
//				return apiError;
//			} catch (IOException ioe) {
//				logger.error(ioe.getMessage());
//				return null;
//			}

	}

}
