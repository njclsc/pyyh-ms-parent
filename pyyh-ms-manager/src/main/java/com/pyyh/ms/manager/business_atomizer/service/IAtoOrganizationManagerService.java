package com.pyyh.ms.manager.business_atomizer.service;

import javax.servlet.http.HttpServletRequest;

import com.pyyh.ms.manager.business.pojos.OrganizationPojo;

public interface IAtoOrganizationManagerService {

	public String organizationAdd(OrganizationPojo organizationPojo, HttpServletRequest req);
	public String organizationDelete(OrganizationPojo organizationPojo, HttpServletRequest req);
	public String organizationUpdate(OrganizationPojo organizationPojo, HttpServletRequest req);
	public String organizationFind(OrganizationPojo organizationPojo, HttpServletRequest req);
}
