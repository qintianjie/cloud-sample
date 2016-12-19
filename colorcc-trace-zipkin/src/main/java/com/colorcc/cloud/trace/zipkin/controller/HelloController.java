/**
 * 
 */
package com.colorcc.cloud.trace.zipkin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Duoduo (tianjieqin@126.com)
 * @date   2016年12月20日-上午12:40:26
 *
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
	
	private final static Logger LOG = LoggerFactory.getLogger(HelloController.class);

	
	@GetMapping("/say")
	public String say() {
		LOG.info("call /hello/say");
		return "Hello World";
	}

}
