package com.pyyh.ms.manager.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pyyh.ms.manager.business.pojos.UserRolePojo;

@Repository
public interface IUserRoleDao {
	public void userRoleAdd(UserRolePojo userRolePojo);
	public int userRoleExists(UserRolePojo userRolePojo);
	public void userRoleDelete(UserRolePojo userRolePojo);
	public List<UserRolePojo> userRoleFind(UserRolePojo userRolePojo);
	public int userRoleCount(UserRolePojo userRolePojo);
}
