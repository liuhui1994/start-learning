package org.business.system.common.em;

public enum BooleanType {
	
	TRUE("是"),
	FALSE("否");
	
	private String text;
	
	BooleanType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	

}
