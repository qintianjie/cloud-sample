package com.colorcc.cloud.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ColorccCloudEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColorccCloudEurekaApplication.class, args);
	}
}
