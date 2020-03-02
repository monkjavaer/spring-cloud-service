package com.example.apollo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Feign 方式请求服务； 加入@EnableDiscoveryClient和@EnableFeignClients注解
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Slf4j
public class EurekaUseUserServiceFeignApplication implements ApplicationRunner {


    @Autowired
    private UserApi userApi;
    @Autowired
    private DiscoveryClient discoveryClient;

    public static void main(String[] args) {
        SpringApplication.run(EurekaUseUserServiceFeignApplication.class, args);
    }

    /**
     * 启动执行
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("启动服务");
        String result = userApi.getUserName();
        log.info("getUserName获得结果：{}", result);
    }

}
