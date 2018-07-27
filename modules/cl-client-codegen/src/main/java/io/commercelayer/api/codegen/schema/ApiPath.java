package io.commercelayer.api.codegen.schema;

import java.util.HashMap;
import java.util.Map;

import io.commercelayer.api.domain.OperationType;

public class ApiPath {

	private String resource;
	private Map<OperationType, ApiOperation> operations;

	public ApiPath(String resource) {
		this.resource = resource;
	}
	
	public String getResource() {
		return resource;
	}

	public Map<OperationType, ApiOperation> getOperations() {
		return operations;
	}

	public void setOperations(Map<OperationType, ApiOperation> operations) {
		this.operations = operations;
	}
	
	public void addOperation(ApiOperation op) {
		if (this.operations == null) this.operations = new HashMap<OperationType, ApiOperation>();
		this.operations.put(op.getType(), op);
	}

}
