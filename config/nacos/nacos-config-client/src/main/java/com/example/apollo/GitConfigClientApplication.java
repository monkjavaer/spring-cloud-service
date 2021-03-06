package com.example.apollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GitConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(GitConfigClientApplication.class, args);
    }

}
