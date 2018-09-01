package org.business.system.activity.em;

/**
 * 规则限制类型
 * @author Administrator
 *
 */
public enum RuleLimitType {
	
	HOUR("时"),
	DAY("日"),
	WEEK("周"),
	MOTNTH("月"),
	NONE("无限制");
	
	private String text;
	
	RuleLimitType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	

}
