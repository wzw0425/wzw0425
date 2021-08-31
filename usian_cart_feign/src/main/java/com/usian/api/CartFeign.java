package com.usian.api;

import com.usian.vo.CartOrOrderItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@FeignClient("usian-cart-service")
public interface CartFeign {

    @RequestMapping("cart/addItem")
    void addItem(@RequestParam("userId") Long userId,@RequestParam("itemId") Long itemId);

    @RequestMapping("cart/showCart")
    Collection<CartOrOrderItem> showCart(@RequestParam("userId") Long userId);

}
