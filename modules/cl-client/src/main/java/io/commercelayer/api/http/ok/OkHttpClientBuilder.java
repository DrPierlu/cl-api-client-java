package io.commercelayer.api.http.ok;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.commercelayer.api.config.ApiConfig;
import io.commercelayer.api.config.ApiConfig.Group;
import io.commercelayer.api.http.HttpProxy;
import io.commercelayer.api.http.HttpRequest.Header;
import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public class OkHttpClientBuilder {

	private static final Logger logger = LoggerFactory.getLogger(OkHttpClientBuilder.class);

	private Setup clientSetup;

	public OkHttpClientBuilder() {
		this(null);
	}

	public OkHttpClientBuilder(Setup setup) {
		this.clientSetup = setup;
		if (this.clientSetup == null)
			this.clientSetup = new Setup();
	}

	public OkHttpClient build() {

		OkHttpClient.Builder builder = new OkHttpClient.Builder();

		// PROXY
		if (clientSetup.hasProxy()) {

			final HttpProxy httpProxy = clientSetup.getProxy();

			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(httpProxy.getHost(), httpProxy.getPort()));
			builder.proxy(proxy);

			Authenticator proxyAuthenticator = new Authenticator() {
				public Request authenticate(Route route, Response response) throws IOException {
					String credential = Credentials.basic(httpProxy.getUsername(), httpProxy.getPassword());
					return response.request().newBuilder().header(Header.PROXY_AUTHORIZATION, credential).build();
				}
			};
			builder.proxyAuthenticator(proxyAuthenticator);

			// logger.debug("Using Proxy {}:{} ...", httpProxy.getHost(),
			// httpProxy.getPort());

		}

		// HTTPS
		if ((clientSetup.getApiBaseUrl() == null) || clientSetup.getApiBaseUrl().startsWith("https://"))
			if (clientSetup.isSslTrustAllEnabled())
				sslTrustAll(builder);

		// Interceptors
		if (clientSetup.hasInterceptors())
			for (Interceptor interceptor : clientSetup.getInterceptors())
				builder.addInterceptor(interceptor);

		// Network Interceptors
		if (clientSetup.hasNetworkInterceptors())
			for (Interceptor interceptor : clientSetup.getNetworkInterceptors())
				builder.addNetworkInterceptor(interceptor);

		// TIMEOUTS
		builder.connectTimeout(clientSetup.getConnectTimeoutSecs(), TimeUnit.SECONDS);
		builder.readTimeout(clientSetup.getReadTimeoutSecs(), TimeUnit.SECONDS);
		builder.writeTimeout(clientSetup.getWriteTimeoutSecs(), TimeUnit.SECONDS);

		return builder.build();

	}

	private void sslTrustAll(OkHttpClient.Builder builder) {

		SSLContext sslContext = null;
		try {
			sslContext = SSLContext.getInstance("TLS");
		} catch (NoSuchAlgorithmException nsae) {
			logger.error("TLS not available", nsae);
			return;
		}

		X509TrustManager trustManager = new X509TrustManager() {
			public X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[0];
			}

			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(X509Certificate[] certs, String authType) {
			}
		};

		try {
			sslContext.init(null, new TrustManager[] { trustManager }, new SecureRandom());
		} catch (KeyManagementException kme) {
			logger.error("SSLContext Init error", kme);
			return;
		}

		builder.sslSocketFactory(sslContext.getSocketFactory(), trustManager);

		builder.hostnameVerifier(new HostnameVerifier() {
			public boolean verify(String arg0, SSLSession arg1) {
				return true;
			}
		});

	}

	/**
	 * 
	 * OkHttpClient Setup
	 *
	 */
	public static final class Setup {

		// Setup with defaults
		private HttpProxy proxy = null;
		private List<Interceptor> interceptors = new LinkedList<>();
		private List<Interceptor> networkInterceptors = new LinkedList<>();
		private String apiBaseUrl = ApiConfig.getProperty(Group.api, "service.url");
		private boolean sslTrustAllEnabled = ApiConfig.isPropertyEnabled(Group.http, "ssl.trustAll");

		private long connectTimeoutSecs = 30;
		private long readTimeoutSecs = 30;
		private long writeTimeoutSecs = 30;

		public void clearInterceptors() {
			this.interceptors.clear();
		}

		public boolean addInterceptor(Interceptor interceptor) {
			if (interceptor != null) {
				this.interceptors.add(interceptor);
				return true;
			} else
				return false;
		}

		public List<Interceptor> getInterceptors() {
			return this.interceptors;
		}

		public boolean hasInterceptors() {
			return !this.interceptors.isEmpty();
		}

		public void clearNetworkInterceptors() {
			this.networkInterceptors.clear();
		}

		public boolean addNetworkInterceptor(Interceptor interceptor) {
			if (interceptor != null) {
				this.networkInterceptors.add(interceptor);
				return true;
			} else
				return false;
		}

		public List<Interceptor> getNetworkInterceptors() {
			return this.networkInterceptors;
		}

		public boolean hasNetworkInterceptors() {
			return !this.networkInterceptors.isEmpty();
		}

		public HttpProxy getProxy() {
			return proxy;
		}

		public void setProxy(HttpProxy proxy) {
			this.proxy = proxy;
		}

		public boolean hasProxy() {
			return (this.proxy != null);
		}

		public boolean isSslTrustAllEnabled() {
			return sslTrustAllEnabled;
		}

		public void setSslTrustAllEnabled(boolean sslTrustAllEnabled) {
			this.sslTrustAllEnabled = sslTrustAllEnabled;
		}

		public long getConnectTimeoutSecs() {
			return connectTimeoutSecs;
		}

		public void setConnectTimeoutSecs(long connectTimeoutSecs) {
			this.connectTimeoutSecs = connectTimeoutSecs;
		}

		public long getReadTimeoutSecs() {
			return readTimeoutSecs;
		}

		public void setReadTimeoutSecs(long readTimeoutSecs) {
			this.readTimeoutSecs = readTimeoutSecs;
		}

		public long getWriteTimeoutSecs() {
			return writeTimeoutSecs;
		}

		public void setWriteTimeoutSecs(long writeTimeoutSecs) {
			this.writeTimeoutSecs = writeTimeoutSecs;
		}

		public String getApiBaseUrl() {
			return apiBaseUrl;
		}

		public void setApiBaseUrl(String apiBaseUrl) {
			this.apiBaseUrl = apiBaseUrl;
		}

	}

}
