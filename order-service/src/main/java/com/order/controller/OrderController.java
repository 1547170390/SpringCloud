package com.order.controller;

import com.order.model.OrderInfo;
import com.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/{orderId}")
    public OrderInfo getOrderById(@PathVariable("orderId") Integer orderId) throws InterruptedException {
        return orderService.selectOrderById(orderId);
    }


}
