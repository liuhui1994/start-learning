package org.business.system.common.em;

public enum AccountState {
	
	USE("是"),
	FREEZ("否");
	
	private String text;
	
	AccountState(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	

}
