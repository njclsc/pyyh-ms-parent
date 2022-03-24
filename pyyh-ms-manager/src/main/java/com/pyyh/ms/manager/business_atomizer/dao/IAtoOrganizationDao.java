package com.pyyh.ms.manager.business_atomizer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pyyh.ms.manager.business.pojos.OrganizationPojo;
import com.pyyh.ms.manager.business.pojos.UserPojo;

@Repository
public interface IAtoOrganizationDao {
	public int organizationExists(OrganizationPojo organizationPojo);
	public void organizationAdd(OrganizationPojo organizationPojo);
	public void organizationDelete(OrganizationPojo organizationPojo);
	public void organizationUpdate(OrganizationPojo organizationPojo);
	public List<OrganizationPojo> organizationFind(OrganizationPojo organizationPojo);
	public int organizationCount(OrganizationPojo organizationPojo);
}
