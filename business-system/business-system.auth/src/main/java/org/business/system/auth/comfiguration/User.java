package org.business.system.auth.comfiguration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.business.system.common.model.UserModel;
import org.business.system.common.model.dto.UserModelDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class User extends UserModel implements UserDetails,Serializable {
	
	private String userName;
	
	private String password;
	
	private UserModelDto userModel;
	
	@JsonIgnore
	private Boolean enabled;
	@JsonIgnore
	private Collection<? extends GrantedAuthority> authorities;
	@JsonIgnore
	private Boolean accountNonLocked;
	@JsonIgnore
	private Boolean credentialsNonExpired;
	@JsonIgnore
	private Boolean accountNonExpired;
	
	public User() {
		
	}
	
	public User(UserModelDto userModel) {
		this.userModel = userModel;
		this.userName = userModel.getUsername();
		this.password = userModel.getPassword();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	  List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();  
      authorities.add(new SimpleGrantedAuthority("ADMIN"));  
      return authorities;  
	}

	
	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public UserModelDto getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModelDto userModel) {
		this.userModel = userModel;
	}



}
