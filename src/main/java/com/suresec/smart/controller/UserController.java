package com.suresec.smart.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suresec.smart.entity.Sys_users;
import com.suresec.smart.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
    private UserService userService;

	@RequestMapping("/login")
    public Map<String, Object> login() {
        Sys_users user = new Sys_users();
        user.setId("3");
        user.setName("cc");
        user.setCompanyid("1001");
        user.setPwd("123456");
        user.setStatus("0");
		userService.insertUser(user);
		//userService.getUser("1");
        return null;
    }
//	@RequestMapping("/getUser/{id}")
//    public User getUser(@PathVariable("id") Integer id){
//        
//        return service.getUser(id);
//    }
}
