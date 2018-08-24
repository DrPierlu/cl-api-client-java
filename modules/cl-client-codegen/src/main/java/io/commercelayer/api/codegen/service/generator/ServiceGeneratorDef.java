package io.commercelayer.api.codegen.service.generator;

public enum ServiceGeneratorDef {
	
	Retrofit_Resource("Retrofit-Resource"),	// Moshi-JsonApi->JPoet with Retrofit Resource return type
	Retrofit_Document("Retrofit-Document");	// Moshi-JsonApi->JPoet with Retrofit Document return type
	
	private String id;
	
	private ServiceGeneratorDef(String id) {
		this.id = id;
	}
	
	public String id() {
		return this.id;
	}

}
