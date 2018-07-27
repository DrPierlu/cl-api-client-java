package io.commercelayer.api.http;

import java.util.HashMap;
import java.util.Map;

import io.commercelayer.api.http.auth.HttpAuth;

public class HttpRequest extends HttpMessage {

	private static final long serialVersionUID = 3703826581025108680L;


	public static enum Method {
		GET, PUT, POST, DELETE, HEAD, PATCH
	}

	private Method method;
	private String url;
	private Map<String, String> queryStringParams;
	
	private HttpAuth httpAuth;
	
	public HttpRequest(Method httpMethod) {
		super();
		this.method = (httpMethod == null)? Method.GET : httpMethod;
		this.queryStringParams = new HashMap<>();
	}
	
	public HttpRequest(Method httpMethod, String url) {
		this(httpMethod);
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public Map<String, String> getQueryStringParams() {
		return queryStringParams;
	}

	public void setQueryStringParams(Map<String, String> queryStringParams) {
		this.queryStringParams = queryStringParams;
	}
	
	public void addQueryStringParam(String key, Object value) {
		this.queryStringParams.put(key, (value == null)? null : value.toString());
	}
	
	public void addQueryStringParam(String key, String value) {
		this.queryStringParams.put(key, value);
	}
	
	public String getQueryStringParam(String key) {
		return this.queryStringParams.get(key);
	}
	
	public boolean hasQueryStringParams() {
		return (this.queryStringParams != null) && !this.queryStringParams.isEmpty();
	}

	public HttpAuth getHttpAuth() {
		return httpAuth;
	}

	public void setHttpAuth(HttpAuth httpAuth) {
		this.httpAuth = httpAuth;
	}
	

	
	public static interface Header {
		String ACCEPT 				= "Accept";
		String PROXY_AUTHORIZATION	= "Proxy-Authorization";
		String AUTHORIZATION		= "Authorization";
	}
	
}
