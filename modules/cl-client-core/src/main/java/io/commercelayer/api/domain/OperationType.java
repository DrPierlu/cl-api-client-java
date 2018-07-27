package io.commercelayer.api.domain;

public enum OperationType {
	
	DELETE("DELETE"),
	GET("GET"),
	HEAD("HEAD"),
	PATCH("PATCH"),
	POST("POST"),
	PUT("PUT");
	
	private String code;
	
	private OperationType(String code) {
		this.code = code;
	}
	
	public String code() {
		return this.code;
	}
	
	public static OperationType byCode(String code) {
		for (OperationType ot : OperationType.values())
			if (ot.code.equalsIgnoreCase(code)) return ot;
		return null;
	}
	
	public static OperationType[] all() {
		return new OperationType[] {
			DELETE, GET, HEAD, PATCH, POST, PUT
		};
	}

}
