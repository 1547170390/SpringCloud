// ProductServiceImpl
package com.product.service.Impl;

import com.product.mapper.ProductMapper;
import com.product.model.ProductInfo;
import com.product.service.ProductService;
import com.zl.api.client.OrderClient;
import com.zl.api.dto.OrderInfo;
import io.seata.spring.annotation.GlobalTransactional;
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
    @GlobalTransactional
    public ProductInfo selectProductById(Integer productId) throws InterruptedException {

        OrderInfo orderInfo = orderClient.queryOrderById(1);
        System.out.println(orderInfo);

        /**
         * 使用这个Thread.sleep休眠方法，验证得到了分布式回滚的结果
         */
        int i = productMapper.updateProductById(10010);
//        Thread.sleep(10000);
//        int a = 1/ 0;
        return productMapper.selectProductById(productId);
    }
}

