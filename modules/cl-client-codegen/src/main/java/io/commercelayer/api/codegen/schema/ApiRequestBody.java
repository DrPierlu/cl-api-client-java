package io.commercelayer.api.codegen.schema;

import java.util.ArrayList;
import java.util.List;

public class ApiRequestBody {

	private boolean required;
	private List<String> requiredFields;
	private List<ApiAttribute> attributes;
	private String type;
	private List<String> relationships;

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
		if (this.requiredFields == null)
			this.requiredFields = new ArrayList<String>();
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
		if (this.attributes == null) this.attributes = new ArrayList<ApiAttribute>();
		this.attributes.add(attribute);
	}

	public List<String> getRelationships() {
		return relationships;
	}

	public void setRelationships(List<String> relationships) {
		this.relationships = relationships;
	}
	
	public void addRelationship(String relationship) {
		if (this.relationships == null) this.relationships = new ArrayList<String>();
		this.relationships.add(relationship);
	}

}
