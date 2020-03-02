# spring cloud 微服务研究
## 使用版本信息
- spring cloud ：Greenwich.SR2
- spring boot : 2.1.6.RELEASE
- spring-cloud-alibaba-dependencies : 0.9.0.RELEASE

## 文件夹说明
- service-discovery 包含各种方式服务注册，服务发现(eureka,zookeeper，consul，nacos)
- circuitbreaker 熔断 (hystrix/Sentinel/resilience4j)
- config 配置中心（spring cloud config client git方式/nacos/consul/zookeeper/apollo ）其中nacos，consul，zookeeper三种支持自动刷新配置