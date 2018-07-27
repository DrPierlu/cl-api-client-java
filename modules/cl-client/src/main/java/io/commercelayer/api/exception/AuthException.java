package io.commercelayer.api.exception;

import io.commercelayer.api.model.common.ApiError;

public class AuthException extends ApiException {

	private static final long serialVersionUID = -2301969362813163445L;
	
	public AuthException(ApiError apiError) {
		super(apiError);
	}

}
