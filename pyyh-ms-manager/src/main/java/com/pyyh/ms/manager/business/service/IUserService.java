package com.pyyh.ms.manager.business.service;

import com.pyyh.ms.manager.business.pojos.UserPojo;

public interface IUserService {
	public String userAdd(UserPojo user);
	public String userDelete(UserPojo user);
}
