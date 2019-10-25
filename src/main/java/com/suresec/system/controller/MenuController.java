package com.suresec.system.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suresec.system.commom.api.ReturnMessage;
import com.suresec.system.entity.Sys_menus;
import com.suresec.system.service.LoginService;
import com.suresec.system.util.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author wcc
 * @time 2019-10-25 10:28
 * @description  菜单管理
 */
@RestController
@Api(tags = "MenuController", description = "菜单管理")
public class MenuController {
	@Autowired
	private LoginService loginService;
	

	@RequestMapping(value = "/prod-api/menuManage/getMenuByRole", method = RequestMethod.GET)
	@ApiOperation("根据role查询可访问的路由表")
	public ReturnMessage getMenuByRole(HttpServletRequest request,@RequestParam(name = "role") String role) {
		List<Sys_menus> list = loginService.getMenuByRole(role);
		return ResultUtil.success(list);
	}
	
	@RequestMapping(value = "/prod-api/menuManage/getTree", method = RequestMethod.GET)
	@ApiOperation("获取菜单树形结构")
	public ReturnMessage info(HttpServletRequest request) {
		//根据token获取用户信息
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("userInfo");
		System.out.println("username="+username);
		Map<String, Object> mp = new HashMap<String, Object>();
		// roles, name, avatar, introduction
		mp.put("roles", new String[] { "admin", "visitor" });
		mp.put("name", "cc");
		mp.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
		mp.put("introduction", "introduction");
		return ResultUtil.success(mp);
	}

	@RequestMapping(value = "/prod-api/menuManage/list", method = RequestMethod.GET)
	@ApiOperation("菜单查询列表")
	public ReturnMessage logout(HttpServletRequest request) {
		
		return ResultUtil.success("success");
	}

}
