package com.colorcc.cloud.hystrix.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colorcc.cloud.hystrix.biz.service.HelloService;

@RestController
@RequestMapping(value="/hello")
public class HelloController {
	
	@Autowired
	HelloService helloService;
	
	@GetMapping("")
	public String hello() {
		return helloService.hello();
	}
	
	@GetMapping("/say")
	public String say() {
		return helloService.say();
	}
}
