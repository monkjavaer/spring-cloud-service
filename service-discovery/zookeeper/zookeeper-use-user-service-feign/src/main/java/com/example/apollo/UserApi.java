package com.example.apollo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Title: UserApi
 * @Package: com.example.eurekaserver
 * @Description:
 *
 * 远程调用接口封装，eureka-user-service远程调用的服务名，
 *
 * 注意！！！！：
 * 不要在接口上加@RequestMapping，同意前缀使用@FeignClient的path属性
 *
 * @Author: monkjavaer
 * @Date: 2020/3/1 15:46
 * @Version: V1.0
 */
@FeignClient(name = "zk-user-service", contextId = "user", path = "/user")
public interface UserApi {

    /**
     * 远程调用接口 获取用户名
     * @return
     */
    @GetMapping("/getUserName")
    String getUserName();

}
