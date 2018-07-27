package org.business.system.account.exception;

public class AccountException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;
	
	private String messgae;
	
	public AccountException(String code , String message) {
		this.code = code ;
		this.messgae = message;
	}
	
	public AccountException(String message) {
		this.messgae = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessgae() {
		return messgae;
	}

	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}

	
}
