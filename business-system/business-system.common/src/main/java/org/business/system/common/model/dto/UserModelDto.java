package org.business.system.common.model.dto;

import org.business.system.common.model.UserModel;


public class UserModelDto extends UserModel{
	

	private static final long serialVersionUID = 1L;
	
	private String userIdEnc;

	public String getUserIdEnc() {
		return userIdEnc;
	}

	public void setUserIdEnc(String userIdEnc) {
		this.userIdEnc = userIdEnc;
	}
     

    
}
