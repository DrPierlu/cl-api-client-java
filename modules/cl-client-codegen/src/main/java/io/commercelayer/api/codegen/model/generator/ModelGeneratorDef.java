package io.commercelayer.api.codegen.model.generator;

public enum ModelGeneratorDef {
	
	JsonApi_Converter("JsonApi-Converter"),
	Moshi_JsonApi("Moshi-JsonApi");
	
	private String id;
	
	private ModelGeneratorDef(String id) {
		this.id = id;
	}
	
	public String id() {
		return this.id;
	}
	
}
