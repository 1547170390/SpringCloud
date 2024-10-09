package com.order.service;

import com.order.model.OrderInfo;

public interface OrderService {
    OrderInfo selectOrderById(Integer orderId);
}
