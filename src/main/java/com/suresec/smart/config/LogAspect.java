package com.suresec.smart.config;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.suresec.smart.entity.ReturnMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//��ʾ����һ��������
@Aspect
//�����ཻ��spring��������
@Component
public class LogAspect {

 // �����  �� aop �����·���������صķ�����
 @Pointcut("execution(public * com.suresec.smart.controller..*.*(..))")
 public void aspectPoint() {
 }

 /**
  * ǰ��֪ͨ--����������־
  */
 // ָ������� �����涨���һ��
 @Before("aspectPoint()")
 public void LogRequestInfo(JoinPoint joinPoint) throws Exception {

     // ִ��controller ����֮ǰ��Ҫ��¼��������Ϣ
     ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
     HttpServletRequest request = attributes.getRequest();

     log.info("URL: {}",request.getRequestURL());
     log.info("HTTP_METHOD: {} ", request.getMethod());
     log.info("IP: {}", getIp(request));
//     log.info("IP: {}", request.getLocalAddr()+";"+request.getLocalName());
     log.info("CLASS_METHOD: {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
     log.info("ARGS: {}", Arrays.toString(joinPoint.getArgs()));
 }

 /**
  * ����֪ͨ--������־�����������
  */
 @AfterReturning(returning = "apiResult", pointcut = "aspectPoint()")
 public void logResultInfo(ReturnMessage apiResult) throws Exception {
     log.info("��������" + apiResult.getCode() + "\t" + apiResult.getMessage());
 }
 /**
  * 
  * @author wcc
  * @time 2019-10-16 11:06
  * @description ��ȡ�û�ip
  */
 public static String getIp(HttpServletRequest request) {
	    String ip = request.getHeader("X-Forwarded-For");
	    if(!StringUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
	        //��η���������ж��ipֵ����һ��ip������ʵip
	        int index = ip.indexOf(",");
	        if(index != -1){
	            return ip.substring(0,index);
	        }else{
	            return ip;
	        }
	    }
	    ip = request.getHeader("X-Real-IP");
	    if(!StringUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
	        return ip;
	    }
	    return request.getRemoteAddr();
	}
 
}
