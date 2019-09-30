package com.suresec.smart.util;

import com.suresec.smart.entity.ReturnMessage;

/**
 * 
 * @author wcc
 * @time 2019-09-29 16:19
 * @description resetful�ӿڷ��ع�����
 */
public class ResultUtil {
	/**
	 * 
	 * @author wcc
	 * @time 2019-09-29 16:23
	 * @description ����ɹ�ʱ����
	 */
    public static ReturnMessage success(Object object){
        ReturnMessage returnMessage=new ReturnMessage();
        returnMessage.setCode(20000);
        returnMessage.setMessage("����ɹ�");
        returnMessage.setData(object);
        return returnMessage;
    }
    public static ReturnMessage success(){
        return success(null);
    }
    /**
     * 
     * @author wcc
     * @time 2019-09-29 16:24
     * @description ����ʧ��ʱ����
     */
    public static ReturnMessage error(Integer code,String msg){
        ReturnMessage returnMessage=new ReturnMessage();
        returnMessage.setCode(code);
        returnMessage.setMessage(msg);
        return returnMessage;
    }
}
