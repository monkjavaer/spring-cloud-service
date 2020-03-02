package com.example.apollo;

import lombok.extern.slf4j.Slf4j;
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

    /**
     * 获取用户名
     * @return
     */
    @GetMapping("/getUserName")
    public String getUserName() {
        log.info("getUserName 被调用");
        return "spring cloud 测试";
    }

    @PostMapping("/getUserAddress")
    public String getUserAddress() {
        log.info("getUserAddress 被调用");
        return "测试地址No.1.";
    }
}
