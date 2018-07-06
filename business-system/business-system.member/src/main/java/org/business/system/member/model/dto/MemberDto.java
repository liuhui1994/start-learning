package org.business.system.member.model.dto;

import org.business.system.member.model.Member;

public class MemberDto extends Member {
	
	private String payAccount;

	public String getPayAccount() {
		return payAccount;
	}

	public void setPayAccount(String payAccount) {
		this.payAccount = payAccount;
	}
	
	

}
