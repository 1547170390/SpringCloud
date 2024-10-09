package com.product.mapper;

import com.product.model.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProductMapper {

    @Select("select * from product_detail where id = #{productId}")
    ProductInfo selectProductById(Integer productId);
}
