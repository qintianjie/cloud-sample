package com.colorcc.cloud.biz.consumer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping(value = "/client")
@ComponentScan("com.colorcc.cloud.biz.consumer.config")
public class ColorccBizConsumerApplication {
	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/services")
	public String client() {
		// step 1: 连接注册中心
		List<String> services = discoveryClient.getServices();

		Map<String, Object> result = new HashMap<>();
		result.put("services", services);
		if (services != null) {
			for (String service : services) {
				// step 2: 从注册中心拿 provider 对应 instances
				List<ServiceInstance> instances = discoveryClient.getInstances(service);
				result.put("[provider]-" + service, instances);
			}
		}

		return new Gson().toJson(result);
	}

	@GetMapping("/hello/say")
	public Map<String, Object> sayHello(String name) {
		Map<String, Object> result = new HashMap<>();
		// step 3: 自己写一个随机路由算法
		List<ServiceInstance> instances = discoveryClient.getInstances("colorcc-biz-provider");
		Random random = new Random();
		int index = random.nextInt(instances.size());
		ServiceInstance serviceInstance = instances.get(index);

		if (name == null) {
			name = "client-" + index;
		}
		String reqUrl = serviceInstance.getUri() + "/hello/say?name={name}";
		// step 4: 发起对 provider 请求
		String response = restTemplate.getForObject(reqUrl, String.class, name);
		/* 输出结果 */
		result.put("reqUrl ", reqUrl);
		Map<String, String> reqPrams = new HashMap<>();
		reqPrams.put("name", name);
		result.put("reqParams", reqPrams);
		result.put("response", response);
		result.put("provider", serviceInstance.getHost() + ":" + serviceInstance.getPort());
		return result;
	}

	public static void main(String[] args) {
		SpringApplication.run(ColorccBizConsumerApplication.class, args);
	}
}
