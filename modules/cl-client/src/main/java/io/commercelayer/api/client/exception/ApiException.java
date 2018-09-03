package io.commercelayer.api.client.exception;

import java.util.LinkedList;
import java.util.List;

import io.commercelayer.api.model.common.error.ApiError;

public class ApiException extends Exception {

	private static final long serialVersionUID = -7947726126234188811L;
	
	private List<ApiError> errors = new LinkedList<>();
	
	public ApiException(ApiError apiError) {
		super(errorMessage(apiError));
		this.errors.add(apiError);
	}
	
	public ApiException(ApiError apiError, Throwable t) {
		super(errorMessage(apiError), t);
		this.errors.add(apiError);
	}
	
	public ApiException(List<ApiError> errors) {
		super(errorMessage(errors));
		this.errors = errors;
	}
	
	public ApiException(List<ApiError> errors, Throwable t) {
		super(errorMessage(errors), t);
		this.errors = errors;
	}

	public List<ApiError> getApiErrors() {
		return this.errors;
	}
	
	public boolean hasErrors() {
		return !this.errors.isEmpty();
	}
	
	private static String errorMessage(ApiError apiError) {
		return (apiError == null)? null : String.format("%s: %s", apiError.getCode(), apiError.getDetail());
	}
	
	private static String errorMessage(List<ApiError> errors) {
		if ((errors == null) || errors.isEmpty()) return null;
		else
		if (errors.size() == 1) return errorMessage(errors.get(0));
		else return String.format("API Service retirned %s errors, access error list for details", errors.size());
	}
	
	public boolean hasErrorMessage() {
		return ((this.errors != null) && !this.errors.isEmpty());
	}

}
