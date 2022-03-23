package com.pyyh.ms.manager.business_atomizer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pyyh.ms.manager.business.pojos.UserPojo;

@Repository
public interface IAtoOrganizationDao {
	public List<UserPojo> roleFind(UserPojo UserPojo);
}
