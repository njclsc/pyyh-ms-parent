package com.pyyh.ms.manager.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyyh.ms.manager.business.pojos.ModularMenuRolePojo;
import com.pyyh.ms.manager.business.service.IModularMenuRoleService;

@RestController
@RequestMapping("/modularMenuRole")
public class ModularMenuRoleController {
	@Autowired
	@Qualifier("ModularMenuRoleServiceImp")
	private IModularMenuRoleService mmrService;
	
	@RequestMapping("add")
	public String modularMenuRoleAdd(@RequestBody ModularMenuRolePojo mmp){
		return mmrService.modularMenuRoleAdd(mmp);
	}
}
