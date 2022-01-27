package com.pyyh.ms.source.configer;

import java.io.FileNotFoundException;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pyyh.ms.source.business.serviceimp.AuthInterceptorServiceImp;

@Configuration
public class AppWebMvmConfigure implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(new AuthInterceptorServiceImp()).addPathPatterns("/**");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		try {
			String sourcePath = "file:/" + ResourceUtils.getURL("").getPath().substring(1) + "staticSource/";
			registry.addResourceHandler("/staticSource/**").addResourceLocations(sourcePath);
			System.out.println(sourcePath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

}
