package io.commercelayer.api.codegen.schema;

import java.util.LinkedList;
import java.util.List;

public class ApiResponse {

	private int type;
	private String description;
	private List<ApiAttribute> attributes = new LinkedList<>();
	private List<ApiRelationship> relationships = new LinkedList<>();

	public ApiResponse(int type) {
		this.type = type;
	}

	public ApiResponse(int type, String description) {
		this(type);
		this.description = description;
	}

	public int getType() {
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
