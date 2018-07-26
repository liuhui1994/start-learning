package org.business.system.common.em;

public enum TradeType {
	
	ORDER("下单"),
	WITHDRAWAL("提现"),
	RECHANGR("充值"),
	REFISTER("注册"),
	EXCHANGE("兑换");
	
	private String text;
	
	TradeType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	

}
