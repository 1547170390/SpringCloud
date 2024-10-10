// ProductServiceImpl
package com.product.service.Impl;

import com.product.mapper.ProductMapper;
import com.product.model.ProductInfo;
import com.product.service.ProductService;
import com.zl.api.client.OrderClient;
import com.zl.api.dto.OrderInfo;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private OrderClient orderClient;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductInfo selectProductById(Integer productId) {

        OrderInfo orderInfo = orderClient.queryOrderById(1);
        System.out.println(orderInfo);
        return productMapper.selectProductById(productId);
    }
}

