package com.yc.cloud.service;

import com.yc.cloud.entity.Order;

public interface OrderService {


    /**
     * 创建订单
     */
    void create(Order order);
}
