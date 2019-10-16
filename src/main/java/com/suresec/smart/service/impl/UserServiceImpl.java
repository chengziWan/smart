package com.suresec.smart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suresec.smart.dao.UserDao;
import com.suresec.smart.entity.Sys_users;
import com.suresec.smart.service.UserService;
/**
 * 
 * @author wcc
 * @time 2019-10-10 14:04
 * @description
 */

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private UserDao userDao;
	/**
	 * ͨ��id��ѯ�û�
	 */
	public Sys_users getUser(String id) {
		// �����ַ�ʽ��
		// 1.����crudRepository�Ľӿ�
//		System.out.println(userDao.findById(id).toString());
		// 2.���������Լ�д�Ľӿ�
		System.out.println(userDao.getUser(id).toString());
		return userDao.getUser(id);
	}
	/**
	 * 
	 * @author wcc
	 * @time 2019-10-14 14:25
	 * @description ����
	 */
	@Transactional
	public Sys_users insertUser(Sys_users user) {
		System.out.println("11111111");
		userDao.save(user);
		Sys_users user2 = new Sys_users();
        user.setId("4");
        user.setName("cc");
        user.setCompanyid("1001");
        user.setPwd("123456");
        user.setStatus("022");
        userDao.save(user2);
		System.out.println("2222222222");
		return userDao.getUser(user.getId());
	}

}
