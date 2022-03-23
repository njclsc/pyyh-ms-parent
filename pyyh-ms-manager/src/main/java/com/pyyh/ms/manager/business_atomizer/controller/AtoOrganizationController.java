package com.pyyh.ms.manager.business_atomizer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyyh.ms.manager.business.pojos.OrganizationPojo;
import com.pyyh.ms.manager.business_atomizer.service.IAtoOrganizationManagerService;

@RestController
@RequestMapping("/atomizer/organization/")
public class AtoOrganizationController {
	@Autowired
	@Qualifier("AtoOrganizationManagerServiceImp")
	private IAtoOrganizationManagerService atoOrgService;
	@RequestMapping("add")
	public String organizationAdd(@RequestBody OrganizationPojo organizationPojo){
		return atoOrgService.organizationAdd(organizationPojo);
	}
	@RequestMapping("delete")
	public String organizationDelete(@RequestBody OrganizationPojo organizationPojo){
		return "";
	}
	@RequestMapping("update")
	public String organizationUpdate(@RequestBody OrganizationPojo organizationPojo){
		return "";
	}
	@RequestMapping("find")
	public String organizationFind(@RequestBody OrganizationPojo organizationPojo){
		return "";
	}
}
