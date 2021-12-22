package com.pyyh.ms.manager.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyyh.ms.manager.business.pojos.RolePojo;
import com.pyyh.ms.manager.business.service.IRoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	@Autowired
	@Qualifier("RoleServiceImp")
	private IRoleService roleService;
	
	@RequestMapping("add")
	public String roleAdd(@RequestBody RolePojo role){
		return roleService.roleAdd(role);
	}
	@RequestMapping("delete")
	public String roleDelete(@RequestBody RolePojo role){
		return roleService.roleDelete(role);
	}
	@RequestMapping("update")
	public String roleUpdate(@RequestBody RolePojo role){
		return roleService.roleUpdate(role);
	}
	@RequestMapping("find")
	public String roleFind(@RequestBody RolePojo role){
		return roleService.roleFind(role);
	}
}
