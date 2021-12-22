package com.pyyh.ms.manager.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pyyh.ms.manager.business.pojos.RolePojo;

@Repository
public interface IRoleDao {
	public void roleAdd(RolePojo role);
	public int roleExists(RolePojo role);
	public void roleDelete(RolePojo role);
	public void roleUpdate(RolePojo role);
	public List<RolePojo> roleFind(RolePojo role);
	public int roleCount(RolePojo role);
}
