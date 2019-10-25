package com.suresec.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.suresec.system.dao.Sys_menusDao;
import com.suresec.system.entity.Sys_menus;
import com.suresec.system.service.LoginService;
/**
 * 
 * @author wcc
 * @time 2019-10-10 14:04
 * @description
 */

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
    private Sys_menusDao sys_menusDao;

	public List<Sys_menus> getMenuByRole(String role) {
		// TODO Auto-generated method stub

		Iterable<Sys_menus> m = sys_menusDao.findByParentId("#");
		List li = Lists.newArrayList(m);
		return li;
	}
	

}
