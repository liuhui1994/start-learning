package org.business.system.auth.util;

import java.io.Serializable;

import org.business.system.auth.comfiguration.User;


public class Oauth2ResponseToken implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String access_token;
	
	private String token_type;
	
	private String refresh_token;
	
	private Long expires_in;
	
	private String scope;
	
	private String jti;
	
	private User user;
	
	

	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getJti() {
		return jti;
	}

	public void setJti(String jti) {
		this.jti = jti;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public Long getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Long expires_in) {
		this.expires_in = expires_in;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
	
	

}
