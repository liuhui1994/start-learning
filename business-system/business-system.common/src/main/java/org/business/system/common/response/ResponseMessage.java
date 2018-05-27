package org.business.system.common.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ResponseMessage<T> implements Serializable {
	
	private String code;
	
	private String message;
	
	private T data;
	
	
	
	


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	private ResponseMessage(T data) {
		this.code = "00";
		this.message = "SUCCESS";
		this.data = data;
	}
	
	private ResponseMessage(CodeMessage cm) {
		if(cm==null) {
			return ;
		}
		this.code = cm.getCode();
		this.message = cm.getMessage();
		
	}

	
	 /**  
     * 成功时候的调用  
     * @return  
     */  
    public static <T> ResponseMessage<T> success(T data){  
        return new ResponseMessage<T>(data);  
    }  
    /**  
     * 成功，不需要传入参数  
     * @return  
     */  
    @SuppressWarnings("unchecked")  
    public static <T> ResponseMessage<T> success(){  
        return (ResponseMessage<T>) success("");  
    }  
    /**  
     * 失败时候的调用  
     * @return  
     */  
    public static <T> ResponseMessage<T> error(CodeMessage cm){  
        return new ResponseMessage<T>(cm);  
    }  
    
    /**  
     * 失败时候的调用,扩展消息参数  
     * @param cm  
     * @param msg  
     * @return  
     */  
    public static <T> ResponseMessage<T> error(CodeMessage cm,String msg){  
        cm.setMessage(cm.getMessage()+"--"+msg);  
        return new ResponseMessage<T>(cm);  
    }  


}
