package io.commercelayer.api.codegen.schema;

public class ApiParameter {

	private String name;
	private String in;
	private String type;
	private String format;
	private String description;
	private boolean required;
	private boolean deprecated;

	public ApiParameter(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getIn() {
		return in;
	}

	public void setIn(String in) {
		this.in = in;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public boolean isDeprecated() {
		return deprecated;
	}

	public void setDeprecated(boolean deprecated) {
		this.deprecated = deprecated;
	}
	
}
