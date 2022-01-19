package com.pyyh.ms.manager.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pyyh.ms.manager.business.pojos.ModularMenuPojo;
import com.pyyh.ms.manager.business.pojos.ModularMenuRolePojo;
@Repository
public interface IModularMenuRoleDao {
	public void modularMenuRoleAdd(ModularMenuRolePojo mmp);
	public void modularMenuRoleDelete(ModularMenuRolePojo mmp);
	public List<ModularMenuPojo> modularMenuRoleFind(ModularMenuRolePojo mmp);
	public int modularMenuRoleExists(ModularMenuRolePojo mmp);
	public List<ModularMenuPojo> modularMenuFind(ModularMenuPojo mmp);
}
