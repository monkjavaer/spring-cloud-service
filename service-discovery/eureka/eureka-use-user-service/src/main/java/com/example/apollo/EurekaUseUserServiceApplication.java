package com.example.apollo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class EurekaUseUserServiceApplication implements ApplicationRunner {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    public static void main(String[] args) {
        SpringApplication.run(EurekaUseUserServiceApplication.class, args);
    }

    /**
     * 启动执行
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("启动 use user 服务");
        log.info("discoveryClient 名字: {}", discoveryClient.getClass().getName());
        discoveryClient.getInstances("eureka-user-service").forEach(s -> {
            log.info("host: {}, Port: {}", s.getHost(), s.getPort());
        });
        String result = restTemplate.getForObject("http://eureka-user-service/user/getUserName", String.class);
        log.info("getUserName获得结果：{}", result);
    }

    @Bean
    //开启负载均衡的注解
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
