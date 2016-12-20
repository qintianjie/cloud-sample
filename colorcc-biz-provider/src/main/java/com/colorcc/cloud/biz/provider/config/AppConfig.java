/**
 * 
 */
package com.colorcc.cloud.biz.provider.config;

import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Duoduo (tianjieqin@126.com)
 * @date   2016年12月20日-上午12:23:26
 *
 */
@Configuration
public class AppConfig {
	
	@Bean
	public Sampler defaultSampler() {
		return new AlwaysSampler();
	}

}
