package com.suresec.smart.service;

import com.suresec.smart.entity.Sys_users;

/**
 * 
 * @author wcc
 * @time 2019-10-10 14:03
 * @description
 */
public interface UserService {
	public Sys_users getUser(String id);
	public Sys_users insertUser(Sys_users user);
}
