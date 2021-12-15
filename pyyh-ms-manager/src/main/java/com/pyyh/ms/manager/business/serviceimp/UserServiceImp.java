package com.pyyh.ms.manager.business.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.ms.manager.business.dao.IUserDao;
import com.pyyh.ms.manager.business.pojos.UserPojo;
import com.pyyh.ms.manager.business.service.IUserService;
import com.pyyh.ms.manager.pojos.ResponsePojo;

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
	@Override
	public String userUpdate(UserPojo user) {
		// TODO Auto-generated method stub
		userDao.userUpdate(user);
		return null;
	}
	@Override
	public String userFind(UserPojo user) {
		// TODO Auto-generated method stub
		int page = user.getPage();
		int rows = user.getRows();
		int begin = (page - 1) * rows;
		user.setBegin(begin);
		int total = userDao.userCount(user);
		List<UserPojo> users = userDao.userFind(user);
		ResponsePojo rp = new ResponsePojo();
		rp.setState("success");
		rp.setTotal(total);
		rp.setResultData(users);
		return JSONObject.toJSONString(rp);
	}

}
