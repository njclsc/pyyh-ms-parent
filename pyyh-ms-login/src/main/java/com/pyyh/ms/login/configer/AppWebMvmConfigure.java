package com.pyyh.ms.login.configer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pyyh.ms.login.business.serviceimp.AuthInterceptorServiceImp;

@Configuration
public class AppWebMvmConfigure implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(new AuthInterceptorServiceImp()).addPathPatterns("/**")
			//以controller的请求路径为准排除路径[不拦截路径]
			.excludePathPatterns("/login/check");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

}
