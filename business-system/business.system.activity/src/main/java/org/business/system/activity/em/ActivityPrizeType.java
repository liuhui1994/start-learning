package org.business.system.activity.em;

/**
 * 活动奖品类型
 * @author Administrator
 *
 */
public enum ActivityPrizeType {
	
	REGISTERED("注册");
	
	private String text;
	
	ActivityPrizeType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	

}
