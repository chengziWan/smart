package com.suresec.smart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
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
