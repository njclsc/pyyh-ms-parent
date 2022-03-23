package com.pyyh.ms.manager.configer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pyyh.ms.manager.business.serviceimp.AuthInterceptorServiceImp;
import com.pyyh.ms.manager.business_atomizer.serviceimp.OrganizationInterceptorServiceImp;

@Configuration
public class AppWebMvmConfigure implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(new AuthInterceptorServiceImp()).addPathPatterns("/**");
		registry.addInterceptor(new OrganizationInterceptorServiceImp()).addPathPatterns(
				"/atomizer/organization/add"
			);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

}
