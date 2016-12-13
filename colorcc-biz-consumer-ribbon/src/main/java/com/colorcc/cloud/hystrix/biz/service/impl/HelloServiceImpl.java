package com.colorcc.cloud.hystrix.biz.service.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.colorcc.cloud.hystrix.biz.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloServiceImpl implements HelloService {
	
	@Override
	@HystrixCommand(fallbackMethod="fallback")
	public String hello() {
		Random random = new Random();
		int nextInt = random.nextInt(10);
		System.out.println("hello : " + nextInt);
		if (nextInt > 6) {
			return "Hello Jack";			
		} else {
			throw new RuntimeException("hello value small 6");
		}
	}


	@Override
	@HystrixCommand(fallbackMethod="fallback")
	public String say() {
		Random random = new Random();
		int nextInt = random.nextInt(10);
		System.out.println("say : " + nextInt);
		if (nextInt > 6) {
			return "Say Jack";			
		} else {
			throw new RuntimeException("say value small 6");
		}
		
	}

	public String fallback() {
		return "Error less 6.";
	}
}
