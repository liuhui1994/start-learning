package org.business.system.common.em;

public enum MemberState {
	
	FREEZ("冻结"),
	OPEN("开放");
	
	private String text;
	
	MemberState(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	

}
