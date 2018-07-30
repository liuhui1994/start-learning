package org.business.system.goods.em;

public enum GoodsType {

	IN("入驻商户"),
	OFFINE("线下商户"),
	ACTIVITY("活动商户");
	
	private String text;
	
	GoodsType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
