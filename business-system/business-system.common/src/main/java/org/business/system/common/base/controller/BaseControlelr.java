package org.business.system.common.base.controller;

import org.business.system.common.response.ResponseMessage;

public class BaseControlelr {

	
	public <T> ResponseMessage<T> adpptResponse(T t){	
		return ResponseMessage.success(t);
	}
}
