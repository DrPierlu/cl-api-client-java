package io.commercelayer.api.codegen.schema.parser;

import io.commercelayer.api.codegen.CodegenException;

public class SchemaException extends CodegenException {
	
	private SpecInfo specInfo;

	private static final long serialVersionUID = 533409072616926370L;
	
	public SchemaException(String message) {
		super(message);
	}
	
	public SchemaException(String message, Throwable t) {
		super(message, t);
	}
	
	public SchemaException (String message, SpecInfo specInfo) {
		this(message);
		this.specInfo = specInfo;
	}
	
	public SchemaException(String message, Throwable t, SpecInfo specInfo) {
		this(message, t);
		this.specInfo = specInfo;
	}
	
	public SpecInfo getSpecInfo() {
		return this.specInfo;
	}

}
