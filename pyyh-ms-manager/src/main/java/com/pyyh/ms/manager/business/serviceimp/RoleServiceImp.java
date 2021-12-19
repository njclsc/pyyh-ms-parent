package com.pyyh.ms.manager.business.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.ms.manager.business.dao.IRoleDao;
import com.pyyh.ms.manager.business.pojos.RolePojo;
import com.pyyh.ms.manager.business.service.IRoleService;
import com.pyyh.ms.manager.pojos.ResponsePojo;

@Service("RoleServiceImp")
public class RoleServiceImp implements IRoleService{
	@Autowired
	private IRoleDao roleDao;
	@Override
	public String roleAdd(RolePojo role) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		if(roleDao.roleExists(role) == 0){
			roleDao.roleAdd(role);
			rp.setMessage("角色添加成功!");
			rp.setState("success");
		}else{
			rp.setMessage("角色已经存在!");
			rp.setState("fail");
		}
		return JSONObject.toJSONString(rp);
	}
	@Override
	public String roleDelete(RolePojo role) {
		// TODO Auto-generated method stub
		roleDao.roleDelete(role);
		ResponsePojo rp = new ResponsePojo();
		rp.setState("success");
		rp.setMessage("角色已删除!");
		return JSONObject.toJSONString(rp);
	}

}
