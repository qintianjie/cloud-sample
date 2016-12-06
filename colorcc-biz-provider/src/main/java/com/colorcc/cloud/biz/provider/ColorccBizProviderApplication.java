package com.colorcc.cloud.biz.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableEurekaClient
@Configuration
@ComponentScan("com.colorcc.cloud.biz.provider.web.controller")
public class ColorccBizProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColorccBizProviderApplication.class, args);
	}
}
