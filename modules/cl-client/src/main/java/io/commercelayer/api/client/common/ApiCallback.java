package io.commercelayer.api.client.common;

import java.util.List;

import io.commercelayer.api.client.exception.ConnectionException;
import io.commercelayer.api.model.common.error.ApiError;
import okhttp3.Request;

public interface ApiCallback<T> {

	public abstract void onSuccess(Request request, T response);
	
	public abstract void onError(Request request, List<ApiError> errors);
	
	public abstract void onFailure(Request request, ConnectionException ce);
	
}
