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
