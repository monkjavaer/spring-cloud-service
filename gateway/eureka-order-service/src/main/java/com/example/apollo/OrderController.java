package com.example.apollo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: OrderController
 * @Package: com.example.eurekaserver
 * @Description: 提供服务方
 * @Author: monkjavaer
 * @Date: 2020/3/1 14:48
 * @Version: V1.0
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    /**
     * getOrderNo
     * @return
     */
    @GetMapping("/getOrderNo")
    public String getOrderNo() {
        log.info("getOrderNo 被调用");
        return "spring cloud 测试 no = 001";
    }
}
