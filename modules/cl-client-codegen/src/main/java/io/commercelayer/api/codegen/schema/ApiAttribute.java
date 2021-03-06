package io.commercelayer.api.codegen.schema;

public class ApiAttribute {

	private String name;
	private String type;
	private String format;
	private String description;
	private String example;
	private boolean required;

	public ApiAttribute(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	
	/**
	 * 
	 * TYPE AND FORMAT DEFINITIONS
	 *
	 */
	
	public static interface Types {
		String STRING 	= "string";
		String INTEGER 	= "integer";
		String NUMBER 	= "number";
		String BOOLEAN 	= "boolean";
	}

	public static interface Formats {
		String INT32 		= "int32";
		String INT64 		= "int64";
		String DATE_TIME 	= "date-time";
		String DATE 		= "date";
		String FLOAT 		= "float";
		String DOUBLE 		= "double";
		String BYTE 		= "byte";
		String BINARY 		= "binary";
		String PASSWORD 	= "password";
	}

}
