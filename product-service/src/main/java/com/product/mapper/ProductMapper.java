package com.product.mapper;

import com.product.model.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ProductMapper {

    @Select("select * from product_detail where id = #{productId}")
    ProductInfo selectProductById(Integer productId);


    @Update("update product_detail set product_name = '羊毛大衣' where id = #{productId} ")
    int updateProductById(Integer productId);
}
