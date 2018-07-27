package io.commercelayer.api.http;

public class HttpResponse extends HttpMessage {

	private static final long serialVersionUID = 8738676375849275288L;
	
	
	private int code;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
	public boolean hasErrorCode() {
		return (code >= 300);
	}

}
