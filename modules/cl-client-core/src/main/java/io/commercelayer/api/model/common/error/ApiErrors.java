package io.commercelayer.api.model.common.error;

import java.util.List;

import io.commercelayer.api.model.common.ApiObject;

public class ApiErrors extends ApiObject {
	
	private List<ApiError> errors;

	public List<ApiError> getErrors() {
		return errors;
	}

	public void setErrors(List<ApiError> errors) {
		this.errors = errors;
	}

}
