package com.suresec.smart.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suresec.smart.entity.ReturnMessage;
import com.suresec.smart.util.ResultUtil;

/**
 * 
 * @author wcc
 * @time 2019-09-29 09:52
 * @description ≤‚ ‘
 */
@RestController
public class FirstController {
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("hello");
		return "hello";
	}
	@RequestMapping("/prod-api/user/login")
	public ReturnMessage login() {
		System.out.println("hello");
		return ResultUtil.success("success");
	}
	@RequestMapping("/prod-api/user/info")
	public ReturnMessage info() {
		System.out.println("hello");
		Map<String,Object> mp = new HashMap<String, Object>();
		//roles, name, avatar, introduction
		mp.put("roles", new String[] {"admin","visitor"});
		mp.put("name", "cc");
		mp.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
		mp.put("introduction","introduction");
		return ResultUtil.success(mp);
	}

}
