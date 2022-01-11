package com.pyyh.ms.manager.business.service;

import javax.servlet.http.HttpServletRequest;

import com.pyyh.ms.manager.business.pojos.ModularMenuRolePojo;

public interface IModularMenuRoleService {

	public String modularMenuRoleAdd(ModularMenuRolePojo mmp);
	public String modularMenuRoleDelete(ModularMenuRolePojo mmp);
	public String modularMenuRoleLoad(HttpServletRequest request);
}
