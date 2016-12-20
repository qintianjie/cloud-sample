package com.colorcc.cloud.biz.consumer.ribbon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RetryRule;

public class BizConsumerRibbonConfiguration {
	@Autowired
	IClientConfig ribbonClientConfig;

	@Bean
	public IPing ribbonPing(IClientConfig config) {
		return new PingUrl();
	}
	
//	@Bean IRule rule() {
//		return new RandomRule();
//	}

//	@Bean
//	public IRule ribbonRule(IClientConfig config) {
//		return new AvailabilityFilteringRule();
//	}
	
	@Bean IRule rule() {
		return new RetryRule();
	}
	
	
	@Bean 
	public String name() {
		return "colorcc-biz-provider";
	}
}
