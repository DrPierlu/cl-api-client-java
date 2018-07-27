package io.commercelayer.api.codegen.schema.parser.impl;

import java.net.URL;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reprezen.kaizen.oasparser.OpenApi3Parser;
import com.reprezen.kaizen.oasparser.model3.Info;
import com.reprezen.kaizen.oasparser.model3.MediaType;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.model3.Operation;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import com.reprezen.kaizen.oasparser.model3.Path;
import com.reprezen.kaizen.oasparser.model3.RequestBody;
import com.reprezen.kaizen.oasparser.model3.Response;
import com.reprezen.kaizen.oasparser.model3.Schema;

import io.commercelayer.api.codegen.schema.ApiAttribute;
import io.commercelayer.api.codegen.schema.ApiOperation;
import io.commercelayer.api.codegen.schema.ApiParameter;
import io.commercelayer.api.codegen.schema.ApiPath;
import io.commercelayer.api.codegen.schema.ApiRequestBody;
import io.commercelayer.api.codegen.schema.ApiResponse;
import io.commercelayer.api.codegen.schema.ApiSchema;
import io.commercelayer.api.codegen.schema.parser.SchemaException;
import io.commercelayer.api.codegen.schema.parser.SchemaParser;
import io.commercelayer.api.domain.OperationType;
import io.commercelayer.api.domain.ResponseType;

public class OpenAPIParserV3 implements SchemaParser {
	
	private static final Logger logger = LoggerFactory.getLogger(OpenAPIParserV3.class);
	

	public ApiSchema parse(URL schemaUrl) throws SchemaException {
		return normalizeSchema(parseSchema(schemaUrl));
	}

	private OpenApi3 parseSchema(URL schemaUrl) throws SchemaException {
		try {
			logger.info("Parsing API Schema ...");
			OpenApi3 schema = new OpenApi3Parser().parse(schemaUrl, true);
			logger.info("Successfully terminated.");
			return schema;
		}
		catch (Exception e) {
			throw new SchemaException("Error parsing API Schema", e);
		}
	}

	private ApiSchema normalizeSchema(OpenApi3 openApiSchema) throws SchemaException {
		
		logger.info("Normalizing API Schema ...");

		try {
			
			ApiSchema apiSchema = new ApiSchema();
			
			// General Info
			String openApiVersion = openApiSchema.getOpenApi();
			Info info = openApiSchema.getInfo();
			
			apiSchema.setApiTitle(info.getTitle());
			apiSchema.setApiVersion(info.getVersion());
			apiSchema.setOpenApiVersion(openApiVersion);
			
			logger.info("API Schema [{}, {}, OpenAPI {}]", apiSchema.getApiTitle(), apiSchema.getApiVersion(), apiSchema.getOpenApiVersion());
			
			
			// Paths
			for (Map.Entry<String, Path> ep : openApiSchema.getPaths().entrySet()) {
				
				Path path = ep.getValue();
				ApiPath apiPath = new ApiPath(ep.getKey());
				apiSchema.addPath(apiPath);
				
				logger.debug("Reading Path {} ...", apiPath.getResource());
				
				// Operations
				for (Map.Entry<String, Operation> eo : path.getOperations().entrySet()) {
					
					Operation op = eo.getValue();
					ApiOperation apiOp = new ApiOperation(OperationType.byCode(eo.getKey()));
					apiPath.addOperation(apiOp);
					
					apiOp.setId(op.getOperationId());
					apiOp.setSummary(op.getSummary());
					
					logger.debug("  Operation {} ({})", apiOp.getType().code(), apiOp.getSummary());
					
					for (Map.Entry<String, Response> er : op.getResponses().entrySet()) {
						apiOp.addResponse(new ApiResponse(ResponseType.byCode(er.getKey()), er.getValue().getDescription()));
					}
					
					
					parseParameters(op, apiOp);
					
					
					if (OperationType.POST.code().equalsIgnoreCase(eo.getKey()) || OperationType.PATCH.code().equalsIgnoreCase(eo.getKey()) ) {
						ApiRequestBody body = new ApiRequestBody();
						apiOp.setRequestBody(body);
						parseRequestBody(op.getRequestBody(), body);
					}
					
				}
				
			}
			
			logger.info("Successfully terminated.");

			return apiSchema;
			
		}
		catch (Exception e) {
			throw new SchemaException("Error normalizing API Schema", e);
		}

	}
	
	
	private void parseParameters(Operation op, ApiOperation apiOp) {
		
		logger.debug("    Parameters:");
		for (Parameter p : op.getParameters()) {
			
			ApiParameter param = new ApiParameter(p.getName());
			
			param.setDescription(p.getDescription());
			param.setRequired(p.isRequired());
			param.setType(p.getSchema().getType());
			param.setFormat(p.getSchema().getFormat());
			param.setDeprecated(p.isDeprecated());
			param.setIn(p.getIn());
			
			apiOp.addParameter(param);
			
			logger.debug("      {} [{}]", param.getName(), param.getType());
						
		}
		
		if ((apiOp.getParameters() == null) || apiOp.getParameters().isEmpty()) logger.info("      <empty>");
		
	}
	
	private void parseRequestBody(RequestBody rb, ApiRequestBody body) {
		
		logger.debug("    REQUEST BODY");
		
		MediaType md = rb.getContentMediaType("application/vnd.api+json");
		Schema data = md.getSchema().getProperty("data");
		
		Schema attrs = data.getProperty("attributes");
		
		// Required fields
		logger.debug("    Required fields:");
		for (String rf : attrs.getRequiredFields()) {
			body.addRequiredField(rf);
			logger.info("      {}", rf);
		}
		if ((body.getRequiredFields() == null) || body.getRequiredFields().isEmpty()) logger.info("      <empty>");
		
		
		// Fields
		logger.debug("    Attributes:");
		for (Map.Entry<String, Schema> ea : attrs.getProperties().entrySet()) {
			
			ApiAttribute attribute = new ApiAttribute(ea.getKey());
			body.addAttribute(attribute);
			
			Schema attr = ea.getValue();
			
			attribute.setType(attr.getType());
			attribute.setDescription(attr.getDescription());
			
			Object example = attr.getExample();
			if (example instanceof String) attribute.setExample(example.toString());
			else
			if (example instanceof Map) attribute.setExample("[\"foo\" : \"bar\"");
			
			if (body.getRequiredFields() != null) {
				for (String rf : body.getRequiredFields())
					if (rf.equals(attribute.getName())) {
						attribute.setRequired(true);
						break;
					}
			}
			
			logger.debug("      {} [{}]", attribute.getName(), attribute.getType());
			
		}
		
		
		// Relationships
		Schema rels = data.getProperty("relationships");
		
		logger.debug("    Relationships:");
		for (Map.Entry<String, Schema> er : rels.getProperties().entrySet()) {
			body.addRelationship(er.getKey());
			logger.debug("      {}", er.getKey());
		}
		if ((body.getRelationships() == null) || body.getRelationships().isEmpty()) logger.info("      <empty>");
		
	}

}
