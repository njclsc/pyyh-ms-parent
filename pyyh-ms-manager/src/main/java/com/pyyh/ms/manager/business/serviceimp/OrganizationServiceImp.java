package com.pyyh.ms.manager.business.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.ms.manager.business.dao.IOrganizationDao;
import com.pyyh.ms.manager.business.pojos.OrganizationPojo;
import com.pyyh.ms.manager.business.service.IOrganizationService;
import com.pyyh.ms.manager.pojos.ResponsePojo;
@Service("OrganizationServiceImp")
public class OrganizationServiceImp implements IOrganizationService{
	@Autowired
	private IOrganizationDao organizationDao;
	@Override
	public String organizationAdd(OrganizationPojo organizationPojo) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		if(organizationDao.organizationExists(organizationPojo) == 0){
			organizationDao.organizationAdd(organizationPojo);
			rp.setState("success");
			rp.setMessage("组织添加成功!");
		}else{
			rp.setState("fail");
			rp.setMessage("组织以存在!");
		}
		return JSONObject.toJSONString(rp);
	}
	@Override
	public String organizationDelete(OrganizationPojo organizationPojo) {
		// TODO Auto-generated method stub
		organizationDao.organizationDelete(organizationPojo);
		ResponsePojo rp = new ResponsePojo();
		rp.setState("success");
		rp.setMessage("组织已删除!");
		return JSONObject.toJSONString(rp);
	}
	@Override
	public String organizationUpdate(OrganizationPojo organizationPojo) {
		// TODO Auto-generated method stub
		organizationDao.organizationUpdate(organizationPojo);
		ResponsePojo rp = new ResponsePojo();
		rp.setState("success");
		rp.setMessage("组织修改成功!");
		return JSONObject.toJSONString(rp);
	}
	@Override
	public String organizationFind(OrganizationPojo organizationPojo) {
		// TODO Auto-generated method stub
		List<OrganizationPojo> ops = organizationDao.organizationFind(organizationPojo);
		int total = organizationDao.organizationCount(organizationPojo);
		ResponsePojo rp = new ResponsePojo();
		rp.setTotal(total);
		rp.setResultData(ops);
		rp.setState("success");
		return JSONObject.toJSONString(rp);
	}

}
