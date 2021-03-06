package com.colorcc.cloud.biz.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@Configuration
@ComponentScan("com.colorcc.cloud.biz.provider.web.controller")
@RestController
@EnableZipkinStreamServer
public class ColorccBizProviderApplication {

	/**
	 * 必须有 / 可访问路径，供 ribbon 做 loadbalance 探测用
	 * @return
	 */
	@RequestMapping(value = "/")
	public String home() {
		return "Hi!";
	}

	public static void main(String[] args) {
		SpringApplication.run(ColorccBizProviderApplication.class, args);
	}
}
