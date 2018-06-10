package org.business.system.common.em;

public enum UserState {
	
	FREEZ("冻结"),
	OPEN("开放");
	
	private String text;
	
	UserState(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	

}
