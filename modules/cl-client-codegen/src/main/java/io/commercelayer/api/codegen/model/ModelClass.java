package io.commercelayer.api.codegen.model;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import io.commercelayer.api.codegen.CodegenConfig;
import io.commercelayer.api.codegen.model.Method.Param;
import io.commercelayer.api.codegen.model.generator.Annotation;

public class ModelClass extends AbstractModelObject {

	private String classPackage;

	private List<Type> importList = new ArrayList<>();
	private Type extendedClass;
	private List<Class<?>> implementList = new ArrayList<>();
	private List<Method> methodList = new ArrayList<>();
	private List<Field> fieldList = new ArrayList<>();
	private List<Class<? extends Exception>> exceptionList = new ArrayList<>();
	private List<Constructor> constructorList = new ArrayList<>();
	private String initBlock;
	
	{
		super.linesBefore = 1;
		super.linesAfter = 1;
	}

	public ModelClass() {
		super();
	}

	public ModelClass(String classPackage, String className) {
		this();
		this.classPackage = classPackage;
		this.name = className;
	}

	public ModelClass(String classPackage, String className, Integer modifier) {
		this(classPackage, className);
		setModifier(modifier);
	}

	public String getClassPackage() {
		return classPackage;
	}

	public void setClassPackage(String classPackage) {
		this.classPackage = classPackage;
	}

	public void setModifier(Integer modifier) throws IllegalArgumentException {
		if ((Modifier.classModifiers() & modifier.intValue()) == 0)
			throw new IllegalArgumentException("Invalid class modifier: " + modifier);
		this.modifier = modifier;
	}

	public List<Type> getImportList() {
		return importList;
	}

	public Type getExtendedClass() {
		return extendedClass;
	}

	public void setExtendedClass(Class<?> extendedClass) throws IllegalArgumentException {
		setExtendedClass(new Type(extendedClass));
	}
	
	public void setExtendedClass(Type extendedClass) throws IllegalArgumentException {
		if ((extendedClass.getTypeClass() != null) && extendedClass.getTypeClass().isInterface())
			throw new IllegalArgumentException("Not valid class [" + extendedClass.getName() + "]");
		this.extendedClass = extendedClass;
	}

	public List<Class<?>> getImplementList() {
		return implementList;
	}

	public void setImplementList(List<Class<?>> implementList) throws IllegalArgumentException {
		if (implementList != null)
			for (Class<?> c : implementList)
				addImplementedInterface(c);
	}

	public void addImplementedInterface(Class<?> intf) throws IllegalArgumentException {
		if (!intf.isInterface())
			throw new IllegalArgumentException("Not valid interface [" + intf.getName() + "]");
		this.implementList.add(intf);
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

	public List<Method> getMethodList() {
		return methodList;
	}

	public List<Field> getFieldList() {
		return fieldList;
	}
	
	public Field getField(String fieldName) {
		for (Field f : getFieldList())
			if (f.getName().equals(f.getName())) return f;
		return null;
	}

	public void addMethod(Method method) {
		this.methodList.add(method);
	}

	public List<Constructor> getConstructorList() {
		return constructorList;
	}

	public void addConstructor(Constructor constructor) {
		this.constructorList.add(constructor);
	}

	public boolean addField(Field field) {
		if ((getExtendedClass() != null) && (getExtendedClass().getTypeClass() != null))
			try {
				if (getExtendedClass().getTypeClass().getDeclaredField(field.getName()) != null)
					return false;
			} catch (NoSuchFieldException | SecurityException e) {

			}
		this.fieldList.add(field);
		return true;
	}

	public boolean addField(Field field, boolean setter, boolean getter) {
		return addField(field, setter, getter, false);
	}
	
	public boolean addField(Field field, boolean setter, boolean getter, boolean newStyle) {

		if (!addField(field))
			return false;

		if (setter) {
			Method m = new Method(Modifier.PUBLIC);
			m.setName("set".concat(StringUtils.capitalize(field.getName())));
			m.addSignatureParam(new Param(field));
			m.addBodyLine("this.%1$s = %1$s;", field.getName());
			addMethod(m);
		}

		if (getter) {
			Method m = new Method(Modifier.PUBLIC);
			m.setName("get".concat(StringUtils.capitalize(field.getName())));
			m.setReturnType(field.getType());
			m.addBodyLine("return this.%s;", field.getName());
			addMethod(m);
		}
		
		if (newStyle) {
			if (setter) {
				Method m = new Method(Modifier.PUBLIC);
				m.setName(field.getName());
				m.setReturnType(new Type(getName()));
				m.addSignatureParam(new Param(field));
				m.addBodyLine("set%s(%s);", StringUtils.capitalize(field.getName()), field.getName());
				m.addBodyLine("return this;");
				addMethod(m);
			}
			if (getter) {
				Method m = new Method(Modifier.PUBLIC);
				m.setName(field.getName());
				m.setReturnType(field.getType());
				m.addBodyLine("return get%s();", StringUtils.capitalize(field.getName()));
				addMethod(m);
			}
		}

		return true;

	}

	public String getInitBlock() {
		return initBlock;
	}

	public void setInitBlock(String initBlock) {
		this.initBlock = initBlock;
	}

	private List<Type> createImportList() {

		if (this.importList == null) this.importList = new ArrayList<>();

		// Extended class
		addImportItem(getExtendedClass());

		// Implemented interfaces
		for (Class<?> c : getImplementList())
			addImportItem(c);

		// Annotations
		for (Annotation a : getAnnotationList())
			addImportItem(a.getAnnotation());

		// Fields
		for (Field f : getFieldList()) {
			addImportItem(f.getType());
			for (Annotation a : f.getAnnotationList())
				addImportItem(a.getAnnotation());
		}

		// Constructors
		for (Constructor c : getConstructorList()) {
			for (Param p : c.getSignatureParams())
				addImportItem(p.getType());
			if (c instanceof CustomConstructor) {
				for (Class<? extends Exception> e : ((CustomConstructor) c).getExceptionList())
					addImportItem(e);
			}
		}

		// Methods
		for (Method m : getMethodList()) {
			addImportItem(m.getReturnType());
			for (Param p : m.getSignatureParams())
				addImportItem(p.getType());
			for (Class<? extends Exception> e : m.getExceptionList())
				addImportItem(e);
			for (Annotation a : m.getAnnotationList())
				addImportItem(a.getAnnotation());
		}
		
		
		return this.importList;

	}
	
	
	public void addImportItem(Type type) {
		if (type == null) return;
		else {
			if ((type.getTypeClass() != null) && (type.getTypeClass().isPrimitive())) return;
			String pkg = type.getPackage();
			if ((pkg == null) || (pkg.startsWith("java.lang"))) return;
			if (!this.importList.contains(type) && !this.importList.contains(new Type(type.getPackage().concat(".*")))) this.importList.add(type);
		}
		
	}
	
	public void addImportItem(Class<?> class_) {
		addImportItem(new Type(class_));
	}
	
	public void addImportItem(String class_) {
		addImportItem(new Type(class_));
	}

	public String generate() {

		createImportList();

		StringBuilder sb = new StringBuilder();

		// Package
		sb.append("package ").append(getClassPackage()).append(';').append(newLine());
		
		
		// Imports
		final List<Type> importList = getImportList();
		if (!importList.isEmpty()) {
			Collections.sort(importList);
			sb.append(newLine());
			for (Type t : importList) {
				String imp = t.getImport().replaceAll("\\$", ".");
				sb.append("import ").append(imp).append(';').append(newLine());
			}
			sb.append(newLine());
		}

		// Class
		sb.append(newLines(getLinesBefore()));
		if (hasComment()) writeComment(sb);
		
		if (hasAnnotations()) writeAnnotations(sb);
		
		sb.append(Modifier.toString(getModifier())).append(" class ").append(getName());
		if (getExtendedClass() != null)
			sb.append(" extends ").append(getExtendedClass().getNameGen());

		if (!getImplementList().isEmpty()) {
			sb.append(" implements ");
			int i = 0;
			for (Class<?> c : getImplementList()) {
				if (i > 0) sb.append(", ");
				sb.append(c.getSimpleName());
			}
		}

		if (!getExceptionList().isEmpty()) {
			sb.append(' ');
			int i = 0;
			for (Class<? extends Exception> e : getExceptionList()) {
				if (i > 0) sb.append(", ");
				sb.append(e.getSimpleName());
			}
		}

		sb.append(" {").append(newLine());

		// serialVersionUID
		sb.append(serialVersionUID(CodegenConfig.getProperty("model.object.serialVersionUID")));

		// Fields
		final List<Field> fieldList = getFieldList();
		if (!fieldList.isEmpty()) {
			Collections.sort(fieldList);
			if (fieldList.get(0).getLinesBefore() < 1) sb.append(newLine());
			for (Field f : getFieldList()) {
				sb.append(newLines(f.getLinesBefore()));
				sb.append('\t').append(f.generate().replaceAll("\n", "\n\t")).append(newLine());
				sb.append(newLines(f.getLinesAfter()));
			}
			if (fieldList.get(fieldList.size()-1).getLinesAfter() < 1) sb.append(newLine());
		}
		
		// Init Block
		if (getInitBlock() != null) {
			sb.append(newLine());
			sb.append('\t').append('{').append(newLine());
			sb.append('\t').append('\t').append(getInitBlock().replaceAll("\n", "\n\t\t")).append(newLine());
			sb.append('\t').append('}').append(newLine());
			sb.append(newLine());
		}

		// Constructors
		final List<Constructor> constructorList = getConstructorList();
		if (!constructorList.isEmpty()) {
			if (constructorList.get(0).getLinesBefore() < 1) sb.append(newLine());
			for (Constructor c : constructorList) {
				sb.append(newLines(c.getLinesBefore()));
				if (c.getName() == null) c.setName(getName());
				sb.append('\t').append(c.generate().replaceAll("\n", "\n\t"));
				sb.append(newLines(c.getLinesAfter()));
			}
			if (constructorList.get(constructorList.size()-1).getLinesAfter() < 1) sb.append(newLine());
		}

		// Methods
		final List<Method> methodList = getMethodList();
		if (!methodList.isEmpty()) {
			if (methodList.get(0).getLinesBefore() < 1) sb.append(newLine());
			for (Method m : methodList) {
				sb.append(newLines(m.getLinesBefore()));
				sb.append('\t').append(m.generate().replaceAll("\n", "\n\t"));
				sb.append(newLines(m.getLinesAfter()));
			}
			if (methodList.get(methodList.size()-1).getLinesAfter() < 1) sb.append(newLine());
		}

		sb.append('}');
		
		sb.append(newLines(getLinesAfter()));

		return sb.toString();

	}

	private String serialVersionUID() {
		return serialVersionUID((Long)null);
	}
	
	private String serialVersionUID(String uid) {
		if (StringUtils.isBlank(uid)) return serialVersionUID();
		else 
			try {
				return serialVersionUID(Long.valueOf(uid));
			}
			catch (NumberFormatException nfe) {
				return serialVersionUID();
			}
	}
	
	private String serialVersionUID(Long uid) {

		String sv = "";

		boolean serializable = (
			(getExtendedClass() != null) 
			&& (getExtendedClass().getTypeClass() != null) 
			&& Serializable.class.isAssignableFrom(getExtendedClass().getTypeClass())
		);

		if (!serializable)
			for (Class<?> c : getImplementList()) {
				if (c instanceof Serializable) {
					serializable = true;
					break;
				}
			}

		if (serializable)
			sv = String.format("\n\tprivate static final long serialVersionUID = %dL;\n\n", (uid != null)? uid : System.currentTimeMillis());

		return sv;

	}

	public boolean equals(Object o) {
		if (!(o instanceof ModelClass))
			return false;
		ModelClass mc = (ModelClass) o;
		return (mc.getClassPackage().equals(this.getClassPackage()) && mc.getName().equals(this.getName()));
	}

}
