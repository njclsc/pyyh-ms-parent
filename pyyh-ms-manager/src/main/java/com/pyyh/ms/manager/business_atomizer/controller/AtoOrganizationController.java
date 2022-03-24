package com.pyyh.ms.manager.business_atomizer.controller;

import javax.servlet.http.HttpServletRequest;

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
	public String organizationAdd(@RequestBody OrganizationPojo organizationPojo, HttpServletRequest req){
		return atoOrgService.organizationAdd(organizationPojo, req);
	}
	@RequestMapping("delete")
	public String organizationDelete(@RequestBody OrganizationPojo organizationPojo, HttpServletRequest req){
		return atoOrgService.organizationDelete(organizationPojo, req);
	}
	@RequestMapping("update")
	public String organizationUpdate(@RequestBody OrganizationPojo organizationPojo, HttpServletRequest req){
		return atoOrgService.organizationUpdate(organizationPojo, req);
	}
	@RequestMapping("find")
	public String organizationFind(@RequestBody OrganizationPojo organizationPojo, HttpServletRequest req){
		return atoOrgService.organizationFind(organizationPojo, req);
	}
}
