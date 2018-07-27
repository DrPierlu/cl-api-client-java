package io.commercelayer.api.codegen.schema;

import io.commercelayer.api.domain.ResponseType;

public class ApiResponse {

	private ResponseType type;
	private String description;

	public ApiResponse(ResponseType type) {
		this.type = type;
	}
	
	public ApiResponse(ResponseType type, String description) {
		this(type);
		this.description = description;
	}

	public ResponseType getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
