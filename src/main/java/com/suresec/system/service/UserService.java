package com.suresec.system.service;

import com.suresec.system.entity.Sys_users;

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
