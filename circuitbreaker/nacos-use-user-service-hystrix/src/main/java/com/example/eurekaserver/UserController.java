package com.example.eurekaserver;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: UserController
 * @Package: com.example.eurekaserver
 * @Description: TODO（添加描述）
 * @Author: monkjavaer
 * @Date: 2020/3/1 21:58
 * @Version: V1.0
 */
@RestController
@RequestMapping("/hystrixTest")
@Slf4j
public class UserController {

    @Autowired
    private UserApi userApi;

    @Autowired
    private UserAddressApi userAddressApi;

    @GetMapping("/getUserName")
    @HystrixCommand(fallbackMethod = "getUserNameOther")
    public String getUserName(){
        log.info("开始调用getUserName");
        String result = userApi.getUserName();
        log.info("getUserName获得结果：{}", result);
        return result;
    }

    @PostMapping("/getUserAddress")
    public String getUserAddress(){
        log.info("开始调用getUserAddress");
        String result = userAddressApi.getUserAddress();
        log.info("getUserAddress获得结果：{}", result);
        return result;
    }

    public String getUserNameOther() {
        log.info("fallbackMethod调用内部getUserNameOther方法 !!!");
        return null;
    }
}
