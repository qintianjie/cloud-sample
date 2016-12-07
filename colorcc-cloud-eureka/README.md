# cloud-sample

Module:  
	colorcc-cloud-eureka :  注册中心  & Eureka server   
	colorcc-biz-provider :  Service Provider & Eureka client   
	colorcc-biz-consumer :  Service Consumer & Eureka client  自定义 load balance  
	colorcc-biz-consumer-ribbon: Service Consumer & Eureka client.  直连 & ribbon loadbalance  

启动:  
Step 1： 启动注册中心 (即： eureka-server)   colorcc-cloud-eureka  
	http://serv1.euroke.colorcc.com:8761/  
	
Step 2: 启动 provider (也是 eureka-client)   colorcc-biz-provider  
	访问注册中心，观察其中 instances 变化    
	启动参数加 -DPORT=808x 分别启动几个 instance   
	http://qintianjie.sogou-inc.com:8082/hello/say?name=ss    
	
Step3: 启动 consumer (也是 eureka-client)   colorcc-biz-consumer  
Step4: 启动 consumer （ribbon for loadbalance)  colorcc-biz-consumer-ribbon  


验证：  
http://localhost:8091/client/services  得到注册中心所有 instance   
http://localhost:8091/client/hello/say 从 consumer 随机请求 provider 提供的服务   


http://localhost:8093/ribbon/s1/hi   //直连，永远都是直连的 server   
http://localhost:8093/ribbon/s2/hi   //ribbon loadbalance, 轮询策略请求后端

