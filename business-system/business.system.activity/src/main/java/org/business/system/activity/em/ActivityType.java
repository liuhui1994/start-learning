package org.business.system.activity.em;

public enum ActivityType {
	
	PERSION("个人"),
	MERCHANT("商户");
	
	private String text;
	
	ActivityType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	

}
