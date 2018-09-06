package io.commercelayer.api.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author p.viti
 *
 */
public final class LogUtils {
	
	private static final LogUtils instance;

	static {
		instance = new LogUtils();
	}
	
	private LogUtils() {
		super();
	}

	public static LogUtils getInstance() {
		return instance;
	}

	public static String printStackTrace(Throwable t) {

		if (t == null)
			return ("");

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw, true);

		t.printStackTrace(pw);

		String stack = sw.toString();

		try {
			if (pw != null)
				pw.close();
			if (sw != null)
				sw.close();
		} catch (IOException ioe) {
			singleErrorStackTrace(LogUtils.class, ioe);
		}

		return stack;

	}

	public String getStackTrace(Throwable t) {

		if (t == null)
			return ("");

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw, true);

		t.printStackTrace(pw);

		String stack = sw.toString();

		try {
			if (pw != null)
				pw.close();
			if (sw != null)
				sw.close();
		} catch (IOException ioe) {
			singleErrorStackTrace(LogUtils.class, ioe);
		}

		return stack;

	}

	public static Logger getLogger(Class<?> classe) {
		return LoggerFactory.getLogger(classe);
	}

	public static Logger getLogger(Object object) {
		return LoggerFactory.getLogger(object.getClass());
	}

	public static void singleErrorStackTrace(Class<?> classe, Throwable t) {
		singleErrorMessage(classe, printStackTrace(t));
	}

	public static void singleErrorStackTrace(Object obj, Throwable t) {
		singleErrorMessage(obj, printStackTrace(t));
	}

	public static void singleErrorMessage(Object obj, String message) {
		singleErrorMessage(obj.getClass(), message);
	}

	public static void singleInfoMessage(Object obj, String message) {
		singleInfoMessage(obj.getClass(), message);
	}

	public static void singleErrorMessage(Class<?> classe, String message) {
		getLogger(classe).error(message);
	}

	public static void singleDebugMessage(Class<?> classe, String message) {
		getLogger(classe).debug(message);
	}

	public static void singleInfoMessage(Class<?> classe, String message) {
		getLogger(classe).info(message);
	}
	
	
	public static String toString(Object obj) {
		
		if (obj == null) return null;
		
		Class<?> classe = obj.getClass();
		Field[] fields = classe.getDeclaredFields();
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(classe.getSimpleName()).append("->[");
				
		// TODO: Introdurre gestione campi superclassi
//		List<Field> l = new LinkedList<>();
//		l.addAll(Arrays.asList(fields));
//		if (classe.getSuperclass())
		
		int idx = 0;
		if (fields != null)
			for (Field field : fields) {
				
//				if ((field.getModifiers() & Modifier.STATIC) > 0) continue;
				if (Modifier.isStatic(field.getModifiers())) continue;
				
				if (++idx > 1) builder.append(", ");
				builder.append(field.getName());
				builder.append("=");
				
				Object value = null;
				try {
					field.setAccessible(true);
					value = field.get(obj);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					value = null;
				}
//				builder.append(String.valueOf(value));
				builder.append((value == null)? "<null>" : value.toString());
				
			}
		
		builder.append("]");
		
		return builder.toString();
		
	}

}
