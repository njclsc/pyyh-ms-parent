package com.pyyh.ms.manager.business.service;

import java.util.List;

import com.pyyh.ms.manager.business.pojos.RolePojo;

public interface IRoleService {
	public String roleAdd(RolePojo role);
	public String roleDelete(RolePojo role);
	public String roleUpdate(RolePojo role);
	public String roleFind(RolePojo role);
}
