package com.pyyh.ms.manager.business.service;

import java.util.List;

import com.pyyh.ms.manager.business.pojos.UserPojo;

public interface IUserService {
	public String userAdd(UserPojo user);
	public String userDelete(UserPojo user);
	public String userUpdate(UserPojo user);
	public String userFind(UserPojo user);
}
