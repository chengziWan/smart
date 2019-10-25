package com.suresec.system.service;

import java.util.List;

import com.suresec.system.entity.Sys_menus;

/**
 * 
 * @author wcc
 * @time 2019-10-10 14:03
 * @description
 */
public interface LoginService {
	public List<Sys_menus> getMenuByRole(String role);
}
