package org.business.system.goods.em;

public enum GoodsCollectionType {

	BANK("银行卡"),
	PAY("支付宝");

	
	private String text;
	
	GoodsCollectionType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
