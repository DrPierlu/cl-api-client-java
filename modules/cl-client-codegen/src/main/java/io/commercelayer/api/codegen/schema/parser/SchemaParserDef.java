package io.commercelayer.api.codegen.schema.parser;

public enum SchemaParserDef {

	OpenAPI_V3("OpenAPI", "3");
	
	private String id;
	private String version;
	
	private SchemaParserDef(String id, String version) {
		this.id = id;
		this.version = version;
	}
	
	public SpecInfo specInfo() {
		return new SpecInfo(id, version);
	}
	
	public String id() {
		return specInfo().getName();
	}
	
}
