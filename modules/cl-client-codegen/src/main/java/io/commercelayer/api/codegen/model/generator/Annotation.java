package io.commercelayer.api.codegen.model.generator;

import java.util.LinkedHashMap;
import java.util.Map;

public class Annotation {

	private Class<? extends java.lang.annotation.Annotation> annotation;
	private Map<String, String> attributes;

	public Annotation(Class<? extends java.lang.annotation.Annotation> annotation) {
		this.annotation = annotation;
	}
	
	public Class<? extends java.lang.annotation.Annotation> getAnnotation() {
		return annotation;
	}

	public void setAnnotation(Class<? extends java.lang.annotation.Annotation> annotation) {
		this.annotation = annotation;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	
	public void addAttribute(String name, String value) {
		if (this.attributes == null) this.attributes = new LinkedHashMap<>();
		this.attributes.put(name, value);
	}

}
