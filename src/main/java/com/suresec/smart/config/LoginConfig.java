package com.suresec.smart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.suresec.smart.interceptor.LoginInterceptor;

/**
 * @author 王杨帅
 * @create 2018-09-11 21:35
 * @desc
 **/
@Configuration
public class LoginConfig implements WebMvcConfigurer {
	@Autowired
	private LoginInterceptor loginInterceptor;
    public void addInterceptors(InterceptorRegistry registry) {
    	// addPathPatterns("/**") 表示拦截所有的请求，
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
        registry.addInterceptor(loginInterceptor)
        .addPathPatterns("/prod-api/**")
        .excludePathPatterns("/swagger-ui.html", "/prod-api/user/login", "/prod-api/user/logout");

    }
}