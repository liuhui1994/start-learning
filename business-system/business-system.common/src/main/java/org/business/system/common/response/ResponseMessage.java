package org.business.system.common.response;

public class ResponseMessage<T> {
	
	private String code;
	
	private String message;
	
	private T data;
	
	
	private ResponseMessage(T data) {
		this.code = "SUCCESS";
		this.code = "成功";
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
