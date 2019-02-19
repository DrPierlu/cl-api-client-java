package io.commercelayer.api.client.common;

import java.util.HashMap;
import java.util.List;

import io.commercelayer.api.model.common.ApiResource;
import moe.banana.jsonapi2.Resource;

public final class AdaptersCacheMap {

	private static final HashMap<String, List<Class<? extends ApiResource>>> CACHE;
	
	static {
		CACHE = new HashMap<>();
	}
	
	
	public static void setAdaptersList(Class<? extends Resource> resource, List<Class<? extends ApiResource>> adapters) {
		addAdaptersList(resource.getName(), adapters);
	}
	
	public static void setAdaptersList(String resource, List<Class<? extends ApiResource>> adapters) {
		CACHE.put(resource, adapters);
	}
	
	public static void addAdaptersList(Class<? extends Resource> resource, List<Class<? extends ApiResource>> adapters) {
		addAdaptersList(resource.getName(), adapters);
	}
	
	public static void addAdaptersList(String resource, List<Class<? extends ApiResource>> adapters) {
		List<Class<? extends ApiResource>> cached = getAdaptersList(resource);
		if (cached != null) cached.addAll(adapters);
		else cached = adapters;
		setAdaptersList(resource, cached);
	}
	
	public static List<Class<? extends ApiResource>> getAdaptersList(Class<? extends Resource> resource) {
		return getAdaptersList(resource.getName());
	}

	public static List<Class<? extends ApiResource>> getAdaptersList(String resource) {
		return CACHE.get(resource);
	}
	
	public static boolean hasCachedAdapters(Class<? extends Resource> resource) {
		return hasCachedAdapters(resource.getName());
	}
	
	public static boolean hasCachedAdapters(String resource) {
		return (getAdaptersList(resource) != null);
	}
	
}
