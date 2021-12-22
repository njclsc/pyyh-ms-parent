package com.pyyh.ms.manager.business.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.ms.manager.business.dao.IUserRoleDao;
import com.pyyh.ms.manager.business.pojos.UserRolePojo;
import com.pyyh.ms.manager.business.service.IUserRoleService;
import com.pyyh.ms.manager.pojos.ResponsePojo;
@Service("UserRoleServiceImp")
public class UserRoleServiceImp implements IUserRoleService{
	@Autowired
	private IUserRoleDao userRoleDao;
	@Override
	public String userRoleAdd(UserRolePojo userRolePojo) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		if(userRoleDao.userRoleExists(userRolePojo) == 0){
			userRoleDao.userRoleAdd(userRolePojo);
			rp.setState("success");
			rp.setMessage("账号角色关系添加成功!");
		}else{
			rp.setState("fail");
			rp.setMessage("账号角色关系以存在!");
		}
		return JSONObject.toJSONString(rp);
	}
	@Override
	public String userRoleDelete(UserRolePojo userRolePojo) {
		// TODO Auto-generated method stub
		userRoleDao.userRoleDelete(userRolePojo);
		ResponsePojo rp = new ResponsePojo();
		rp.setState("success");
		rp.setMessage("用户角色关系已解除!");
		return JSONObject.toJSONString(rp);
	}

}
