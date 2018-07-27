package org.business.system.common.em;

public enum BusinessType {
	
	LOGIN("登陆"),
	REGISTER("注册");
	
	private String text;
	
	BusinessType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	

}
