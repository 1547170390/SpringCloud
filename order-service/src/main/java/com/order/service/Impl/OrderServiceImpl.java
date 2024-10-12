package com.order.service.Impl;

import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.order.config.TestProperties;
import com.order.mapper.OrderMapper;
import com.order.model.OrderInfo;
import com.order.service.OrderService;
import jakarta.annotation.Resource;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Scope("refresh")
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orderMapper;


    private final TestProperties testProperties;

    @Override
    public OrderInfo selectOrderById(Integer orderId) throws InterruptedException {
        System.out.println("热配置的值"+testProperties.getSum());
        /**
         * 验证两个服务是不是都回滚了
         */
//        int i = orderMapper.updateOrderById(6);
        OrderInfo orderInfo = orderMapper.selectOrderById(orderId);
        return orderInfo;
    }

}
