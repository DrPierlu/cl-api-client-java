package io.commercelayer.api.model.common;

import io.commercelayer.api.util.LogUtils;

public abstract class ApiObject {
	
	@Override
	public String toString() {
		return LogUtils.toString(this);
	}
	
}
