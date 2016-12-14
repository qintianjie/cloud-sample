package com.colorcc.cloud.gateway.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.colorcc.cloud.gateway.ribbon.config.BizConsumerRibbonConfiguration;
import com.colorcc.cloud.gateway.zuul.filter.SimpleFilter;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@RibbonClient(name = "colorcc-gateway-zuul-ribbon", configuration = BizConsumerRibbonConfiguration.class)
public class ColorccGatewayZuulApplication {
	@Bean
	public SimpleFilter simpleFilter() {
		return new SimpleFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(ColorccGatewayZuulApplication.class, args);
	}
}
