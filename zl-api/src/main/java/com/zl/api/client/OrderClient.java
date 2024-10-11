package com.zl.api.client;

import com.zl.api.dto.OrderInfo;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("order-service")
public interface OrderClient {

    @GetMapping("order/{orderId}")
    OrderInfo queryOrderById(@PathVariable("orderId") Integer orderId);
}
