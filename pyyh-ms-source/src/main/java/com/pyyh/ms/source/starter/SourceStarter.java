package com.pyyh.ms.source.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.pyyh.ms.source"})
@EnableDiscoveryClient
@SpringBootApplication
public class SourceStarter extends SpringBootServletInitializer{

	public static void main(String[] args){
		SpringApplication.run(SourceStarter.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(SourceStarter.class);
	}
}
