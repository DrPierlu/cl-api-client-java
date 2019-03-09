package io.commercelayer.api.util;

import java.util.Arrays;
import java.util.Collection;

public class StringUtils {

	private StringUtils() {
		
	}
	
	public static boolean isBlank(String str) {
		return (str == null) || str.trim().isEmpty();
	}
	
	public static boolean isEmpty(String str) {
		return (str == null) || str.isEmpty();
	}
	
	public static String join(Collection<String> list, char separator) {
		return join(list, String.valueOf(separator));
	}
	
	public static String join(Collection<String> list, String separator) {
		
		if (list == null) return null;
		if (list.isEmpty()) return "";
		
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			if (sb.length() > 0) sb.append(separator);
			sb.append(s);
		}
		
		return sb.toString();
		
	}
	
	public static String join(String[] list, char separator) {
		return join(list, String.valueOf(separator));
	}
	
	public static String join(String[] list, String separator) {
		if (list == null) return null;
		else return join(Arrays.asList(list), separator);
	}
	
}
