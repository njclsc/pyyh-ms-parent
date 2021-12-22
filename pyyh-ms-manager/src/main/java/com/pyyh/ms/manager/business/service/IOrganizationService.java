package com.pyyh.ms.manager.business.service;

import com.pyyh.ms.manager.business.pojos.OrganizationPojo;

public interface IOrganizationService {
	public String organizationAdd(OrganizationPojo organizationPojo);
	public String organizationDelete(OrganizationPojo organizationPojo);
	public String organizationUpdate(OrganizationPojo organizationPojo);
	public String organizationFind(OrganizationPojo organizationPojo);
}
