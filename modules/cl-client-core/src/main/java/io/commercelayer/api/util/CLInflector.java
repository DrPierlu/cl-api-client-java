package io.commercelayer.api.util;

public final class CLInflector {
	
	private static final Inflector INSTANCE;
	
	static {
		INSTANCE = new Inflector();
		INSTANCE.addSingularize("(sku)s$", "$1");
	}
	
	public static Inflector getInstance(){
		return INSTANCE;
	}
	
}
