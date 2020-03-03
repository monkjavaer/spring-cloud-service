package com.example.apollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableEurekaClient
public class EurekaOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaOrderServiceApplication.class, args);
    }

}
