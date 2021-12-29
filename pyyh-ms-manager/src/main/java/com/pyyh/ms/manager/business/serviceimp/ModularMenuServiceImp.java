package com.pyyh.ms.manager.business.serviceimp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.ms.manager.business.dao.IModularMenuDao;
import com.pyyh.ms.manager.business.pojos.ModularMenuPojo;
import com.pyyh.ms.manager.business.service.IModularMenuService;
import com.pyyh.ms.manager.pojos.ResponsePojo;

@Service("ModularMenuServiceImp")
public class ModularMenuServiceImp implements IModularMenuService{
	@Autowired
	private IModularMenuDao mmDao;
	@Override
	public String modularMenuLoad(ModularMenuPojo mmp) {
		// TODO Auto-generated method stub
		List<ModularMenuPojo> rootMenu = mmDao.modularMenuFind(mmp);
		for(ModularMenuPojo _mmp : rootMenu){
			loadModular(_mmp);
		}
		ResponsePojo rp = new ResponsePojo();
		rp.setState("success");
		rp.setResultData(rootMenu);
		return JSONObject.toJSONString(rp);
	}

	private void loadModular(ModularMenuPojo mmp){
		ModularMenuPojo mmp1 = new ModularMenuPojo();
		mmp1.setParentId(mmp.getId());
		mmp1.setModularLevel(mmp.getModularLevel() + 1);
		System.out.println(mmp1.getParentId() + "    " + mmp1.getModularLevel());
		mmp.setChildren(new ArrayList<ModularMenuPojo>());
		List<ModularMenuPojo> rmmp = mmDao.modularMenuFind(mmp1);
		for(ModularMenuPojo _mmp : rmmp){
			mmp.getChildren().add(_mmp);
			loadModular(_mmp);
		}
//		ResponsePojo rp = new ResponsePojo();
		
	}
	@Override
	public String modularMenuAdd(ModularMenuPojo mmp) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		if(mmDao.modularMenuExists(mmp) == 0){
			mmDao.modularMenuAdd(mmp);
			System.out.println(mmp.getId());
			rp.setState("success");
			rp.setMessage("模块菜单添加成功!");
		}else{
			rp.setState("fail");
			rp.setMessage("模块菜单以存在!");
		}
		return JSONObject.toJSONString(rp);

	}
}
