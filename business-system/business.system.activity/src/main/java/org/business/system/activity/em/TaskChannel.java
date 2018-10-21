package org.business.system.activity.em;

/**
 * 活动奖品类型
 * @author Administrator
 *
 */
public enum TaskChannel {
	
	要发广告联盟("注册");
	
	private String text;
	
	TaskChannel(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	

}
