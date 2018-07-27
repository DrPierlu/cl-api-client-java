package io.commercelayer.api.exception;

public class CallException extends RuntimeException {

	private static final long serialVersionUID = -8116563621517735725L;
	
	public CallException(String message) {
		super(message);
	}
	
	public CallException(String message, Object... params) {
		this(String.format(message, params));
	}

}
