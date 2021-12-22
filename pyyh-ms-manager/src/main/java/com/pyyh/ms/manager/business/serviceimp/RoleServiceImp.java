package com.pyyh.ms.manager.business.serviceimp;

import java.util.List;

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
	@Override
	public String roleUpdate(RolePojo role) {
		// TODO Auto-generated method stub
		roleDao.roleUpdate(role);
		ResponsePojo rp = new ResponsePojo();
		rp.setState("success");
		rp.setMessage("角色修改成功!");
		return JSONObject.toJSONString(rp);
	}
	@Override
	public String roleFind(RolePojo role) {
		// TODO Auto-generated method stub
		int page = role.getPage();
		int rows = role.getRows();
		int begin = (page - 1) * rows;
		role.setBegin(begin);
		int total = roleDao.roleCount(role);
		List<RolePojo> roles = roleDao.roleFind(role);
		ResponsePojo rp = new ResponsePojo();
		rp.setState("success");
		rp.setTotal(total);
		rp.setResultData(roles);
		return JSONObject.toJSONString(rp);
	}

}
