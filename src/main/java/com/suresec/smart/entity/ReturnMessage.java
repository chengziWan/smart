package com.suresec.smart.entity;
/**
 * 
 * @author wcc
 * @param <T>
 * @time 2019-09-29 16:16
 * @description �ӿڷ���ʵ����
 */
public class ReturnMessage<T> {
	/*������*/
    private Integer code;//20000
 
    /*��ʾ��Ϣ */
    private String message;
 
    /*��������*/
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
