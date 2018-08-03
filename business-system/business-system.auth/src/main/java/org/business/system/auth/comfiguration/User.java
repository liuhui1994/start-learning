package org.business.system.auth.comfiguration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.business.system.common.model.UserModel;
import org.business.system.common.model.dto.UserModelDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User extends UserModel implements UserDetails {
	
	private String userName;
	
	private String password;
	
	private UserModelDto userModel;
	
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
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public UserModelDto getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModelDto userModel) {
		this.userModel = userModel;
	}



}
