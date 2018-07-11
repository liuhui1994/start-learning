package org.business.system.common.model.dto;

import org.business.system.common.model.UserModel;


public class UserModelDto extends UserModel{
	

	private static final long serialVersionUID = 1L;
	
	private String userIdEnc;
	
	private String invitCode; // 邀请码

	public String getUserIdEnc() {
		return userIdEnc;
	}

	public void setUserIdEnc(String userIdEnc) {
		this.userIdEnc = userIdEnc;
	}

	public String getInvitCode() {
		return invitCode;
	}

	public void setInvitCode(String invitCode) {
		this.invitCode = invitCode;
	}
     
	

    
}
