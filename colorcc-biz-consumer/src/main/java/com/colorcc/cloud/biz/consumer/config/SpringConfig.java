package com.colorcc.cloud.biz.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringConfig {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
