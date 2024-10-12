// ProductService
package com.product.service;

import com.product.model.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface ProductService {
    ProductInfo selectProductById(Integer productId) throws InterruptedException;
}

