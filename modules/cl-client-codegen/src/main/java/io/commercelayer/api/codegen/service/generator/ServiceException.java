package io.commercelayer.api.codegen.service.generator;

import io.commercelayer.api.codegen.CodegenException;

public class ServiceException extends CodegenException {

	private static final long serialVersionUID = -8296307275069210296L;
	
	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(String message, Throwable t) {
		super(message, t);
	}

}
