package org.business.system.notice.ecception;

public class ValidateCodeException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;
	
	private String messgae;
	
	public ValidateCodeException(String code , String message) {
		this.code = code ;
		this.messgae = message;
	}
	
	public ValidateCodeException(String message) {
		this.messgae = message;
	}

}
