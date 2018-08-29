package io.commercelayer.api.client.exception;

public class ConnectionException extends RuntimeException {

	private static final long serialVersionUID = -3428987300587175023L;
	
	public ConnectionException(String message) {
		super(message);
	}
	
	
	public ConnectionException(String message, Throwable t) {
		super(message, t);
	}

}
