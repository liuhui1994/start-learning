package org.business.system.common.em;

public enum AccountType {
	
	PERSION("个人"),
	MERCHANT("商户");
	
	private String text;
	
	AccountType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	

}
