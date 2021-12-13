package com.pyyh.ms.login.business.service;

import javax.servlet.http.HttpServletResponse;

import com.pyyh.ms.login.pojos.UserPojo;

public interface ILoginService {
	public String check(UserPojo user, HttpServletResponse request);
}
