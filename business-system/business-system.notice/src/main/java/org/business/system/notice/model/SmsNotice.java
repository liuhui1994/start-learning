package org.business.system.notice.model;

import java.io.Serializable;

/**
 * 互亿无线接口实体
 * @author Administrator
 *
 */
public class SmsNotice implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String account;  //appID
	
	private String password; //appkey
	
	private String mobile; //接受手机号
	
	private String content; //短信内容
	
	private Long time; //unix时间戳(10位数字)
	
	private String format; //返回格式  xml json

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
