package io.commercelayer.api.client;

import java.io.IOException;
import java.util.List;

import io.commercelayer.api.client.exception.ConnectionException;
import io.commercelayer.api.model.common.error.ApiError;
import io.commercelayer.api.model.common.error.ApiErrors;
import io.commercelayer.api.util.JSONUtils;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class CLApiCallback<T> implements Callback<T> {
	
	private Call<T> call;

	public abstract void onSuccess(Request request, T response);
	
	public abstract void onError(Request request, List<ApiError> errors);
	
	public abstract void onFailure(Request request, ConnectionException ce);
	
	@Override
	public void onResponse(Call<T> call, Response<T> response) {
		
		this.call = call;
		
		Request request = call.request();
		
		if (response.isSuccessful()) onSuccess(request, response.body());
		else {
			if (response.code() == 404) onFailure(request, new ConnectionException(String.format("%d - %s", response.code(), response.message())));
			else
				try {
					onError(request, JSONUtils.fromJSON(response.errorBody().string(), ApiErrors.class).getErrors());
				} catch (IOException ioe) {
					onFailure(request, new ConnectionException(ioe.getMessage(), ioe));
				}
		}
	
	}
	
	@Override
	public void onFailure(Call<T> call, Throwable t) {
		
		this.call = call;
		
		onFailure(call, new ConnectionException(t.getMessage(), t));
		
	}
	
	public boolean isCallExecuted() {
		return ((this.call != null) && this.call.isExecuted());
	}
	
	public boolean isCallCancelled() {
		return ((this.call != null) && this.call.isCanceled());
	}
	
	public Request getCallRequest() {
		return (this.call != null)? this.call.request() : null;
	}
	
//	public Call<T> getOriginalCall() {
//		return this.call;
//	}

}
