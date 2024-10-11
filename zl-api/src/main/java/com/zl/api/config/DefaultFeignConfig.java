package com.zl.api.config;

import com.zl.common.utils.UserContext;
import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;

public class DefaultFeignConfig {
    @Bean
    public Logger.Level feignLogLevel(){
        return Logger.Level.FULL;
    }

    @Bean
    public RequestInterceptor requestInterceptor(){
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
//                Long userId = UserContext.getUser();
                Long userId = 1L;
                if(userId == null){
                    return;
                }
                //放到请求头中，传递到下游微服务
                requestTemplate.header("user-info", userId.toString());
            }
        };
    }


}
