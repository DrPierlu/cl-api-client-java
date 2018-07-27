package io.commercelayer.api.codegen.model;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import io.commercelayer.api.domain.OperationType;

public class Field extends AbstractModelObject implements Comparable<Field> {

	private Type type;
	private String initialization;
	private Integer aligmentTabs = 0;
	
	private Map<OperationType, Boolean> includedIn;
	private Map<OperationType, Boolean> requiredFor;


	public Field() {
		super();
	}


	public Field(Integer modifier) {
		this();
		setModifier(modifier);
	}


	public Field(Integer modifier, Type type, String name) {
		this(modifier);
		this.type = type;
		this.name = name;
	}


	public Field(Integer modifier, Class<?> type, String name) {
		this(modifier, new Type(type), name);
	}


	public void setModifier(Integer modifier) throws IllegalArgumentException {
		if ((Modifier.fieldModifiers() & modifier.intValue()) == 0) throw new IllegalArgumentException("Invalid field modifier: " + modifier);
		this.modifier = modifier;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	public String getInitialization() {
		return initialization;
	}


	public void setInitialization(String initialization) {
		this.initialization = initialization;
	}


	public Integer getAligmentTabs() {
		return aligmentTabs;
	}


	public void setAligmentTabs(Integer aligmentTabs) {
		this.aligmentTabs = aligmentTabs;
	}


	public String generate() {

		StringBuilder sb = new StringBuilder();

		if (hasAnnotations()) writeAnnotations(sb);

		sb.append(Modifier.toString(modifier)).append(' ');
		sb.append(getType().getNameGen()).append(' ').append(getName());

		if (this.initialization != null) {
			if (this.aligmentTabs != null) {
				int tabs = (this.aligmentTabs - (this.name.length()/4));
				if ((this.name.length() % 4) == 0) tabs++;
				for (int i = 0; i < tabs; i++) sb.append('\t');
			}
			sb.append(" = ").append(this.initialization);
		}

		sb.append(';');

		return sb.toString();

	}


	public static void main(String[] args) {

		Field f = new Field(Modifier.PRIVATE, new Type(String.class), "shippingMethod");

		String code = f.generate();

		System.out.println(code);

	}


	@Override
	public int compareTo(Field o) {
		if (getAnnotationList().isEmpty() && !o.getAnnotationList().isEmpty()) return -1;
		else
			if (!getAnnotationList().isEmpty() && o.getAnnotationList().isEmpty()) return 1;
			else
				return getName().compareTo(o.getName());
	}
	
	public void setRequiredFor(OperationType op, boolean required) {
		if (this.requiredFor == null) this.requiredFor = new HashMap<>();
		this.requiredFor.put(op, Boolean.valueOf(required));
	}
	
	public void setIncludedIn(OperationType op, boolean included) {
		if (this.includedIn == null) this.includedIn = new HashMap<>();
		this.includedIn.put(op, Boolean.valueOf(included));
	}
	
	public boolean isRequiredFor(OperationType op) {
		Boolean b = this.requiredFor.get(op);
		return (b != null) && b;
	}
	
	public boolean isIncludedIn(OperationType op) {
		Boolean b = this.includedIn.get(op);
		return (b != null) && b;
	}

}
