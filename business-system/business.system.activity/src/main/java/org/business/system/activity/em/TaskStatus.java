package org.business.system.activity.em;

/**
 * 活动奖品类型
 * @author Administrator
 *
 */
public enum TaskStatus {
	
	USE("使用中");
	
	private String text;
	
	TaskStatus(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	

}
