package com.example.apollo;

import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Title: UserBean
 * @Package: com.example.eurekaserver
 * @Description: TODO（添加描述）
 * @Author: monkjavaer
 * @Date: 2020/3/2 15:35
 * @Version: V1.0
 */
@ConfigurationProperties("user")
@RefreshScope
@Data
@Component
public class UserProperties {

    /**
     * 年龄 默认0
     */
    private Integer age = 0;
}
