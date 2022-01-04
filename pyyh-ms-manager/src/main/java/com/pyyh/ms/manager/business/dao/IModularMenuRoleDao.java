package com.pyyh.ms.manager.business.dao;

import org.springframework.stereotype.Repository;

import com.pyyh.ms.manager.business.pojos.ModularMenuRolePojo;
@Repository
public interface IModularMenuRoleDao {
	public void modularMenuRoleAdd(ModularMenuRolePojo mmp);
	public void modularMenuRoleDelete(ModularMenuRolePojo mmp);
	public void modularMenuRoleUpdate(ModularMenuRolePojo mmp);
	public void modularMenuRoleFind(ModularMenuRolePojo mmp);
	public int modularMenuRoleExists(ModularMenuRolePojo mmp);
}
