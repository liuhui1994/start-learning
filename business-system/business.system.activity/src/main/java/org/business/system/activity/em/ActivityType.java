package org.business.system.activity.em;

public enum ActivityType {
	
	REGISTERED("注册"),
	MERCHANT("商户");
	
	private String text;
	
	ActivityType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	

}
