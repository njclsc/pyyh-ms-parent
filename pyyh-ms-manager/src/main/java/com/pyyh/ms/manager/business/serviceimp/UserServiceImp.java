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
		ResponsePojo rp = new ResponsePojo();
		if(userDao.userExists(user) == 0){
			userDao.userAdd(user);
			rp.setState("success");
			rp.setMessage("账号添加成功!");
		}else{
			rp.setState("fail");
			rp.setMessage("账号以存在!");
		}
		return JSONObject.toJSONString(rp);
	}
	@Override
	public String userDelete(UserPojo user) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		userDao.userDelete(user);
		rp.setState("success");
		rp.setMessage("账号已删除!");
		return JSONObject.toJSONString(rp);
	}
	@Override
	public String userUpdate(UserPojo user) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		UserPojo user1 = userDao.userFind(user).get(0);
		if(user1.getPassword().equals(user.getPassword()) && user.getNewPassword().equals(user.getConfirmPassword())){
			userDao.userUpdate(user);
			rp.setState("success");
			rp.setMessage("账号修改成功!");
		}else{
			rp.setState("fail");
			rp.setMessage("账号修改失败!");
		}
		return JSONObject.toJSONString(rp);
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
