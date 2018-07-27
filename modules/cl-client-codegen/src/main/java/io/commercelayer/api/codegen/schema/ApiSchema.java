package io.commercelayer.api.codegen.schema;

import java.util.ArrayList;
import java.util.List;

public class ApiSchema {

	private String openApiVersion;
	private String apiTitle;
	private String apiVersion;
	
	private List<ApiPath> paths;

	public String getOpenApiVersion() {
		return openApiVersion;
	}

	public void setOpenApiVersion(String openApiVersion) {
		this.openApiVersion = openApiVersion;
	}

	public String getApiTitle() {
		return apiTitle;
	}

	public void setApiTitle(String apiTitle) {
		this.apiTitle = apiTitle;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public List<ApiPath> getPaths() {
		return paths;
	}

	public void setPaths(List<ApiPath> paths) {
		this.paths = paths;
	}

	public void addPath(ApiPath path) {
		if (this.paths == null) this.paths = new ArrayList<ApiPath>();
		this.paths.add(path);
	}
	
}
