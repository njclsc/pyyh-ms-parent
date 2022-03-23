package com.pyyh.ms.manager.business_atomizer.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pyyh.ms.manager.business.pojos.OrganizationPojo;
import com.pyyh.ms.manager.business_atomizer.dao.IAtoOrganizationDao;
import com.pyyh.ms.manager.business_atomizer.service.IAtoOrganizationManagerService;

@Service("AtoOrganizationManagerServiceImp")
public class AtoOrganizationManagerServiceImp implements IAtoOrganizationManagerService	{
	@Autowired
	private IAtoOrganizationDao atoOrgDao;
	@Override
	public String organizationAdd(OrganizationPojo organizationPojo) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
