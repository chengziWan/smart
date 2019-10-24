package com.suresec.smart.controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suresec.smart.commom.api.ReturnMessage;
import com.suresec.smart.entity.commom.Sys_menus;
import com.suresec.smart.entity.commom.Sys_roles_menus;
import com.suresec.smart.entity.commom.Sys_users;
import com.suresec.smart.entity.commom.Sys_users_roles;
import com.suresec.smart.service.LoginService;
import com.suresec.smart.util.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author wcc
 * @time 2019-10-17 11:17
 * @description ��¼��֤����
 */
@RestController
@Api(tags = "LoginController", description = "��¼��֤����")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/prod-api/user/login", method = RequestMethod.POST)
	@ApiOperation("��¼")
	public ReturnMessage login(HttpServletRequest request,@RequestBody Sys_users user) {
		String username = user.getUsername();
		String password = user.getPassword(); 
		// ��¼��֤����֤�ɹ����û���Ϣ�ŵ�session��
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
	@ApiOperation("��ȡ�û���Ϣ")
	public ReturnMessage info(HttpServletRequest request) {
		//����token��ȡ�û���Ϣ
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
	@ApiOperation("����rolesȨ�����ɿɷ��ʵ�·�ɱ�")
	public ReturnMessage getMenuByRole(HttpServletRequest request,@RequestParam(name = "role") String role) {
		System.out.println("role="+role);
		List<Sys_menus> list = loginService.getMenuByRole(role);
		return ResultUtil.success(list);
	}

	@RequestMapping(value = "/prod-api/user/logout", method = RequestMethod.POST)
	@ApiOperation("ע��")
	public ReturnMessage logout(HttpServletRequest request) {
		String info = "�ǳ�����";
		HttpSession session = request.getSession();
		// ���û���Ϣ��session��ɾ��
		session.removeAttribute("userInfo");
		session.removeAttribute("token");
		Object userInfo = session.getAttribute("userInfo");
		if (userInfo == null) {
			info = "�ǳ��ɹ�";
		} else {
			info = "�ǳ�ʧ��";
		}
		return ResultUtil.success("success");
	}

}
