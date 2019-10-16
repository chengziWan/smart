package com.suresec.smart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
/**
 * 
 * @author wcc
 * @time 2019-10-14 14:02
 * @description 
 */
@EnableTransactionManagement//spring Boot ʹ������ǳ��򵥣�����ʹ��ע�� @EnableTransactionManagement ��������֧�ֺ�Ȼ���ڷ������ݿ��Service���������ע�� @Transactional ���
@SpringBootApplication
public class AppStarter {
	public static void main(String[] args) {
		SpringApplication.run(AppStarter.class, args);
	}
}
