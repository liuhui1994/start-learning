package org.business.system.order.service.impl;

import org.apache.commons.lang.StringUtils;
import org.business.system.common.base.service.SecurityValidateService;
import org.business.system.common.base.service.impl.BaseServiceImpl;
import org.business.system.common.cloud.auth.OauthCloudService;
import org.business.system.common.em.BooleanType;
import org.business.system.common.exception.CommonErrorException;
import org.business.system.common.model.dto.UserModelDto;
import org.business.system.order.em.OrderStatusType;
import org.business.system.order.em.RefundStatusType;
import org.business.system.order.mapper.OrderItemMapper;
import org.business.system.order.mapper.OrderMapper;
import org.business.system.order.model.Order;
import org.business.system.order.model.OrderItem;
import org.business.system.order.model.dto.OrderDto;
import org.business.system.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order,Long> implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private OauthCloudService oauthCloudService;
    @Autowired
    private SecurityValidateService securityValidateService;
    @Transactional
    @Override
    public OrderDto buildOrder( OrderDto order,String accessToken) {
        order.setOrderNo(UUID.randomUUID().toString().replace("-",""));
        insertEntity(order);
        UserModelDto user = oauthCloudService.getUserBytoken(accessToken).getData();
        Long userId = securityValidateService.getUserIdByUserIdEnc(user.getUserIdEnc());
        order.setUserId(userId);
        order.setOrderStatus(OrderStatusType.UNSEND);
        order.setId(1l);
        int success = orderMapper.insert(order);
       if(success < 0){
           throw new CommonErrorException("00","插入订单失败");
       }
        if(!CollectionUtils.isEmpty(order.getOrderItemList())){
            List<OrderItem> orderItemList = order.getOrderItemList();
            orderItemList.stream().forEach( orderItem -> {
                insertEntity(orderItem);
                orderItem.setOrderId(order.getId());
                orderItemMapper.insert(orderItem);
            });
            //success = orderItemMapper.insertList(orderItemList);
        }
        if(success < 0){
            throw new CommonErrorException("00","插入订单详情失败");
        }
        return order;
    }
    @Transactional
    @Override
    public int deleteOrderById(Long id) {
        if(id == null || id < 0){
            throw  new CommonErrorException("00","订单id输入有误");
        }
        OrderDto orderDto = this.getOrderById(id);
        orderDto.setStatus(BooleanType.TRUE);
        return orderMapper.updateByPrimaryKeySelective(orderDto);
    }

    @Override
    public OrderDto getOrderById(Long id) {
        Order order = orderMapper.selectByPrimaryKey(id);
        Example example = new Example(OrderItem.class);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderId",order.getId());
        List<OrderItem> orderItems = orderItemMapper.selectByExample(example);
        OrderDto orderDto = new OrderDto(order);
        orderDto.setOrderItemList(orderItems);
        return orderDto;
    }

    @Override
    public List<Order> orderList(Order order,String accessToken) {
        UserModelDto modelDto = this.oauthCloudService.getUserBytoken(accessToken).getData();
        Long userId = this.securityValidateService.getUserIdByUserIdEnc(modelDto.getUserIdEnc());
        if(userId == null || userId <= 0){
            return Collections.emptyList();
        }
        Example example = new Example(Order.class);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",userId);
        if(StringUtils.isNotBlank(order.getOrderNo())){
            criteria.andEqualTo("orderNo",order.getOrderNo());
        }
        if(order.getOrderStatus() != null){
            criteria.andEqualTo("orderStatus",order.getOrderStatus());
        }
        if(order.getRefundStatus() != null){
            criteria.andEqualTo("refundStatus",order.getRefundStatus());
        }
        criteria.andEqualTo("status",BooleanType.FALSE);
        return orderMapper.selectByExample(example);
    }

    @Transactional
    @Override
    public OrderDto updateOrder(OrderDto order) {
        orderMapper.updateByPrimaryKeySelective(order);
        return order;
    }

    @Transactional
    @Override
    public OrderDto refendOrder(Long id) {
        checkId(id);
        OrderDto order = this.getOrderById(id);
        if(order.getOrderStatus() == OrderStatusType.UNSEND){
            order.setStatus(BooleanType.TRUE);
            this.updateOrder(order);
        }else{
            order.setRefundStatus(RefundStatusType.UNSEND);
            this.updateOrder(order);
        }
        return order;
    }

    @Override
    public Order confirmRecieve(Long id) {
        this.checkId(id);
        OrderDto orderById = this.getOrderById(id);
        if(orderById != null){
            orderById.setRefundStatus(RefundStatusType.RECEIVED);
            // TODO: 2018/8/30 退款 关闭订单

        }
        return null;
    }

    private void checkId(Long id) {
        if(id == null|| id < 0){
            throw new CommonErrorException("000","id不存在");
        }
    }

}
