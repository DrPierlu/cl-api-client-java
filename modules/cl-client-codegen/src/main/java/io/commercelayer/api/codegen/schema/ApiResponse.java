package io.commercelayer.api.codegen.schema;

import java.util.LinkedList;
import java.util.List;

import io.commercelayer.api.domain.ResponseType;

public class ApiResponse {

	private ResponseType type;
	private String description;
	private List<ApiAttribute> attributes = new LinkedList<>();
	private List<ApiRelationship> relationships = new LinkedList<>();

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

	public List<ApiAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<ApiAttribute> attributes) {
		this.attributes = attributes;
	}

	public void addAttribute(ApiAttribute attribute) {
		this.attributes.add(attribute);
	}
	
	public List<ApiRelationship> getRelationships() {
		return relationships;
	}

	public void setRelationships(List<ApiRelationship> relationships) {
		this.relationships = relationships;
	}
	
	public void addRelationship(ApiRelationship relationship) {
		this.relationships.add(relationship);
	}

}
