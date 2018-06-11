package org.business.system.common.base.controller;

import org.business.system.common.exception.CommonErrorException;
import org.business.system.common.response.CodeMessage;
import org.business.system.common.response.ResponseMessage;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorControllerAdvice {

	@ExceptionHandler(value = CommonErrorException.class)
	public ResponseMessage commonErrorException(CommonErrorException commonErrorException){
		return ResponseMessage.error(commonErrorException.getCode(), commonErrorException.getMessgae());
	}
	 
	 
    @ExceptionHandler(value = Exception.class)
    public CodeMessage errorHandler(Exception ex) {
		System.out.println(ex);
        return new CodeMessage("00", "FAIL");
    }
}
