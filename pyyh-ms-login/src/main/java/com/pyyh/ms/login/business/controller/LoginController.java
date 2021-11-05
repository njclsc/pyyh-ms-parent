package com.pyyh.ms.login.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyyh.ms.login.business.service.ILoginService;
import com.pyyh.ms.login.pojos.UserPojo;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	@Qualifier("LoginServiceImp")
	private ILoginService loginService;
	@RequestMapping("check")
	public String check(@RequestBody UserPojo user){
		return loginService.check(user);
	}
}
