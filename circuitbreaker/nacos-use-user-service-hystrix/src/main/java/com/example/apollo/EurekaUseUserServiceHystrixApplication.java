package com.example.apollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Feign 方式请求服务； 加入@EnableDiscoveryClient和@EnableFeignClients注解
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//加入支持熔断注解
@EnableCircuitBreaker
public class EurekaUseUserServiceHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaUseUserServiceHystrixApplication.class, args);
    }

}
