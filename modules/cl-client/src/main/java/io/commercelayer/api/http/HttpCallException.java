package io.commercelayer.api.http;

public final class HttpCallException extends RuntimeException {

	private static final long serialVersionUID = -8796967647553222979L;
	
	public HttpCallException(String message) {
		super(message);
	}
	
	public HttpCallException(String message, Object... params) {
		super(String.format(message, params));
	}
	
	public HttpCallException(Throwable cause) {
		super(cause);
	}
	
	public HttpCallException(String message, Throwable cause) {
		super(message, cause);
	}

}
