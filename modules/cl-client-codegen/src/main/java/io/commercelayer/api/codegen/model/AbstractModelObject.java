package io.commercelayer.api.codegen.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.commercelayer.api.codegen.model.generator.Annotation;

public abstract class AbstractModelObject {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected String name;
	protected Integer modifier;
	protected List<String> commentLines = new ArrayList<>();
	protected int linesBefore = 0;
	protected int linesAfter = 0;
	protected List<Annotation> annotationList = new ArrayList<>();

	public abstract String generate();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getModifier() {
		return modifier;
	}

	public void setModifier(Integer modifier) {
		this.modifier = modifier;
	}

	public final int getLinesBefore() {
		return linesBefore;
	}

	public void setLinesBefore(int linesBefore) {
		this.linesBefore = linesBefore;
	}

	public final int getLinesAfter() {
		return linesAfter;
	}

	public void setLinesAfter(int linesAfter) {
		this.linesAfter = linesAfter;
	}

	public List<String> getCommentLines() {
		return this.commentLines;
	}

	public void setComment(String comment) {
		this.commentLines.clear();
		addCommentLine(comment);
	}
	
	public void setComment(String comment, Object... params) {
		setComment(String.format(comment, params));
	}

	public void addCommentLine(String line, Object... params) {
		addCommentLine(String.format(line, params));
	}
	
	public void addCommentLine(String line) {
		this.commentLines.add(line);
	}
	
	public boolean hasComment() {
		return (this.commentLines != null) && !this.commentLines.isEmpty();
	}
	
	public boolean hasAnnotations() {
		return (this.annotationList != null) && !this.annotationList.isEmpty();
	}
	
	protected String newLine() {
		return "\n";
	}

	protected String newLines(int numLines) {
		if (numLines <= 0) return "";
		else {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < numLines; i++) sb.append('\n');
			return sb.toString();
		}
	}

	public String emptyLine() {
		return "";
	}

	protected List<String> emptyLines(int numLines) {
		List<String> lines = new ArrayList<>();
		if (numLines > 0)
			for (int i = 0; i < numLines; i++) lines.add("");
		return lines;
	}

	
	public List<Annotation> getAnnotationList() {
		return annotationList;
	}
	
	public boolean addAnnotation(Class<? extends java.lang.annotation.Annotation> annotation) {
		return addAnnotation(new Annotation(annotation));
	}
	
	public boolean addAnnotation(Annotation annotation) {
		if ((annotation.getAnnotation() == null) || !annotation.getAnnotation().isAnnotation()) return false;
		this.annotationList.add(annotation);
		return true;
	}
	
	public StringBuilder writeComment(StringBuilder sb) {
		if (sb == null) return null;
		if (hasComment()) {
			sb.append("/**").append(newLine());
			for (String line : getCommentLines()) sb.append(" * ").append(line).append(newLine());
			sb.append(" */").append(newLine());
		}
		return sb;
	}
	
	public void writeAnnotations(StringBuilder sb) {
		if (getAnnotationList().isEmpty()) return;
		for (Annotation a : getAnnotationList()) {
			sb.append('@').append(a.getAnnotation().getSimpleName());
			sb.append(newLine());
		}
	}

}
