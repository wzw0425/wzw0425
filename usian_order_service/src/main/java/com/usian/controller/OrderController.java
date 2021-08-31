package com.usian.controller;

import com.usian.dto.OrderDTO;
import com.usian.service.OrderService;
import com.usian.vo.CartOrOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Title: OrderController
 * @Description:
 * @Auther:
 * @Version: 1.0
 * @create 2021/8/24 15:15
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("goSettlement")
    public List<CartOrOrderItem> goSettlement(@RequestParam("ids") Long[] ids, @RequestParam("userId") Long userId){
       return  orderService.queryOrderItems(userId,ids);
    }

    //新增订单
    @RequestMapping("insertOrder")
    public String insertOrder(@RequestBody OrderDTO orderDTO){
        return orderService.insertOrder(orderDTO);
    }
}
