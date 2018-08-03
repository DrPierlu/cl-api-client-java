package io.commercelayer.api.codegen.schema;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ApiRequestBody {

	private boolean required;
	private List<String> requiredFields = new ArrayList<>();
	private List<ApiAttribute> attributes = new LinkedList<>();
	private String type;
	private List<ApiRelationship> relationships = new LinkedList<>();

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public List<String> getRequiredFields() {
		return requiredFields;
	}

	public void setRequiredFields(List<String> requiredFields) {
		this.requiredFields = requiredFields;
	}

	public void addRequiredField(String field) {
		this.requiredFields.add(field);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
