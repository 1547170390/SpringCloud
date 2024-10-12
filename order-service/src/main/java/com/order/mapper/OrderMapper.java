package com.order.mapper;

import com.order.model.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OrderMapper {

    @Select("select * from order_detail where id = #{orderId}")
    OrderInfo selectOrderById(Integer orderId);


    @Update("update order_detail set price = '110' where id = #{orderId} ")
    int updateOrderById(Integer orderId);

}
