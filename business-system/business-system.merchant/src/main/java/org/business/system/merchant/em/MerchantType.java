package org.business.system.merchant.em;

public enum MerchantType {

	IN("入驻商户"),
	OFFINE("线下商户"),
	ACTIVITY("活动商户");
	
	private String text;
	
	MerchantType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
