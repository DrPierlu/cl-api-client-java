package io.commercelayer.api.codegen.source;

public enum SourceWriterDef {
	
	JPoet("JPoet");
	
	private String id;
	
	private SourceWriterDef(String id) {
		this.id = id;
	}
	
	public String id() {
		return this.id;
	}

}
