package com.order.service.Impl;

import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.order.mapper.OrderMapper;
import com.order.model.OrderInfo;
import com.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Override
    public OrderInfo selectOrderById(Integer orderId) {
        OrderInfo orderInfo = orderMapper.selectOrderById(orderId);
        return orderInfo;
    }

}
