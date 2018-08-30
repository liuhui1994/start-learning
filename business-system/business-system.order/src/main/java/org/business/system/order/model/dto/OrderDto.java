package org.business.system.order.model.dto;

import org.business.system.order.model.Order;
import org.business.system.order.model.OrderItem;

import java.util.*;

public class OrderDto extends Order {

    public OrderDto(Order order) {
        this.setId(order.getId());
        this.setUserId(order.getUserId());
        this.setOrderNo(order.getOrderNo());
        this.setFee(order.getFee());
        this.setLimitPayTime(order.getLimitPayTime());
        this.setOrderStatus(order.getOrderStatus());
        this.setOrderTotalPrice(order.getOrderTotalPrice());
        this.setOutOrderNo(order.getOutOrderNo());
        this.setPayDateTime(order.getPayDateTime());
        this.setPayPrice(order.getPayPrice());
        this.setPayStatus(order.getPayStatus());
        this.setPayType(order.getPayType());
        this.setRefundPrice(order.getRefundPrice());
        this.setRefundStatus(order.getRefundStatus());
        this.setTradeType(order.getTradeType());
        this.setTxnCompleteTime(order.getTxnCompleteTime());
        this.setStatus(order.getStatus());
    }

    private List<OrderItem> orderItemList;

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }
}
