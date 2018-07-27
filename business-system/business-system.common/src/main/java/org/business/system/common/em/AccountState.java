package org.business.system.common.em;

public enum AccountState {
	
	USE("使用中"),
	FREEZ("冻结");
	
	private String text;
	
	AccountState(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	

}
