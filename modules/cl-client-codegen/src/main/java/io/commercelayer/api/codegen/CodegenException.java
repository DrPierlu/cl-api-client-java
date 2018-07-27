package io.commercelayer.api.codegen;

public class CodegenException extends Exception {

	private static final long serialVersionUID = -1753508534913566625L;
	
	public CodegenException(String message) {
		super(message);
	}
	
	public CodegenException(String message, Throwable t) {
		super(message, t);
	}
	
	public CodegenException(Throwable t) {
		super(t);
	}

}
