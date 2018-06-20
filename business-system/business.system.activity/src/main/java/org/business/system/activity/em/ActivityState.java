package org.business.system.activity.em;

public enum ActivityState {
	
	USE("使用中"),
	FREEZ("冻结");
	
	private String text;
	
	ActivityState(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	

}
