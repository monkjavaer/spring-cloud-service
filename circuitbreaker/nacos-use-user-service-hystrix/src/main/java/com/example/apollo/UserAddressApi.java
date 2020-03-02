package com.example.apollo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Title: UserAdressApi
 * @Package: com.example.eurekaserver
 * @Description: TODO（添加描述）
 * @Author: monkjavaer
 * @Date: 2020/3/1 22:08
 * @Version: V1.0
 */
@FeignClient(name = "nacos-user-service", contextId = "userAddress",
        qualifier = "userAddressApi", path="/userAddress",
        fallback = FallbackUserAddressApiService.class)
public interface UserAddressApi {

    @PostMapping("/getUserName")
    String getUserAddress();
}
