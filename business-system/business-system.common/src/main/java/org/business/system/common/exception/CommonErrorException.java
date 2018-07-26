package org.business.system.common.exception;

public class CommonErrorException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;
	
	private String messgae;
	
	public CommonErrorException(String code , String message) {
		this.code = code ;
		this.messgae = message;
	}
	
	public CommonErrorException(String message) {
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
