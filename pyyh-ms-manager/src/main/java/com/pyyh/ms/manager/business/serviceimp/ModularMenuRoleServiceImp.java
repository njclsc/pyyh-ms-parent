package com.pyyh.ms.manager.business.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.ms.manager.business.dao.IModularMenuRoleDao;
import com.pyyh.ms.manager.business.pojos.ModularMenuRolePojo;
import com.pyyh.ms.manager.business.service.IModularMenuRoleService;
import com.pyyh.ms.manager.pojos.ResponsePojo;

@Service("ModularMenuRoleServiceImp")
public class ModularMenuRoleServiceImp implements IModularMenuRoleService{
	@Autowired
	private IModularMenuRoleDao mmrDao;
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

}
