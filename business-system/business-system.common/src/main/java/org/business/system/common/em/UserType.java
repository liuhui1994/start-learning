package org.business.system.common.em;

public enum UserType {
	
	USER("外部用户"),
	SYSTEM("系统用户"),
	WEIXIN("系统用户"),
	MERCHANT("商户");
	
	private String text;
	
	UserType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	

}
