package com.example.eurekaserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Title: UserAddressApiService
 * @Package: com.example.eurekaserver
 * @Description: TODO（添加描述）
 * @Author: monkjavaer
 * @Date: 2020/3/1 22:09
 * @Version: V1.0
 */
@Slf4j
@Service
public class FallbackUserAddressApiService implements UserAddressApi{
    @Override
    public String getUserAddress() {
        log.info("Fallback调用getUserAddress");
        return null;
    }
}
