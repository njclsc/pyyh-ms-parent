package com.pyyh.ms.manager.business_atomizer.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyyh.ms.manager.business.pojos.OrganizationPojo;

@RestController
@RequestMapping("/atomizer/organization/")
public class AtoOrganizationController {
	
	@RequestMapping("add")
	public String organizationAdd(@RequestBody OrganizationPojo organizationPojo){
		System.out.println("------->>> orgadd");
		return "";
	}
}
