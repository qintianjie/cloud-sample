/**
 * 
 */
package com.colorcc.cloud.biz.consumer.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * http://localhost:8093/ribbon/s1/hi
 * 
 * 直连方式，无 load balance
 * @author Duoduo (tianjieqin@126.com)
 * @date   2016年12月7日-下午11:15:46
 *
 */
@RestController
@RequestMapping("/ribbon/s1")
public class SampleOneController {
	
	
	@Bean
	RestTemplate restTemplateOne() {
		return new RestTemplate();
	}

	@Autowired
	@Qualifier("restTemplateOne")
	RestTemplate restTemplate;

	@RequestMapping("/hi")
	public String hi(@RequestParam(value = "name", defaultValue = "sample one") String name) {
		String response = this.restTemplate.getForObject("http://localhost:8081/hello/say?name={name}", String.class, name);
		return String.format("%s!", response);
	}


}
