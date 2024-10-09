// ProductServiceImpl
package com.product.service.Impl;

import com.product.mapper.ProductMapper;
import com.product.model.ProductInfo;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductInfo selectProductById(Integer productId) {
        return productMapper.selectProductById(productId);
    }
}

