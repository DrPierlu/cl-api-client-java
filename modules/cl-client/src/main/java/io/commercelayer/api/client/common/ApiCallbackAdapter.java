package io.commercelayer.api.client.common;

import java.io.IOException;

import io.commercelayer.api.client.exception.ConnectionException;
import io.commercelayer.api.model.common.error.ApiErrors;
import io.commercelayer.api.util.JSONUtils;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCallbackAdapter<T> implements Callback<T> {
	
	private ApiCallback<T> callback;
//	private Call<T> call;

	
	public ApiCallbackAdapter(ApiCallback<T> callback) {
		this.callback = callback;
	}
	
	@Override
	public void onResponse(Call<T> call, Response<T> response) {
		
//		this.call = call;
		
		Request request = call.request();
		
		if (response.isSuccessful()) callback.onSuccess(request, response.body());
		else {
			if (response.code() == 404) callback.onFailure(request, new ConnectionException(String.format("%d - %s", response.code(), response.message())));
			else
				try {
					callback.onError(request, JSONUtils.fromJSON(response.errorBody().string(), ApiErrors.class).getErrors());
				} catch (IOException ioe) {
					callback.onFailure(request, new ConnectionException(ioe.getMessage(), ioe));
				}
		}
	
	}
	
	@Override
	public void onFailure(Call<T> call, Throwable t) {
		
//		this.call = call;
		
		onFailure(call, new ConnectionException(t.getMessage(), t));
		
	}
	
//	public boolean isCallExecuted() {
//		return ((this.call != null) && this.call.isExecuted());
//	}
	
//	public boolean isCallCancelled() {
//		return ((this.call != null) && this.call.isCanceled());
//	}
	
//	public Request getCallRequest() {
//		return (this.call != null)? this.call.request() : null;
//	}
	
//	public Call<T> getOriginalCall() {
//		return this.call;
//	}

}
