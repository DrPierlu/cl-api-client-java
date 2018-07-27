package io.commercelayer.api.auth;

import io.commercelayer.api.model.common.ApiObject;

public class ApiOrganization extends ApiObject {

	private String subdomain;

	public ApiOrganization(String subdomain) {
		this.subdomain = subdomain;
	}
	
	public String getSubdomain() {
		return subdomain;
	}

}
