package com.suresec.smart.commom.api;

import lombok.Data;

/**
 * 
 * @author wcc
 * @param <T>
 * @time 2019-09-29 16:16
 * @description �ӿڷ���ʵ����
 */
@Data
public class ReturnMessage<T> {
	/*������*/
    private Integer code;//20000
 
    /*��ʾ��Ϣ */
    private String message;
 
    /*��������*/
    private  T data;
 
}
