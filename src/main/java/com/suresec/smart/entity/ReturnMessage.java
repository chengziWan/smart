package com.suresec.smart.entity;
/**
 * 
 * @author wcc
 * @param <T>
 * @time 2019-09-29 16:16
 * @description 接口返回实体类
 */
public class ReturnMessage<T> {
	/*错误码*/
    private Integer code;//20000
 
    /*提示信息 */
    private String message;
 
    /*具体内容*/
    private  T data;
 
    public Integer getCode() {
        return code;
    }
 
    public void setCode(Integer code) {
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
}
