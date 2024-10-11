package com.zl.api.client;

import com.zl.api.client.fallback.OrderClientFallback;
import com.zl.api.config.DefaultFeignConfig;
import com.zl.api.dto.OrderInfo;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "order-service",
fallbackFactory = OrderClientFallback.class)
public interface OrderClient {

    @GetMapping("order/{orderId}")
    OrderInfo queryOrderById(@PathVariable("orderId") Integer orderId);
}
