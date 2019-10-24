package com.suresec.smart.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.suresec.smart.dao.Sys_menusDao;
import com.suresec.smart.entity.commom.Sys_menus;
import com.suresec.smart.service.LoginService;
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
