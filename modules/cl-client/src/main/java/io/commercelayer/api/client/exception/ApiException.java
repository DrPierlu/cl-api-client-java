package io.commercelayer.api.client.exception;

import io.commercelayer.api.model.common.error.ApiError;

public class ApiException extends Exception {

	private static final long serialVersionUID = -7947726126234188811L;
	
	private ApiError apiError;
	
	public ApiException(ApiError apiError) {
		super(errorMessage(apiError));
		this.apiError = apiError;
	}

	public ApiError getApiError() {
		return apiError;
	}
	
	private static String errorMessage(ApiError apiError) {
		return (apiError == null)? "" : apiError.toString();
	}

}
