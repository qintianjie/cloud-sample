package com.colorcc.cloud.biz.consumer.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author Duoduo (tianjieqin@126.com)
 * @date   2016年12月7日-下午10:10:01
 *
 */
@SpringBootApplication
@ComponentScan("com.colorcc.cloud.biz.consumer.ribbon.controller")
public class ColorccBizConsumerRibbonApplication {
	public static void main(String[] args) {
		SpringApplication.run(ColorccBizConsumerRibbonApplication.class, args);
	}
}
