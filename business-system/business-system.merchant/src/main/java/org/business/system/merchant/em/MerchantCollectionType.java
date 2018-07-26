package org.business.system.merchant.em;

public enum MerchantCollectionType {

	BANK("银行卡"),
	PAY("支付宝");

	
	private String text;
	
	MerchantCollectionType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
