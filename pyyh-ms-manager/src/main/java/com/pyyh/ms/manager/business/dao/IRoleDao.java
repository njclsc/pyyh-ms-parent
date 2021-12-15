package com.pyyh.ms.manager.business.dao;

import org.springframework.stereotype.Repository;

import com.pyyh.ms.manager.business.pojos.RolePojo;

@Repository
public interface IRoleDao {
	public void userRole(RolePojo user);
}
