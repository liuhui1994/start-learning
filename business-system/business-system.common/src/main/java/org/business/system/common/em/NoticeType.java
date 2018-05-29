package org.business.system.common.em;

public enum NoticeType {
	
	USER("外部用户"),
	SYSTEM("系统用户"),
	MERCHANT("商户");
	
	private String text;
	
	NoticeType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	

}
