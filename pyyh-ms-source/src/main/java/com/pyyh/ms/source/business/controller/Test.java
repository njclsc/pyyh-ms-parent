package com.pyyh.ms.source.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import redis.clients.jedis.JedisCluster;

@RestController
@RequestMapping("/test")
public class Test {
	@Autowired
	@Qualifier("rediSource")
	private JedisCluster jc;
	@RequestMapping("t1")
	public String test(){
		return "ccc";
	}
}
