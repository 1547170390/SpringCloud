package com.order.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 测试一下nacos配置的热更新
 */
@Component
@Data
@ConfigurationProperties(prefix = "zll.test")
public class TestProperties {
    private Integer sum;

}
