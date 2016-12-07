package com.colorcc.cloud.biz.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@Configuration
@ComponentScan("com.colorcc.cloud.biz.provider.web.controller")
@RestController
public class ColorccBizProviderApplication {

	@RequestMapping(value = "/")
	public String home() {
		return "Hi!";
	}

	public static void main(String[] args) {
		SpringApplication.run(ColorccBizProviderApplication.class, args);
	}
}
