package io.commercelayer.api.client.common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.auth.AuthRequest;
import io.commercelayer.api.auth.AuthorizationCode;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.config.ApiConfig;
import io.commercelayer.api.domain.ContentType;
import io.commercelayer.api.http.HttpClient;
import io.commercelayer.api.http.HttpClientFactory;
import io.commercelayer.api.http.HttpRequest;
import io.commercelayer.api.http.HttpRequest.Method;
import io.commercelayer.api.http.HttpResponse;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.model.common.error.AuthError;
import io.commercelayer.api.util.JSONUtils;


public class ApiAuthenticator {
	
	private static final Logger logger = LoggerFactory.getLogger(ApiAuthenticator.class);
	
	private static final String PATH_AUTHORIZATION = "/oauth/authorize";
	private static final String PATH_TOKEN = "/oauth/token";
	
	
	private ApiOrganization apiOrg;
	private HttpClient httpClient;
	private String apiBaseUrl;
	
	public ApiAuthenticator(ApiOrganization org) {
		this.apiOrg = org;
		this.apiBaseUrl = ApiConfig.getApiBaseUrl(this.apiOrg);
		this.httpClient = HttpClientFactory.getHttpClientInstance();
	}
	
	public ApiToken authenticate(ApiAuth auth) throws AuthException {
		
		AuthRequest authRequest = new AuthRequest(auth);
		authRequest.setTokenUrl(this.apiBaseUrl.concat(PATH_TOKEN));
		
		return authCall(authRequest);
		
	}
	
	
	private ApiToken authCall(AuthRequest authRequest) throws AuthException {

		HttpRequest httpRequest = new HttpRequest(Method.POST);

		httpRequest.setUrl(authRequest.getTokenUrl());
		if (authRequest.getHttpAuth() != null) httpRequest.setHttpAuth(authRequest.getHttpAuth());
		httpRequest.setBody(JSONUtils.toJSON(authRequest.getApiAuth()));
		httpRequest.setContentType(ContentType.JSON);

		logger.debug("Auth Request Body: {}", httpRequest.getBody());

		HttpResponse httpResponse = httpClient.send(httpRequest);
		
		logger.debug("Auth Response Body: {}", httpResponse.getBody());
		
		if (httpResponse.hasErrorCode()) {
			AuthError authError = JSONUtils.fromJSON(httpResponse.getBody(), AuthError.class);
			authError.setHttpErrorCode(httpResponse.getCode());
			throw new AuthException(authError);
		}
		else
			if (!ContentType.JSON.equals(httpResponse.getContentType()))
				throw new RuntimeException(String.format("Expected JSON Content Type [%s]", httpResponse.getContentType()));

		ApiToken token = JSONUtils.fromJSON(httpResponse.getBody(), ApiToken.class);

		return token;

	}
	
	
	public static String getAuthorizationUrl(ApiOrganization org, AuthorizationCode auth, boolean encode) {
		return getAuthorizationUrl(ApiConfig.getApiBaseUrl(org.getSubdomain()), auth, encode);
	}
	
	public static String getAuthorizationUrl(String baseUrl, AuthorizationCode auth, boolean encode) {
		
		final String urlP = "%s%s?client_id=%s&redirect_uri=%s&scope=%s&response_type=code";
		
		String redirectUri = auth.getRedirectUri();
		
		if (encode)
			try {
				redirectUri = URLEncoder.encode(auth.getRedirectUri(), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				logger.error(e.getMessage());
			}
		
		return String.format(urlP, baseUrl, PATH_AUTHORIZATION, auth.getClientId(), redirectUri, auth.getScope());
		
	}

}
