package com.pyyh.ms.login.business.serviceimp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.ms.login.business.service.IAuthInterceptorService;
import com.pyyh.ms.login.configer.ProjectConfig;
import com.pyyh.ms.login.configer.RedisSourceConfigure;

import redis.clients.jedis.JedisCluster;
public class AuthInterceptorServiceImp implements IAuthInterceptorService{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		String info = ProjectConfig.tokenOperate(2, request.getHeader("jwtToken"));
		JSONObject json = JSONObject.parseObject(info);
		String js = RedisSourceConfigure.getJedisCluster().get(json.get("account") + "_#_" + json.get("organizationCode"));
//		System.out.println(JSONObject.parseObject(js).getBooleanValue("login"));
		return JSONObject.parseObject(js).getBooleanValue("login");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(222);
		IAuthInterceptorService.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println(333);
		IAuthInterceptorService.super.afterCompletion(request, response, handler, ex);
	}

}
