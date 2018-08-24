package io.commercelayer.api.model.common.error;

import com.squareup.moshi.Json;

import io.commercelayer.api.model.common.ApiObject;

public class AuthError extends ApiObject {

	private String error;
	@Json(name = "error_description")
	private String errorDescription;
	private int httpErrorCode;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String toString() {
		return String.format("[error=%s, description=%s]", error, errorDescription);
	}

	public int getHttpErrorCode() {
		return httpErrorCode;
	}

	public void setHttpErrorCode(int httpErrorCode) {
		this.httpErrorCode = httpErrorCode;
	}

}
