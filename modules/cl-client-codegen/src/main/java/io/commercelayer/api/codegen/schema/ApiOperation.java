package io.commercelayer.api.codegen.schema;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import io.commercelayer.api.domain.OperationType;
import io.commercelayer.api.domain.ResponseType;

public class ApiOperation {

	private String id;
	private OperationType type;
	private String summary;

	private Map<ResponseType, ApiResponse> responses = new LinkedHashMap<>();
	private List<ApiParameter> parameters = new LinkedList<>();
	private ApiRequestBody requestBody;

	public ApiOperation(OperationType type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setType(OperationType type) {
		this.type = type;
	}

	public OperationType getType() {
		return type;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Map<ResponseType, ApiResponse> getResponses() {
		return responses;
	}

	public void setResponses(Map<ResponseType, ApiResponse> responses) {
		this.responses = responses;
	}

	public void addResponse(ApiResponse response) {
		this.responses.put(response.getType(), response);
	}

	public List<ApiParameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<ApiParameter> parameters) {
		this.parameters = parameters;
	}

	public void addParameter(ApiParameter param) {
		this.parameters.add(param);
	}

	public ApiRequestBody getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(ApiRequestBody requestBody) {
		this.requestBody = requestBody;
	}

}
