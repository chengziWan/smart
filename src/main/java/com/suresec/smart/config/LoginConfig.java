package com.suresec.smart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.suresec.smart.interceptor.LoginInterceptor;

/**
 * @author ����˧
 * @create 2018-09-11 21:35
 * @desc
 **/
@Configuration
public class LoginConfig implements WebMvcConfigurer {
	@Autowired
	private LoginInterceptor loginInterceptor;
    public void addInterceptors(InterceptorRegistry registry) {
    	// addPathPatterns("/**") ��ʾ�������е�����
        // excludePathPatterns("/login", "/register") ��ʾ���˵�½��ע��֮�⣬��Ϊ��½ע�᲻��Ҫ��½Ҳ���Է���
        registry.addInterceptor(loginInterceptor)
        .addPathPatterns("/prod-api/**")
        .excludePathPatterns("/swagger-ui.html", "/prod-api/user/login", "/prod-api/user/logout");

    }
}