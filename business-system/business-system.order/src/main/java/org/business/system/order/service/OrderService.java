package org.business.system.order.service;

import org.business.system.common.base.service.BaseService;
import org.business.system.order.model.Order;
import org.business.system.order.model.dto.OrderDto;

import java.util.List;

public interface OrderService extends BaseService<Order, Long> {
    OrderDto buildOrder(OrderDto order,String accessToken);

    int deleteOrderById(Long id);

    OrderDto getOrderById(Long id);

    List<Order> orderList(Order order,String accessToken);

    OrderDto updateOrder(OrderDto order);

    OrderDto refendOrder(Long id);

    Order confirmRecieve(Long id);
}
