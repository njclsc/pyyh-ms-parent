package com.pyyh.ms.manager.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyyh.ms.manager.business.pojos.OrganizationPojo;
import com.pyyh.ms.manager.business.service.IOrganizationService;

@RestController
@RequestMapping("/organization")
public class OrganizationController {
	@Autowired
	@Qualifier("OrganizationServiceImp")
	private IOrganizationService organizationService;
	@RequestMapping("add")
	public String organizationAdd(@RequestBody OrganizationPojo organizationPojo){
		return organizationService.organizationAdd(organizationPojo);
	}
	@RequestMapping("delete")
	public String organizationDelete(@RequestBody OrganizationPojo organizationPojo){
		return organizationService.organizationDelete(organizationPojo);
	}
	@RequestMapping("update")
	public String organizationUpdate(@RequestBody OrganizationPojo organizationPojo){
		return organizationService.organizationUpdate(organizationPojo);
	}
	@RequestMapping("find")
	public String organizationFind(@RequestBody OrganizationPojo organizationPojo){
		return organizationService.organizationFind(organizationPojo);
	}
}
