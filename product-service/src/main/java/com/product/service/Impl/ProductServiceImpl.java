// ProductServiceImpl
package com.product.service.Impl;

import com.product.mapper.ProductMapper;
import com.product.model.ProductInfo;
import com.product.service.ProductService;
import com.zl.api.client.OrderClient;
import com.zl.api.dto.OrderInfo;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    @GlobalTransactional
    public ProductInfo selectProductById(Integer productId) throws InterruptedException {

        amqpTemplate.convertAndSend("zl.topic","fault.error",1L);
        /**
         * 使用这个Thread.sleep休眠方法，验证得到了分布式回滚的结果
         */
        return productMapper.selectProductById(productId);
    }
}

