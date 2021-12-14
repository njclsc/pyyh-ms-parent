package com.pyyh.ms.manager.business.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pyyh.ms.manager.business.dao.IUserDao;
import com.pyyh.ms.manager.business.pojos.UserPojo;
import com.pyyh.ms.manager.business.service.IUserService;

@Service("UserServiceImp")
public class UserServiceImp implements IUserService{
	@Autowired
	private IUserDao userDao;
	@Override
	public String userAdd(UserPojo user) {
		// TODO Auto-generated method stub
		System.out.println(user.getId());
		if(userDao.userExists(user) == 0){
			userDao.userAdd(user);
		}else{
			System.out.println("xxccc");
		}
		System.out.println(user.getId());
		return null;
	}
	@Override
	public String userDelete(UserPojo user) {
		// TODO Auto-generated method stub
		userDao.userDelete(user);
		return null;
	}

}
