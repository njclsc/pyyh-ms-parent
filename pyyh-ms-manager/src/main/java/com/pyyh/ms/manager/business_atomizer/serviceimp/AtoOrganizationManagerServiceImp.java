package com.pyyh.ms.manager.business_atomizer.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.ms.manager.business.pojos.OrganizationPojo;
import com.pyyh.ms.manager.business_atomizer.dao.IAtoOrganizationDao;
import com.pyyh.ms.manager.business_atomizer.service.IAtoOrganizationManagerService;
import com.pyyh.ms.manager.pojos.ResponsePojo;

@Service("AtoOrganizationManagerServiceImp")
public class AtoOrganizationManagerServiceImp implements IAtoOrganizationManagerService	{
	@Autowired
	private IAtoOrganizationDao atoOrgDao;
	@Override
	public String organizationAdd(OrganizationPojo organizationPojo) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		try{
			if(atoOrgDao.organizationExists(organizationPojo) == 0){
				atoOrgDao.organizationAdd(organizationPojo);
				rp.setMessage("组织添加成功!");
				rp.setState("success");
				System.out.println(organizationPojo.getId());
			}else{
				rp.setMessage("组织已经存在");
				rp.setState("fail");
			}
		}catch(Exception e){
			e.printStackTrace();
			rp.setMessage("组织添加错误");
			rp.setState("fail");
		}
		return JSONObject.toJSONString(rp);
	}

	
}
