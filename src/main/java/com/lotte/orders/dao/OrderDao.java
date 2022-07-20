package com.lotte.orders.dao;

import com.lotte.orders.dto.Order;
import com.lotte.orders.dto.OrderDetail;
import com.lotte.orders.dto.OrderCartItem;
import com.lotte.orders.dto.OrderUserDetail;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao {

    List<String> selectCartItemNames(Integer orderNo);
    List<Order> selectOrders(Integer orderNo);

    List<OrderCartItem> selectOrderCartItemsByOrderNo(Integer orderNo);
    OrderDetail selectOrderDetail(Integer orderNo);

    OrderUserDetail selectOrderUserDetail(Integer userNo);

    List<OrderCartItem> selectOrderCartItemsByCartItemNos(List<Integer> orderCartItemNos);
}
