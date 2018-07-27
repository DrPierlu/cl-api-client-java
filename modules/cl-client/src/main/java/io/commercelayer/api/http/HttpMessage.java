package io.commercelayer.api.http;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public abstract class HttpMessage implements Serializable {

	private static final long serialVersionUID = -5302304006741650004L;
	
	
	private String contentType;
	private Map<String, String> headers;
	private String body;
	
	
	public HttpMessage() {
		this.headers = new TreeMap<>();
	}
	
	
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> header) {
		this.headers = header;
	}
	
	public void addHeader(String header, String value) {
		this.headers.put(header, value);
	}

	public String getHeader(String header) {
		return this.headers.get(header);
	}
	
	public Integer getHeaderInt(String header) {
		String h = this.headers.get(header);
		return (h == null)? null : Integer.valueOf(h);
	}
	
	public boolean hasHeaders() {
		return (this.headers != null) && !this.headers.isEmpty();
	}

	public boolean containsHeader(String header) {
		return hasHeaders() && (this.headers.containsKey(header));
	}
	
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	public String printHeaders() {
		
		StringBuilder sb = new StringBuilder();
		
		if (hasHeaders()) {
			sb.append("[\n");
			for (Map.Entry<String, String> header : getHeaders().entrySet()) {
				sb.append('\t').append(header.getKey()).append(" : ").append(header.getValue()).append('\n');
			}
			sb.append(']');
		}
		else sb.append("<empty_headers>");
		
		return sb.toString();
		
	}

}
