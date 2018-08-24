package io.commercelayer.api.model.common;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.commercelayer.api.util.LogUtils;

public abstract class ApiObject {
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, LogUtils.TO_STRING_STYLE);
	}
	
}
