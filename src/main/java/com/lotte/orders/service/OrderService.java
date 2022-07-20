package com.lotte.orders.service;

import com.lotte.orders.dao.OrderDao;
import com.lotte.orders.dto.Order;
import com.lotte.orders.dto.OrderDetail;
import com.lotte.orders.dto.OrderDetailCartItem;
import com.lotte.orders.dto.response.OrderResponse;
import com.lotte.orders.dto.response.OrderResponse.OrderDetailDto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }


    public OrderResponse.OrdersDto getOrders(Integer userNo) {
        List<Order> orders = orderDao.selectOrders(userNo);
        orders.forEach(order ->
            order.setProductNames(orderDao.selectCartItemNames(order.getOrderNo())));

        return new OrderResponse.OrdersDto(orders);
    }

    public OrderResponse.OrderDetailDto getOrderDetail(Integer orderNo) {
        // 주문 목록에 있는 상품 목록 (장바구니 아이템 목록) 가져오기
        List<OrderDetailCartItem> orderDetailCartItems = orderDao.selectOrderCartItems(orderNo);

        // 주문 정보 가져오기
        OrderDetail orderDetail = orderDao.selectOrderDetail(orderNo);

        return new OrderDetailDto(orderDetailCartItems, orderDetail);

    }

}
