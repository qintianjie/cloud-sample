package com.colorcc.cloud.biz.provider.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	@Value("${server.port}")
    private int port;
	
	
	@GetMapping("/say")
	public String say(String name) {
		if (name == null) {
			name = "jack.";
		}
		return "Hello : " + name + ". port : " + port;
	}

}
