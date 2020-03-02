package com.example.apollo;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Set;

/**
 * @Title: UserController
 * @Package: com.example.eurekaserver
 * @Description: 提供服务方
 * @Author: monkjavaer
 * @Date: 2020/3/1 14:48
 * @Version: V1.0
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @ApolloConfig
    private Config config;

    @Value("${user.age:0}")
    private int age;

    @PostConstruct
    private void initialize() {
        Set<String> changedKeys = config.getPropertyNames();
        log.info("changedKeys = {}", changedKeys);
    }

    @GetMapping("/getUserAge")
    public String getUserAge() {
        log.info("getUserAge 被调用,user age={}", config.getProperty("user.age","0"));
        log.info("getUserAge 被调用,age = {}", age);
        return config.getProperty("user.age","0");
    }
}
