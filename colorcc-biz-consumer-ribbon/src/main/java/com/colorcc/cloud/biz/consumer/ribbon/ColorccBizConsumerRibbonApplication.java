package com.colorcc.cloud.biz.consumer.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

import com.colorcc.cloud.biz.consumer.ribbon.config.BizConsumerRibbonConfiguration;

/**
 * 
 * @author Duoduo (tianjieqin@126.com)
 * @date   2016年12月7日-下午10:10:01
 *
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableConfigServer
@RibbonClient(name = "colorcc-biz-consumer-ribbon", configuration = BizConsumerRibbonConfiguration.class)
@ComponentScan("com.colorcc.cloud.biz.consumer.ribbon.controller")
public class ColorccBizConsumerRibbonApplication {
	public static void main(String[] args) {
		SpringApplication.run(ColorccBizConsumerRibbonApplication.class, args);
	}
}
