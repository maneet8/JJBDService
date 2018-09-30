
package com.jjbd.depot.config;

import java.util.Base64;
import java.util.Base64.Encoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SamConfig {



	@Value("${samClientSecret:testsecret}")
	private String samClientSecret;

	@Value("${samClientId:testclientid}")
	private String samClientId;

	@Value("${introspectionEndpoint:testintropoint}")
	private String introspectionEndpoint;

	@Value("${samIssuer:testissuer}")
	private String samIssuer;

	@Value("${clientCredentialUrl:clienttestcred}")
	private String clientCredentialUrl;

	String encodeToString = null;

	/**
	 * @return samClientSecret
	 */
	public String getSamClientSecret() {
		return samClientSecret;
	}

	/**
	 * @param samClientSecret
	 */
	public void setSamClientSecret(String samClientSecret) {
		this.samClientSecret = samClientSecret;
	}

	/**
	 * @return samClientId
	 */
	public String getSamClientId() {
		return samClientId;
	}

	/**
	 * @param samClientId
	 */
	public void setSamClientId(String samClientId) {
		this.samClientId = samClientId;
	}

	/**
	 * @return introspectionEndpoint
	 */
	public String getIntrospectionEndpoint() {
		return introspectionEndpoint;
	}

	/**
	 * @param introspectionEndpoint
	 */
	public void setIntrospectionEndpoint(String introspectionEndpoint) {
		this.introspectionEndpoint = introspectionEndpoint;
	}

	/**
	 * @return samIssuer
	 */
	public String getSamIssuer() {
		return samIssuer;
	}

	/**
	 * @param samIssuer
	 */
	public void setSamIssuer(String samIssuer) {
		this.samIssuer = samIssuer;
	}

	/**
	 * @return clientCredentialUrl
	 */
	public String getClientCredentialUrl() {
		return clientCredentialUrl;
	}

	/**
	 * @param clientCredentialUrl
	 */
	public void setClientCredentialUrl(String clientCredentialUrl) {
		this.clientCredentialUrl = clientCredentialUrl;
	}

	/**
	 * Based on client id and client secret base 64 encoded value is return
	 * @return encodeToString
	 */
	public String getEncodedHeader() {
		if (encodeToString == null) {
			Encoder encoder = Base64.getEncoder();
			String authHeaderValue = getSamClientId() + ":" + getSamClientSecret();
			return encoder.encodeToString(authHeaderValue.getBytes());
		}
		return encodeToString;
	}
}
