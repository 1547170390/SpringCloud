package com.zl.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "zl.auth")
public class AuthProperties {
    private List<String> includePaths;
    private List<String> excludePaths;
}
