package com.colorcc.cloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * http://localhost:8098/cloud-sample/default 
 * 
 * @author Duoduo (tianjieqin@126.com)
 * @date   2016年12月8日-下午11:26:44
 *
 */
@SpringBootApplication
@EnableConfigServer
public class ColorccConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColorccConfigServerApplication.class, args);
	}
}
