package org.business.system.activity.em;

public enum ActivityType {
	
	REGISTERED("注册");
	
	private String text;
	
	ActivityType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	

}
