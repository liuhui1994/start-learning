package org.business.system.common.em;

public enum MemberType {
	
	FREEZ("冻结"),
	OPEN("开放");
	
	private String text;
	
	MemberType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	

}
