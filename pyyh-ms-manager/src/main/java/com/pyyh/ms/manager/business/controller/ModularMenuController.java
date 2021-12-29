package com.pyyh.ms.manager.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyyh.ms.manager.business.pojos.ModularMenuPojo;
import com.pyyh.ms.manager.business.service.IModularMenuService;

@RestController
@RequestMapping("/modularMenu")
public class ModularMenuController {
	@Autowired
	@Qualifier("ModularMenuServiceImp")
	private IModularMenuService modularMenuService;
	@RequestMapping("load")
	public String modularMenuLoad(@RequestBody ModularMenuPojo mmp){
		return modularMenuService.modularMenuLoad(mmp);
	}
	@RequestMapping("add")
	public String modularMenuAdd(@RequestBody ModularMenuPojo mmp){
		return modularMenuService.modularMenuAdd(mmp);
	}
}
