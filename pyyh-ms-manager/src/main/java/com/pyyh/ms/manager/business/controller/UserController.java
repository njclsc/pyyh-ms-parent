package com.pyyh.ms.manager.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyyh.ms.manager.business.pojos.UserPojo;
import com.pyyh.ms.manager.business.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	@Qualifier("UserServiceImp")
	private IUserService userService;
	@RequestMapping("add")
	public String userAdd(@RequestBody UserPojo user){
		return userService.userAdd(user);
	}
	@RequestMapping("delete")
	public String userdelete(@RequestBody UserPojo user){
		return userService.userDelete(user);
	}
}
