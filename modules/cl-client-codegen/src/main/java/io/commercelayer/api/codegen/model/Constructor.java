package io.commercelayer.api.codegen.model;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constructor extends AbstractModelObject {

	private List<Constructor.Param> signatureParams = new ArrayList<>();

	{
		super.linesBefore = 1;
		super.linesAfter = 1;
	}
	
	public Constructor() {
		super();
	}
	
	public Constructor(Integer modifier) {
		this();
		this.modifier = modifier;
	}

	public Constructor(String name, Integer modifier) {
		this();
		this.name = name;
		this.modifier = modifier;
	}

	public Constructor(String name, Integer modifier, Constructor.Param... signatureParams) {
		this(name, modifier);
		this.signatureParams = Arrays.asList(signatureParams);
	}

	public void setModifier(Integer modifier) {
		if ((Modifier.constructorModifiers() & modifier.intValue()) == 0)
			throw new IllegalArgumentException("Invalid constructor modifier: " + modifier);
		this.modifier = modifier;
	}

	public List<Constructor.Param> getSignatureParams() {
		return signatureParams;
	}

	public void setSignatureParams(List<Param> signatureParams) {
		this.signatureParams = signatureParams;
	}

	public void addSignatureParam(Constructor.Param param) {
		this.signatureParams.add(param);
	}



	public String generate() {

		StringBuilder sb = new StringBuilder();

		sb.append(Modifier.toString(getModifier())).append(' ').append(getName()).append('(');

		if (!getSignatureParams().isEmpty()) {
			int params = 0;
			for (Constructor.Param p : getSignatureParams()) {
				if (params > 0) sb.append(", ");
				sb.append(p.getType().getNameGen()).append(' ').append(p.getName());
				params++;
			}
		}
		sb.append(')');

		sb.append(" {").append(newLine());

		sb = generateBody(sb);
		
		sb.append('}').append(newLine());

		return sb.toString();

	}
	
	
	protected StringBuilder generateBody(StringBuilder sb) {
		
		sb.append("\tsuper(");
		if (!getSignatureParams().isEmpty()) {
			int i = 0;
			for (Constructor.Param p : getSignatureParams()) {
				if (!p.isParentParam()) continue;
				if (i++ > 0) sb.append(", ");
				sb.append(p.getName());
			}
		}
		sb.append(");").append(newLine());
		
		if (!getSignatureParams().isEmpty()) {
			for (Constructor.Param p : getSignatureParams()) {
				if (p.isParentParam()) continue;
				sb.append('\t').append("this.");
				sb.append(p.getName()).append(" = ").append(p.getName()).append(';');
				sb.append(newLine());
			}
		}
		
		return sb;
		
	}

	
	public static class Param extends Method.Param {

		private boolean parentParam;

		public Param(Type type, String name) {
			super(type, name);
		}
		
		public Param(Class<?> type, String name) {
			super(type, name);
		}

		public Param(Type type, String name, boolean parentParam) {
			this(type, name);
			this.parentParam = parentParam;
		}
		
		public Param(Class<?> type, String name, boolean parentParam) {
			this(new Type(type), name, parentParam);
		}

		public boolean isParentParam() {
			return parentParam;
		}

	}

}
