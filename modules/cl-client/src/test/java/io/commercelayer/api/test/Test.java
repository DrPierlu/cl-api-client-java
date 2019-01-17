package io.commercelayer.api.test;

import java.util.ArrayList;
import java.util.List;

import io.commercelayer.api.model.Order;
import io.commercelayer.api.model.common.ApiResource;

public class Test {

	public static void main(String[] args) {
		
		Order._RELATED_RESOURCES.add(Order.class);
		
		List<Class<? extends ApiResource>> newList = new ArrayList<>();
		
		newList.addAll(Order._RELATED_RESOURCES);
		newList.add(Order.class);
		
		testVarargs("", newList.toArray(null));
		
	}
	
	@SafeVarargs
	private static void testVarargs(String str1, Class<? extends ApiResource>... resources) {
		System.out.println(str1);
		System.out.println(resources);
	}
	
}
