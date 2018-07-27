package io.commercelayer.api.domain;

public enum ResponseType {

	HTTP_200("200");
	
	private String code;
	
	private ResponseType(String code) {
		this.code = code;
	}
	
	public String code() {
		return this.code;
	}
	
	public static ResponseType byCode(String code) {
		for (ResponseType rt : ResponseType.values())
			if (rt.code.equalsIgnoreCase(code)) return rt;
		return null;
	}
	
}
