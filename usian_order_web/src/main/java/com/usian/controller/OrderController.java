package com.usian.controller;

import com.usian.api.OrderFeign;
import com.usian.dto.OrderDTO;
import com.usian.pojo.Order;
import com.usian.pojo.OrderItem;
import com.usian.pojo.OrderShipping;
import com.usian.utils.JsonUtils;
import com.usian.utils.Result;
import com.usian.vo.CartOrOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/frontend/order")
public class OrderController {
    @Autowired
    private OrderFeign orderFeign;
    /**
     * 购物车
     *  去结算页面/ 去订单的确认页面
     *   查询订单确认页面中需要的 订单项信息  List<CartOrOrderItem>
     */
    @RequestMapping("goSettlement")//frontend/order/goSettlement
    public Result goSettlement(@RequestParam("ids") Long[] ids, @RequestParam("userId") Long userId, @RequestParam("token") String token){
        List<CartOrOrderItem> data = orderFeign.goSettlement(ids,userId);
        return Result.ok(data);
    }

    @RequestMapping("insertOrder")
    public Result insertOrder(OrderShipping orderShipping , Order order, String orderItem){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrder(order);
        orderDTO.setOrderShipping(orderShipping);
        orderDTO.setOrderItems(JsonUtils.jsonToList(orderItem, OrderItem.class));

        String orderId = orderFeign.insertOrder(orderDTO);

        return Result.ok(orderId);
    }

}
