package org.business.system.activity.em;

/**
 * 任务类型
 * @author liuhui
 *
 */
public enum TaskType {
	
	PC("注册");
	
	private String text;
	
	TaskType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	

}
