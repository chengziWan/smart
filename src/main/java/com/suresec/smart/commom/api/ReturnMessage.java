package com.suresec.smart.commom.api;

import lombok.Data;

/**
 * 
 * @author wcc
 * @param <T>
 * @time 2019-09-29 16:16
 * @description 接口返回实体类
 */
@Data
public class ReturnMessage<T> {
	/*错误码*/
    private Integer code;//20000
 
    /*提示信息 */
    private String message;
 
    /*具体内容*/
    private  T data;
 
}
