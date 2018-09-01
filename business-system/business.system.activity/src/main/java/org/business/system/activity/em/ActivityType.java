package org.business.system.activity.em;

/**
 * 活动类型
 * @author Administrator
 *
 */
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
