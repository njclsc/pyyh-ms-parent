package com.pyyh.ms.manager.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pyyh.ms.manager.business.pojos.UserPojo;

@Repository
public interface IUserDao {

	public void userAdd(UserPojo user);
	public int userExists(UserPojo user);
	public void userDelete(UserPojo user);
	public void userUpdate(UserPojo user);
	public List<UserPojo> userFind(UserPojo user);
	public int userCount(UserPojo user);
}
