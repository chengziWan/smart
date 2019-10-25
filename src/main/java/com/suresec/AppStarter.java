package com.suresec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * 
 * @author wcc
 * @time 2019-10-14 14:02
 * @description 
 */
@EnableTransactionManagement//spring Boot 使用事务非常简单，首先使用注解 @EnableTransactionManagement 开启事务支持后，然后在访问数据库的Service方法上添加注解 @Transactional 便可
@SpringBootApplication
public class AppStarter {
	public static void main(String[] args) {
		SpringApplication.run(AppStarter.class, args);
	}
}
