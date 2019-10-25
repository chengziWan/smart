package com.suresec.smart.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suresec.smart.commom.api.ReturnMessage;
import com.suresec.smart.entity.commom.Sys_menus;
import com.suresec.smart.entity.commom.Sys_users;
import com.suresec.smart.service.LoginService;
import com.suresec.smart.util.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author wcc
 * @time 2019-10-17 11:17
 * @description 登录验证管理
 */
//@RestController
//@Api(tags = "LoginController", description = "登录验证管理")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/prod-api/user/login", method = RequestMethod.POST)
	@ApiOperation("登录")
	public ReturnMessage login(HttpServletRequest request,@RequestBody Sys_users user) {
		String username = user.getUsername();
		String password = user.getPassword(); 
		// 登录认证，认证成功后将用户信息放到session中
		HttpSession session = request.getSession();
		if (username.equals("admin") && password.equals("111111")) {
			String token = session.getId();
			session.setAttribute("userInfo", username);
			session.setAttribute("token", token);
			session.setMaxInactiveInterval(60*30);
			Map<String, Object> mp = new HashMap<String, Object>();
			mp.put("token", token);
			return ResultUtil.success(mp);
		} else {
			return ResultUtil.success("error");
		}
		
	}
	//user/resetToken
	@RequestMapping(value = "/prod-api/user/info", method = RequestMethod.GET)
	@ApiOperation("获取用户信息")
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
	@RequestMapping(value = "/prod-api/menuManage/getMenuByRole", method = RequestMethod.GET)
	@ApiOperation("根据roles权限生成可访问的路由表")
	public ReturnMessage getMenuByRole(HttpServletRequest request,@RequestParam(name = "role") String role) {
		System.out.println("role="+role);
		List<Sys_menus> list = loginService.getMenuByRole(role);
		return ResultUtil.success(list);
	}

	@RequestMapping(value = "/prod-api/user/logout", method = RequestMethod.POST)
	@ApiOperation("注销")
	public ReturnMessage logout(HttpServletRequest request) {
		String info = "登出操作";
		HttpSession session = request.getSession();
		// 将用户信息从session中删除
		session.removeAttribute("userInfo");
		session.removeAttribute("token");
		Object userInfo = session.getAttribute("userInfo");
		if (userInfo == null) {
			info = "登出成功";
		} else {
			info = "登出失败";
		}
		return ResultUtil.success("success");
	}

}
