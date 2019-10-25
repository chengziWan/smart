package com.suresec.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suresec.system.dao.Sys_usersDao;
import com.suresec.system.entity.Sys_users;
import com.suresec.system.service.UserService;
/**
 * 
 * @author wcc
 * @time 2019-10-10 14:04
 * @description
 */

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private Sys_usersDao userDao;
	/**
	 * 通过id查询用户
	 */
	public Sys_users getUser(String id) {
		// 有两种方式：
		// 1.调用crudRepository的接口
//		System.out.println(userDao.findById(id).toString());
		// 2.调用我们自己写的接口
		System.out.println(userDao.getUser(id).toString());
		return userDao.getUser(id);
	}
	/**
	 * 
	 * @author wcc
	 * @time 2019-10-14 14:25
	 * @description 插入
	 */
	@Transactional
	public Sys_users insertUser(Sys_users user) {
		System.out.println("11111111");
		userDao.save(user);
		Sys_users user2 = new Sys_users();
        user.setUsername("4");
        user.setName("cc");
        user.setCompanyid("1001");
        user.setPassword("123456");
        user.setStatus("022");
        userDao.save(user2);
		System.out.println("2222222222");
		return userDao.getUser(user.getUsername());
	}

}
