package org.business.system.activity.em;

/**
 * 活动奖品类型
 * @author Administrator
 *
 */
public enum RuleType {
	
	REGISTERED("注册");
	
	private String text;
	
	RuleType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	

}
