package com.usian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.usian.pojo.Order;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 韩丛
 * @since 2021-08-06
 */
public interface OrderMapper extends BaseMapper<Order> {

    int closeOverTimeOrders();

}
