package com.pyyh.ms.login.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pyyh.ms.login.pojos.UserPojo;

@Repository
public interface ILoginDao {
	
	public List<UserPojo> findUser(UserPojo user);
}
