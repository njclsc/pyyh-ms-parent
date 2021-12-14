package com.pyyh.ms.manager.business.dao;

import org.springframework.stereotype.Repository;

import com.pyyh.ms.manager.business.pojos.UserPojo;

@Repository
public interface IUserDao {

	public void userAdd(UserPojo user);
	public int userExists(UserPojo user);
	public void userDelete(UserPojo user);
}
