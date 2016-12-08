说明：   
	colorcc-cloud-eureka:  服务注册与发现     
	colorcc-biz-provider:  业务 Provider, 启动加参数   -DPORT=xxxx 在一台机器启动多个端口   
	colorcc-biz-consumer:  业务 Consumer, 通过  erueka 发现 provider, 手动进行 Random LoadBalancer  
	colorcc-biz-consumer-ribbon: 业务 Consumer, 通过  erueka 发现 provider, 通过 ribbon 进行  LoadBalancer   
	colorcc-config-server: 		配置中心业 server   
			http://localhost:8098/cloud-sample/dev   
	colorcc-config-client: 		业务端，使用git作为配置中心    
			http://localhost:8096/message    
	cloud-sample/config-repo:  配置信息     
			更新后需先：[POST! POST! POST!]  http://localhost:8096/refresh    
	

20161209  
	完成 Eureka、 Ribbon、 Config  sample   

20161206
	注册中心 Eureka server　sample
	Biz Provider & Eureka client sample
	Biz Consumer & Eureka client sample
	
	Consumer可以从注册中心得到 provider信息，通过自定义 router　规则请求 provider得到　Response.
	
	@Todo: consumer　端引入 load balance

# cloud-sample


# host config
127.0.0.1       serv1.euroke.colorcc.com
127.0.0.1       serv2.euroke.colorcc.com
127.0.0.1       provider1.biz.colorcc.com
127.0.0.1       provider2.biz.colorcc.com
127.0.0.1       provider3.biz.colorcc.com
