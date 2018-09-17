package org.business.system.common.model;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

import org.business.system.common.base.model.Entity;
import org.business.system.common.em.UserState;
import org.business.system.common.em.UserType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Table(name="t_system_user")
@JsonInclude(Include.NON_NULL)
public class UserModel extends Entity implements Serializable{
	
	public UserModel() {
		
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    private Long id;
    
    private String loginName;
    
    private String password;
    
    private String phone;
    
    private String payAccount;
    
    private String appId;
    
    private String appKey;
      
    private UserType userType;
    
    @JsonIgnore
    private String registerIp;
    
    private String payPassword;
    
    private String nickName;
    
    private String username;
    
    private UserState state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPayAccount() {
		return payAccount;
	}

	public void setPayAccount(String payAccount) {
		this.payAccount = payAccount;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getRegisterIp() {
		return registerIp;
	}

	public void setRegisterIp(String registerIp) {
		this.registerIp = registerIp;
	}

	public String getPayPassword() {
		return payPassword;
	}

	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserState getState() {
		return state;
	}

	public void setState(UserState state) {
		this.state = state;
	}


    
}
