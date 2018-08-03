package io.commercelayer.api.codegen.model;

import java.util.LinkedList;
import java.util.List;

import com.squareup.javapoet.TypeSpec;

public class ApiModel {

	private String sourceDirectory;
	private List<TypeSpec> classes = new LinkedList<>();

	public List<TypeSpec> getClasses() {
		return classes;
	}

	public void setClasses(List<TypeSpec> classes) {
		this.classes = classes;
	}

	public void addClass(TypeSpec class_) {
		this.classes.add(class_);
	}

	public String getSourceDirectory() {
		return sourceDirectory;
	}

	public void setSourceDirectory(String sourceDirectory) {
		this.sourceDirectory = sourceDirectory;
	}

}
