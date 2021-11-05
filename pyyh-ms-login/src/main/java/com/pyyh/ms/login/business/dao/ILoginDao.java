package com.pyyh.ms.login.business.dao;

import org.springframework.stereotype.Repository;

import com.pyyh.ms.login.pojos.UserPojo;

@Repository
public interface ILoginDao {
	
	public UserPojo findUser(UserPojo user);
}
