package org.business.system.order.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.business.system.common.base.model.Entity;
import org.business.system.common.em.BooleanType;
import org.business.system.common.response.ResponseMessage;
import org.business.system.order.em.OrderStatusType;
import org.business.system.order.em.PayStatus;
import org.business.system.order.model.Order;
import org.business.system.order.model.dto.OrderDto;
import org.business.system.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController  {

    @Autowired
    private OrderService orderService;
    @ApiOperation(value="新增订单", notes="新增订单" )
    @ApiImplicitParams({
            @ApiImplicitParam(name="order", value="订单",required = true,dataType="OrderDto"),
    })

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResponseMessage<OrderDto> buildOrder(@RequestBody OrderDto order, String accessToken){

        return ResponseMessage.success(orderService.buildOrder(order,accessToken));
    }

    @ApiOperation(value="更新订单", notes="更新订单" )
    @ApiImplicitParams({
            @ApiImplicitParam(name="order", value="订单",required = true,dataType="OrderDto"),
    })

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResponseMessage<OrderDto> updateOrder(@RequestBody OrderDto order){

        return ResponseMessage.success(orderService.updateOrder(order));
    }


    @ApiOperation(value="通过Id删除订单", notes="通过Id删除订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id", value="订单id",required = true,dataType="Long",paramType="path"),
    })
    @RequestMapping(value ="/{id}", method = RequestMethod.POST)
    public ResponseMessage<Integer> delete(@PathVariable Long id){
        return ResponseMessage.success(orderService.deleteOrderById(id));
    }
    @ApiOperation(value="通过Id获取订单详情", notes="通过Id获取订单详情" )
    @ApiImplicitParams({
            @ApiImplicitParam(name="id", value="订单id",required = true,dataType="Long",paramType="path"),
    })
    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public ResponseMessage<OrderDto> orderDetail(@PathVariable(name="id") Long id) {
        return ResponseMessage.success(orderService.getOrderById(id));
    }

    @ApiOperation(value="获取订单列表", notes="获取订单列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "accessToken", value = "登录密钥", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pageNum", value = "第几页", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "orderBy", value = "排序", required = false, dataType = "String",paramType = "query"),

    })
    @RequestMapping(value = "orderList",method = RequestMethod.POST)
    public ResponseMessage<PageInfo<Order>> orderList(@RequestBody Order order,
                                                     @RequestParam(name="pageNum") Integer pageNum,
                                                     @RequestParam(name="pageSize",defaultValue="1") Integer pageSize,
                                                     @RequestParam(name="orderBy",defaultValue="id") String orderBy,
                                                     @RequestParam(name="accessToken") String accessToken){
        PageHelper.startPage(pageNum,pageSize,orderBy);
        List<Order> orders = orderService.orderList(order,accessToken);
        PageInfo<Order> pageInfo = new PageInfo<>(orders);
        return ResponseMessage.success(pageInfo);
    }

    @RequestMapping(value = "refendOrder/{id}",method = RequestMethod.POST)
    public ResponseMessage<Order> refendOrder(@PathVariable Long id){
        return ResponseMessage.success(this.orderService.refendOrder(id));
    }


    @RequestMapping(value = "confirmRecieve/{id}",method = RequestMethod.POST)
    public ResponseMessage confirmRecieve(@PathVariable Long id){

        return ResponseMessage.success(orderService.confirmRecieve(id));
    }

}
