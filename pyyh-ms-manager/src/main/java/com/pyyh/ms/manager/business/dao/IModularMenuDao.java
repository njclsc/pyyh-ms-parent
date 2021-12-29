package com.pyyh.ms.manager.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pyyh.ms.manager.business.pojos.ModularMenuPojo;
import com.pyyh.ms.manager.business.pojos.OrganizationPojo;

@Repository
public interface IModularMenuDao {
	
	public List<ModularMenuPojo> modularMenuFind(ModularMenuPojo mmp);
	public int modularMenuExists(ModularMenuPojo mmp);
	public void modularMenuAdd(ModularMenuPojo mmp);
}
