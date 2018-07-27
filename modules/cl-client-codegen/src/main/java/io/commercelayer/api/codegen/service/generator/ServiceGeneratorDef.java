package io.commercelayer.api.codegen.service.generator;

public enum ServiceGeneratorDef {
	
	Retrofit("Retrofit");
	
	private String id;
	
	private ServiceGeneratorDef(String id) {
		this.id = id;
	}
	
	public String id() {
		return this.id;
	}

}
