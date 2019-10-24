package com.suresec.smart.service;

import java.util.List;

import com.suresec.smart.entity.commom.Sys_menus;

/**
 * 
 * @author wcc
 * @time 2019-10-10 14:03
 * @description
 */
public interface LoginService {
	public List<Sys_menus> getMenuByRole(String role);
}
