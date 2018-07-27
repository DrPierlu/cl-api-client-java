package io.commercelayer.api.codegen.model.generator;

import io.commercelayer.api.codegen.CodegenException;

public class ModelException extends CodegenException {

	private static final long serialVersionUID = 618309360204155907L;

	public ModelException(String message) {
		super(message);
	}
	
	public ModelException(String message, Throwable t) {
		super(message, t);
	}
	
}
