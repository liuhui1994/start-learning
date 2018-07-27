package org.business.system.common.em;

public enum NoticeState {
	
	TRUE("已读"),
    FALSE("未读");
	
	private String text;
	
	NoticeState(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	

}
