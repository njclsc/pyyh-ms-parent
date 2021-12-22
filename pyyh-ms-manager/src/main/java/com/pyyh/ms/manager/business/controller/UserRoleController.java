package com.pyyh.ms.manager.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyyh.ms.manager.business.pojos.UserRolePojo;
import com.pyyh.ms.manager.business.service.IUserRoleService;

@RestController
@RequestMapping("/userRole")
public class UserRoleController {
	@Autowired
	@Qualifier("UserRoleServiceImp")
	private IUserRoleService userRoleService;
	@RequestMapping("add")
	public String userRoleAdd(@RequestBody UserRolePojo userRolePojo){
		return userRoleService.userRoleAdd(userRolePojo);
	}
	@RequestMapping("delete")
	public String userRoleDelete(@RequestBody UserRolePojo userRolePojo){
		return userRoleService.userRoleDelete(userRolePojo);
	}
}
