package io.commercelayer.api.client.exception;

import io.commercelayer.api.model.common.error.AuthError;

public class AuthException extends Exception {

	private static final long serialVersionUID = -2301969362813163445L;

	private AuthError authError;

	public AuthException(AuthError authError) {
		super(errorMessage(authError));
		this.authError = authError;
	}

	public AuthError getAuthError() {
		return authError;
	}

	private static String errorMessage(AuthError authError) {
		return (authError == null) ? "" : authError.toString();
	}

}
