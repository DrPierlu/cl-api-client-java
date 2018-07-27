package io.commercelayer.api.exception;

public final class ConnectionException extends RuntimeException {

	private static final long serialVersionUID = -8796967647553222979L;
	
	public ConnectionException(String message) {
		super(message);
	}
	
	public ConnectionException(String message, Object... params) {
		super(String.format(message, params));
	}
	
	public ConnectionException(Throwable cause) {
		super(cause);
	}
	
	public ConnectionException(String message, Throwable cause) {
		super(message, cause);
	}

}
