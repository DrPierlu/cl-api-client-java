package io.commercelayer.api.codegen.schema.parser;

public class SpecInfo {

	private String name;
	private String version;

	public SpecInfo(String name, String version) {
		this.name = name;
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}
	
	public String toString() {
		return String.format("[%s, %s]", name, version);
	}

}