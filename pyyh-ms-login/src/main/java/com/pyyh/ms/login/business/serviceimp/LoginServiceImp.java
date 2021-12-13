package com.pyyh.ms.login.business.serviceimp;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.ms.login.business.service.ILoginService;
import com.pyyh.ms.login.configer.ProjectConfig;
import com.pyyh.ms.login.pojos.ResponsePojo;
import com.pyyh.ms.login.pojos.UserPojo;

import redis.clients.jedis.JedisCluster;

@Service("LoginServiceImp")
public class LoginServiceImp implements ILoginService{
	@Autowired
	@Qualifier("rediSource")
	private JedisCluster jedis;
	@Override
	public String check(UserPojo user, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try{
			String key = user.getAccount() + "_#_" + user.getOrganizationCode();
			UsernamePasswordToken token = new UsernamePasswordToken(key, user.getPassword());
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			
			user.setPassword("");
			user.setLogin(true);
			jedis.set(key, JSONObject.toJSONString(user));
			jedis.pexpire(key, ProjectConfig.getJWT_EXPIRES());
			String jwtToken = ProjectConfig.tokenOperate(1, user);
			response.addCookie(new Cookie("jwtToken", jwtToken));
			return JSONObject.toJSONString(response("/login/login/check", "登录成功", "success", jwtToken, null));
		}catch(UnknownAccountException e){
			return JSONObject.toJSONString(response("/login/login/check", "账号不存在", "fail", null, null));
		}catch(IncorrectCredentialsException e){
			return JSONObject.toJSONString(response("/login/login/check", "密码错误", "fail", null, null));
		}
	}
	
	private ResponsePojo response(String action, String message, String state, String jwtToken, Object result){
		ResponsePojo rp = new ResponsePojo();
		rp.setAction(action);
		rp.setMessage(message);
		rp.setState(state);
		rp.setToken(jwtToken);
		rp.setResult(result);
		return rp;
	}

}
