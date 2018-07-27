package io.commercelayer.api.codegen.model;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Method extends AbstractModelObject {

	private Type returnType;
	private List<Param> signatureParams = new ArrayList<>();
	private List<String> body = new ArrayList<>();
	private List<Class<? extends Exception>> exceptionList = new ArrayList<>();

	{
		super.linesBefore = 1;
		super.linesAfter = 1;
	}

	public Method() {
		super();
	}

	public Method(Integer modifier) {
		this();
		this.modifier = modifier;
	}

	public void setModifier(Integer modifier) throws IllegalArgumentException {
		if ((Modifier.methodModifiers() & modifier.intValue()) == 0)
			throw new IllegalArgumentException("Invalid method modifier: " + modifier);
		this.modifier = modifier;
	}

	public Type getReturnType() {
		return returnType;
	}

	public void setReturnType(Type returnType) {
		this.returnType = returnType;
	}

	public void setReturnType(Class<?> returnType) {
		this.returnType = new Type(returnType);
	}

	public List<Param> getSignatureParams() {
		return signatureParams;
	}

	public void setSignatureParams(List<Param> signatureParams) {
		this.signatureParams = signatureParams;
	}

	public void setSignatureParams(Param... signatureParams) {
		this.signatureParams = Arrays.asList(signatureParams);
	}

	public void addSignatureParam(Param param) {
		this.signatureParams.add(param);
	}

	public List<String> getBody() {
		return body;
	}

	public void setBody(List<String> body) {
		this.body = body;
	}

	public void addBodyLine(String line) {
		this.body.add(line);
	}

	public void addBodyLine(String line, Object... params) {
		addBodyLine(String.format(line, params));
	}

	public List<Class<? extends Exception>> getExceptionList() {
		return exceptionList;
	}

	public void setExceptionList(List<Class<? extends Exception>> exceptionList) {
		if (exceptionList != null)
			this.exceptionList = exceptionList;
	}

	public void addException(Class<? extends Exception> e) {
		this.exceptionList.add(e);
	}

	public String generate() {

		StringBuilder sb = new StringBuilder();

		if (hasComment()) writeComment(sb);
		
		if (hasAnnotations()) writeAnnotations(sb);

		sb.append(Modifier.toString(getModifier())).append(' ');

		if (getReturnType() == null) sb.append(Void.TYPE.getSimpleName());
		else sb.append(getReturnType().getNameGen());
		
		sb.append(' ').append(getName()).append('(');

		if (!getSignatureParams().isEmpty()) {
			int params = 0;
			for (Param p : getSignatureParams()) {
				if (params > 0) sb.append(", ");
				sb.append(p.getType().getNameGen()).append(' ').append(p.getName());
				params++;
			}
		}
		sb.append(')');

		if (!getExceptionList().isEmpty()) {
			sb.append(" throws ");
			int items = 0;
			for (Class<? extends Exception> e : getExceptionList()) {
				if (items > 0) sb.append(", ");
				sb.append(e.getSimpleName());
				items++;
			}
		}

		sb.append(" {");
		
		final List<String> bodyLines = getBody();
		if (!bodyLines.isEmpty()) {
			sb.append(newLine());
			for (String l : bodyLines) {
				if (StringUtils.isNotEmpty(l)) sb.append('\t').append(l);
				sb.append(newLine());
			}
		}

		sb.append('}').append(newLine());

		return sb.toString();

	}

	public static class Param {

		private Type type;
		private String name;

		public Param(Field field) {
			this(field.getType(), field.getName());
			this.type = field.getType();
		}

		public Param(Type type, String name) {
			this.type = type;
			this.name = name;
		}

		public Param(Class<?> type, String name) {
			this.type = new Type(type);
			this.name = name;
		}

		public Type getType() {
			return type;
		}

		public String getName() {
			return name;
		}

	}

}
