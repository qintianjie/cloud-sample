/**
 * 
 */
package com.colorcc.cloud.biz.consumer.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * http://localhost:8093/ribbon/s2/hi 
 * 
 * 走 load balance
 * 
 * @author Duoduo (tianjieqin@126.com)
 * @date   2016年12月7日-下午11:15:46
 *
 */
@RestController
@RequestMapping("/ribbon/s2")
public class SampleTwoController {
	
	@Value("${provider.name}")
    private String providerName; 
	
	public String getProviderName() {
		return providerName;
	}

	/**
	 * DynamicServerListLoadBalancerforclientcolorcc-biz-consumer-ribboninitialized: DynamicServerListLoadBalancer: {
		    NFLoadBalancer: name=colorcc-biz-consumer-ribbon,
		    currentlistofServers=[
		        localhost: 8081,
		        localhost: 8082
		    ],
		    Loadbalancerstats=Zonestats: {
		        unknown=[
		            Zone: unknown;Instancecount: 2;Activeconnectionscount: 0;Circuitbreakertrippedcount: 0;Activeconnectionsperserver: 0.0;
		        ]
		    },
		    Serverstats: [
		        [
		            Server: localhost: 8081;Zone: UNKNOWN;TotalRequests: 0;Successiveconnectionfailure: 0;
		            Totalblackoutseconds: 0;Lastconnectionmade: ThuJan0108: 00: 00CST1970;Firstconnectionmade: ThuJan0108: 00: 00CST1970;
		            ActiveConnections: 0;totalfailurecountinlast(1000)msecs: 0;averageresptime: 0.0;90percentileresptime: 0.0;95percentileresptime: 0.0;
		            minresptime: 0.0;maxresptime: 0.0;stddevresptime: 0.0
		        ],
		        [
		            Server: localhost: 8082;Zone: UNKNOWN;TotalRequests: 0;Successiveconnectionfailure: 0;
		            Totalblackoutseconds: 0;Lastconnectionmade: ThuJan0108: 00: 00CST1970;Firstconnectionmade: ThuJan0108: 00: 00CST1970;
		            ActiveConnections: 0;totalfailurecountinlast(1000)msecs: 0;averageresptime: 0.0;90percentileresptime: 0.0;
		            95percentileresptime: 0.0;minresptime: 0.0;maxresptime: 0.0;stddevresptime: 0.0
		        ]
		    ]
		}ServerList: com.netflix.loadbalancer.ConfigurationBasedServerList@209918e0
	 * @return
	 */
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	@Qualifier("restTemplate")
	RestTemplate restTemplate;

	@RequestMapping("/hi")
	public String hi(@RequestParam(value = "name", defaultValue = "Sample") String name) {
		System.out.println("pn: " + this.getProviderName());
//		String response = this.restTemplate.getForObject("http://colorcc-biz-provider/hello/say?name={name}", String.class, name);
		String response = this.restTemplate.getForObject("http://" + this.getProviderName() + "/hello/say?name={name}", String.class, name);
		return String.format("%s", response);
	}


}
