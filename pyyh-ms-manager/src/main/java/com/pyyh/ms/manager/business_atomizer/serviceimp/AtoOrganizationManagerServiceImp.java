package com.pyyh.ms.manager.business_atomizer.serviceimp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.ms.manager.business.pojos.OrganizationPojo;
import com.pyyh.ms.manager.business_atomizer.dao.IAtoOrganizationDao;
import com.pyyh.ms.manager.business_atomizer.service.IAtoOrganizationManagerService;
import com.pyyh.ms.manager.configer.ProjectConfig;
import com.pyyh.ms.manager.pojos.ResponsePojo;

@Service("AtoOrganizationManagerServiceImp")
public class AtoOrganizationManagerServiceImp implements IAtoOrganizationManagerService {
	@Autowired
	private IAtoOrganizationDao atoOrgDao;

	@Override
	public String organizationAdd(OrganizationPojo organizationPojo, HttpServletRequest req) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		try {
			if (atoOrgDao.organizationExists(organizationPojo) == 0) {
				String info = ProjectConfig.tokenOperate(2, req.getHeader("jwtToken"));
				JSONObject json = JSONObject.parseObject(info);
				organizationPojo.setCreator(json.get("account").toString());
				organizationPojo.setCreatorOrganizationCode(json.get("organizationCode").toString());
				atoOrgDao.organizationAdd(organizationPojo);
				rp.setMessage("组织添加成功!");
				rp.setState("success");
				System.out.println(organizationPojo.getId());
			} else {
				rp.setMessage("组织已经存在");
				rp.setState("fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
			rp.setMessage("组织添加错误");
			rp.setState("fail");
		}
		return JSONObject.toJSONString(rp);
	}

	@Override
	public String organizationDelete(OrganizationPojo organizationPojo, HttpServletRequest req) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		try {
			String info = ProjectConfig.tokenOperate(2, req.getHeader("jwtToken"));
			JSONObject json = JSONObject.parseObject(info);
			organizationPojo.setCreator(json.get("account").toString());
			organizationPojo.setCreatorOrganizationCode(json.get("organizationCode").toString());
			atoOrgDao.organizationDelete(organizationPojo);
			rp.setMessage("组织删除成功!");
			rp.setState("success");
		} catch (Exception e) {
			e.printStackTrace();
			rp.setMessage("组织删除错误");
			rp.setState("fail");
		}
		return JSONObject.toJSONString(rp);
	}

	@Override
	public String organizationUpdate(OrganizationPojo organizationPojo, HttpServletRequest req) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		try {
			String info = ProjectConfig.tokenOperate(2, req.getHeader("jwtToken"));
			JSONObject json = JSONObject.parseObject(info);
			organizationPojo.setCreator(json.get("account").toString());
			organizationPojo.setCreatorOrganizationCode(json.get("organizationCode").toString());
			atoOrgDao.organizationUpdate(organizationPojo);
			rp.setMessage("组织修改成功!");
			rp.setState("success");
		} catch (Exception e) {
			e.printStackTrace();
			rp.setMessage("组织修改错误");
			rp.setState("fail");
		}
		return JSONObject.toJSONString(rp);
	}

	@Override
	public String organizationFind(OrganizationPojo organizationPojo, HttpServletRequest req) {
		// TODO Auto-generated method stub
		
		ResponsePojo rp = new ResponsePojo();
		try {
			String info = ProjectConfig.tokenOperate(2, req.getHeader("jwtToken"));
			JSONObject json = JSONObject.parseObject(info);
			organizationPojo.setCreator(json.get("account").toString());
			organizationPojo.setCreatorOrganizationCode(json.get("organizationCode").toString());
			int rows = organizationPojo.getRows();
			int page = organizationPojo.getPage();
			int begin = (page - 1) * rows;
			int total = atoOrgDao.organizationCount(organizationPojo);
			organizationPojo.setBegin(begin);
			List<OrganizationPojo> orgs = atoOrgDao.organizationFind(organizationPojo);
			rp.setResultData(orgs);
			rp.setTotal(total);
			rp.setMessage("组织查询成功!");
			rp.setState("success");
		} catch (Exception e) {
			e.printStackTrace();
			rp.setMessage("组织查询错误");
			rp.setState("fail");
		}
		return JSONObject.toJSONString(rp);
	}

}
