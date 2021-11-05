package com.pyyh.ms.login.business.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.pyyh.ms.login.pojos.UserPojo;

public interface ILoginService {
	public String check(UserPojo user);
}
