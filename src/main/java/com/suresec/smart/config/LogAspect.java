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
//表示这是一个切面类
@Aspect
//将此类交给spring容器管理
@Component
public class LogAspect {

 // 切入点  即 aop 切入的路径（被拦截的方法）
 @Pointcut("execution(public * com.suresec.smart.controller..*.*(..))")
 public void aspectPoint() {
 }

 /**
  * 前置通知--插入请求日志
  */
 // 指定切入点 与上面定义的一样
 @Before("aspectPoint()")
 public void LogRequestInfo(JoinPoint joinPoint) throws Exception {

     // 执行controller 方法之前需要记录的请求信息
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
  * 后置通知--更新日志，添加请求结果
  */
 @AfterReturning(returning = "apiResult", pointcut = "aspectPoint()")
 public void logResultInfo(ReturnMessage apiResult) throws Exception {
     log.info("请求结果：" + apiResult.getCode() + "\t" + apiResult.getMessage());
 }
 /**
  * 
  * @author wcc
  * @time 2019-10-16 11:06
  * @description 获取用户ip
  */
 public static String getIp(HttpServletRequest request) {
	    String ip = request.getHeader("X-Forwarded-For");
	    if(!StringUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
	        //多次反向代理后会有多个ip值，第一个ip才是真实ip
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
