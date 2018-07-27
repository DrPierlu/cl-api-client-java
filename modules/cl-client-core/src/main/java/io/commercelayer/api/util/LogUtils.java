package io.commercelayer.api.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.commercelayer.api.config.ApiConfig;

/**
 * @author p.viti
 *
 */
public final class LogUtils {

	public static final ToStringStyle TO_STRING_STYLE = ApiConfig.testModeEnabled()? ToStringStyle.MULTI_LINE_STYLE : ToStringStyle.SHORT_PREFIX_STYLE;
	
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

}
