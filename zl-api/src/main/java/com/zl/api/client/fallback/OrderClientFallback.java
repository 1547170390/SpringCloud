package com.zl.api.client.fallback;

import cn.hutool.core.collection.CollUtil;
import com.zl.api.client.OrderClient;
import com.zl.api.dto.OrderInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.ArrayList;

@Slf4j
public class OrderClientFallback implements FallbackFactory<OrderClient> {
    @Override
    public OrderClient create(Throwable cause) {
        return new OrderClient() {
            @Override
            public OrderInfo queryOrderById(Integer orderId) {
                log.error("远程调用失败");
                return new OrderInfo();
            }
        };
    }
}
