package com.pyyh.ms.login.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.pyyh.ms.login"})
@MapperScan(basePackages = {"com.pyyh.ms.login"})
@EnableDiscoveryClient
@SpringBootApplication
public class LoginStarter extends SpringBootServletInitializer{
	
	public static void main(String[] args){
		SpringApplication.run(LoginStarter.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(LoginStarter.class);
	}
}
