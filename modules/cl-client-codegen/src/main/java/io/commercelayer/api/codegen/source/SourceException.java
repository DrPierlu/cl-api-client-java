package io.commercelayer.api.codegen.source;

import io.commercelayer.api.codegen.CodegenException;

public class SourceException extends CodegenException {

	private static final long serialVersionUID = -1521436395444488376L;

	public SourceException(String message) {
		super(message);
	}
	
	public SourceException(String message, Throwable t) {
		super(message, t);
	}
	
	public SourceException(Throwable t) {
		super(t);
	}
	
}
