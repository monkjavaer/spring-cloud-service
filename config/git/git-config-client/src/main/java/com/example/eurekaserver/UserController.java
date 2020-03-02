package com.example.apollo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private UserProperties userProperties;

    @GetMapping("/getUserAge")
    public Integer getUserAge() {
        log.info("getUserAge 被调用,user age={}", userProperties.getAge());
        return userProperties.getAge();
    }
}
