package org.business.system.order.controller;

import java.util.List;

import org.business.system.common.response.ResponseMessage;
import org.business.system.order.model.Order;
import org.business.system.order.model.dto.OrderDto;
import org.business.system.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

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

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
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
            @ApiImplicitParam(name = "accessToken", value = "登录密钥", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="order", value="查询条件",required = false,dataType = "Order"),
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
    @ApiOperation(value="通过Id取消订单", notes="通过Id取消订单" )
    @ApiImplicitParams({
            @ApiImplicitParam(name="id", value="订单id",required = true,dataType="Long",paramType="path"),
    })
    @RequestMapping(value = "refendOrder/{id}",method = RequestMethod.POST)
    public ResponseMessage<Order> refendOrder(@PathVariable Long id){
        return ResponseMessage.success(this.orderService.refendOrder(id));
    }

    @ApiOperation(value="通过Id退货确认收货", notes="通过Id退货确认收货" )
    @ApiImplicitParams({
            @ApiImplicitParam(name="id", value="订单id",required = true,dataType="Long",paramType="path"),
    })
    @RequestMapping(value = "confirmRecieve/{id}",method = RequestMethod.POST)
    public ResponseMessage confirmRecieve(@PathVariable Long id){

        return ResponseMessage.success(orderService.confirmRecieve(id));
    }

}
