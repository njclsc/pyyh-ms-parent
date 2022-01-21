package com.pyyh.ms.manager.business.serviceimp;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.ms.manager.business.dao.IModularMenuRoleDao;
import com.pyyh.ms.manager.business.dao.IOrganizationDao;
import com.pyyh.ms.manager.business.dao.IUserDao;
import com.pyyh.ms.manager.business.dao.IUserRoleDao;
import com.pyyh.ms.manager.business.pojos.ModularMenuPojo;
import com.pyyh.ms.manager.business.pojos.ModularMenuRolePojo;
import com.pyyh.ms.manager.business.pojos.OrganizationPojo;
import com.pyyh.ms.manager.business.pojos.UserPojo;
import com.pyyh.ms.manager.business.pojos.UserRolePojo;
import com.pyyh.ms.manager.business.service.IModularMenuRoleService;
import com.pyyh.ms.manager.configer.ProjectConfig;
import com.pyyh.ms.manager.pojos.ResponsePojo;

@Service("ModularMenuRoleServiceImp")
public class ModularMenuRoleServiceImp implements IModularMenuRoleService{
	@Autowired
	private IModularMenuRoleDao mmrDao;
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IOrganizationDao organizationDao;
	@Autowired
	private IUserRoleDao userRoleDao;
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
		OrganizationPojo op = new OrganizationPojo();
		op.setOrganizationCode(user.getOrganizationCode());
		OrganizationPojo _op = organizationDao.organizationFind(op).get(0);
		List<UserPojo> users = userDao.userFind(user);
		UserPojo _up = users.get(0);
		UserRolePojo urp = new UserRolePojo();
		urp.setOrganizationIndex(_op.getId());
		urp.setUserIndex(_up.getId());
		ModularMenuRolePojo mmrp = new ModularMenuRolePojo();
		List<UserRolePojo> urps = userRoleDao.userRoleFind(urp);
		mmrp.setRoleIndexes(new int[urps.size()]);
		for(int i = 0; i < urps.size(); i++){
			mmrp.getRoleIndexes()[i] = urps.get(i).getRoleIndex();
		}
		/*加载角色对应最底模块 
		 * */
		List<ModularMenuPojo> mmps = mmrDao.modularMenuRoleFind(mmrp);
		HashSet<String> auth = new HashSet<String>();
		for(ModularMenuPojo mmp : mmps){
			System.out.println(mmp.getId() + "  " + mmp.getModularName() + "  " + mmp.getParentId());
			auth.add("" + mmp.getId());
		}
		/*加载完整菜单 
		 * */
		ModularMenuPojo mmp1 = new ModularMenuPojo();
		mmp1.setParentId(0);
		mmp1.setModularLevel(1);
		List<ModularMenuPojo> mmps1 = mmrDao.modularMenuFind(mmp1);
		List<ModularMenuPojo> mmpFull = loadModularTree(mmps1);
		/*1：有权限菜单加入缓存
		 * 2：迭代全菜单集合：
		 * 	2.1：如果迭代获取的菜单项的子项集合为空，说明是最后一级菜单，比较是否在权限菜单里面。
		 * 		 没有就删除，
		 *  2.2：如果最后一级菜单都没有在权限菜单中，那么把此顶级菜单项删除
		 * */
		mmpFull = updateModularTree(mmpFull, auth);
		mmpFull = updateModularTree1(mmpFull);
		return JSONObject.toJSONString(mmpFull);
	}
	private List<ModularMenuPojo> updateModularTree1(List<ModularMenuPojo> mmpFull){
		Iterator<ModularMenuPojo> itr = mmpFull.iterator();
		while(itr.hasNext()){
			ModularMenuPojo mmp = itr.next();
			List<ModularMenuPojo> mmps1 = mmp.getChildren();
			if(mmps1.size() < 1 && mmp.getIsAction() == 0){
				System.out.println(mmp.getModularName());
				itr.remove();
			}else{
				updateModularTree1(mmps1);
			}
		}
		//最外层删除
		Iterator<ModularMenuPojo> itr1 = mmpFull.iterator();
		while(itr1.hasNext()){
			ModularMenuPojo mmp = itr1.next();
			List<ModularMenuPojo> mmps1 = mmp.getChildren();
			if(mmps1.size() < 1 && mmp.getIsAction() == 0){
				System.out.println(mmp.getModularName());
				itr1.remove();
			}else{
				updateModularTree1(mmps1);
			}
		}
		
		return mmpFull;
	}
	private List<ModularMenuPojo> updateModularTree(List<ModularMenuPojo> menu, HashSet<String> auth){
		Iterator<ModularMenuPojo> itr = menu.iterator();
		while(itr.hasNext()){
			ModularMenuPojo mmp = itr.next();
			List<ModularMenuPojo> mmps1 = mmp.getChildren();
			//是否最底菜单 是就删除，不是继续递归
			if(mmps1.size() < 1 && !auth.contains(("" + mmp.getId()))){
				itr.remove();
			}else{
				updateModularTree(mmps1, auth);
			}
		}
		return menu;
	}
	private List<ModularMenuPojo> loadModularTree(List<ModularMenuPojo> mmps){
		for(ModularMenuPojo mmp : mmps){
			ModularMenuPojo mmp1 = new ModularMenuPojo();
			mmp1.setParentId(mmp.getId());
			List<ModularMenuPojo> mmps1 = mmrDao.modularMenuFind(mmp1);
			mmp.setChildren(mmps1);
			loadModularTree(mmps1);
		}
		return mmps;
	}
}
