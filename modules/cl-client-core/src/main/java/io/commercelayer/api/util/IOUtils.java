package io.commercelayer.api.util;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public final class IOUtils {
	
	private IOUtils() {
		super();
	}

	public static void closeResources(Closeable... resources) {
		if (resources == null) return;
		else
			for (Closeable c : resources)
				try {
					if (c instanceof Flushable) ((Flushable)c).flush();
					c.close();
				}
				catch (IOException ioe) {
					LogUtils.singleErrorStackTrace(IOUtils.class, ioe);
				}
	}
	
	
	public static String packageToPath(String pkg, String basePath) {
		
		final String fileSeparator = "/";
		
		StringBuilder sb = new StringBuilder();
		
		if (basePath != null) {
			sb.append(basePath);
			if (!basePath.endsWith(fileSeparator)) sb.append(fileSeparator);
		}
		sb.append(pkg.replaceAll("\\.", fileSeparator));
		
		String path = sb.toString();
		if (!path.endsWith(fileSeparator)) path.concat(fileSeparator);
		
		return path;
		
	}
	
}
