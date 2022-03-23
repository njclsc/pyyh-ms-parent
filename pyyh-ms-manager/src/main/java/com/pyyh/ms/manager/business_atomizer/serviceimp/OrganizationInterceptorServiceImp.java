package com.pyyh.ms.manager.business_atomizer.serviceimp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.ms.manager.business.pojos.UserPojo;
import com.pyyh.ms.manager.business_atomizer.dao.IAtoOrganizationDao;
import com.pyyh.ms.manager.business_atomizer.service.IOrganizationInterceptorService;
import com.pyyh.ms.manager.configer.ProjectConfig;
import com.pyyh.ms.manager.configer.RedisSourceConfigure;
public class OrganizationInterceptorServiceImp implements IOrganizationInterceptorService{
	@Autowired
	private IAtoOrganizationDao orgDao;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		String info = ProjectConfig.tokenOperate(2, request.getHeader("jwtToken"));
		JSONObject json = JSONObject.parseObject(info);
		String js = RedisSourceConfigure.getJedisCluster().get(json.get("account") + "_#_" + json.get("organizationCode"));
		System.out.println(js);
		if(json.get("organizationCode").equals("0000001") && json.getInteger("roleType") == 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		IOrganizationInterceptorService.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		IOrganizationInterceptorService.super.afterCompletion(request, response, handler, ex);
	}

}
