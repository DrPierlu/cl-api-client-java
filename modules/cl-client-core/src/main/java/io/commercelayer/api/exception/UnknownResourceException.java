package io.commercelayer.api.exception;

import io.commercelayer.api.model.common.Unknown;

public class UnknownResourceException extends RuntimeException {

	private static final long serialVersionUID = -1728525269669249816L;
	
	private Unknown unknownResource;
	
	public UnknownResourceException(Unknown unknownResource) {
		this.unknownResource = unknownResource;
	}
	
	public String getMessage() {
		return String.format("Unable to convert resource type: %s. Add suitable Resource Adapter before call.", this.unknownResource);
	}

}
