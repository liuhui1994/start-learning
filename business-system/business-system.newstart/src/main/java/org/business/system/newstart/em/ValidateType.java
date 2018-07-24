package org.business.system.newstart.em;

public enum ValidateType {

	MOBILE_CODE("短信验证码"),
	OLD_PASSWORD("旧支付密码校验");
	
	private String text;
	
	ValidateType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
