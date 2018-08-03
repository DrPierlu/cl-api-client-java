package io.commercelayer.api.codegen.schema;

public class ApiRelationship {

	private String resourceName;
	private Cardinality cardinality;

	public ApiRelationship(String resourceName, Cardinality cardinality) {
		this.resourceName = resourceName;
		this.cardinality = cardinality;
	}

	public String getResourceName() {
		return resourceName;
	}

	public Cardinality getCardinality() {
		return cardinality;
	}
	
	public enum Cardinality {
		HAS_ONE,
		HAS_MANY;
	}

}
