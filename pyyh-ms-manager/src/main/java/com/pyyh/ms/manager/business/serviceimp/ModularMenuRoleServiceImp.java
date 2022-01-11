package com.pyyh.ms.manager.business.serviceimp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.ms.manager.business.dao.IModularMenuRoleDao;
import com.pyyh.ms.manager.business.dao.IUserDao;
import com.pyyh.ms.manager.business.pojos.ModularMenuRolePojo;
import com.pyyh.ms.manager.business.pojos.UserPojo;
import com.pyyh.ms.manager.business.service.IModularMenuRoleService;
import com.pyyh.ms.manager.configer.ProjectConfig;
import com.pyyh.ms.manager.pojos.ResponsePojo;

@Service("ModularMenuRoleServiceImp")
public class ModularMenuRoleServiceImp implements IModularMenuRoleService{
	@Autowired
	private IModularMenuRoleDao mmrDao;
	@Autowired
	private IUserDao userDao;
	@Override
	public String modularMenuRoleAdd(ModularMenuRolePojo mmp) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		if(mmrDao.modularMenuRoleExists(mmp) == 0){
			mmrDao.modularMenuRoleAdd(mmp);
			rp.setState("success");
			rp.setMessage("模块菜单与角色关系添加成功!");
		}else{
			rp.setState("fail");
			rp.setMessage("模块菜单与角色关系以存在!");
		}
		return JSONObject.toJSONString(rp);
	}
	@Override
	public String modularMenuRoleDelete(ModularMenuRolePojo mmp) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		mmrDao.modularMenuRoleDelete(mmp);
		rp.setState("success");
		rp.setMessage("模块菜单与角色关系删除成功!");
		return JSONObject.toJSONString(rp);
	}
	@Override
	public String modularMenuRoleLoad(HttpServletRequest request) {
		// TODO Auto-generated method stub
		//获取用户角色
		String info = ProjectConfig.tokenOperate(2, request.getHeader("jwtToken"));
		JSONObject json = JSONObject.parseObject(info);
		UserPojo user = new UserPojo();
		user.setAccount(json.getString("account"));
		user.setOrganizationCode(json.getString("organizationCode"));
		List<UserPojo> users = userDao.userFind(user);
		UserPojo _up = users.get(0);
		System.out.println(_up.getId());
		return null;
	}

}
