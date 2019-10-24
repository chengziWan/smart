package com.suresec.smart.util;

import com.suresec.smart.commom.api.ReturnMessage;

/**
 * 
 * @author wcc
 * @time 2019-09-29 16:19
 * @description resetful接口返回公共类
 */
public class ResultUtil {
	/**
	 * 
	 * @author wcc
	 * @time 2019-09-29 16:23
	 * @description 请求成功时调用
	 */
    public static ReturnMessage success(Object object){
        ReturnMessage returnMessage=new ReturnMessage();
        returnMessage.setCode(20000);
        returnMessage.setMessage("请求成功");
        returnMessage.setData(object);
        return returnMessage;
    }
    /**
     * 
     * @author wcc
     * @time 2019-10-10 13:33
     * @description 暂未使用--会出现不跳转问题
     */
    public static ReturnMessage success(){
        return success(null);
    }
    /**
     * 
     * @author wcc
     * @time 2019-09-29 16:24
     * @description 请求失败时调用
     */
    public static ReturnMessage error(Integer code,String msg){
        ReturnMessage returnMessage=new ReturnMessage();
        returnMessage.setCode(code);
        returnMessage.setMessage(msg);
        return returnMessage;
    }
}
