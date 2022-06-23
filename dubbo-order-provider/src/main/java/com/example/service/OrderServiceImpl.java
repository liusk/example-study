package com.example.service;

import org.apache.dubbo.config.annotation.DubboService;
import study.example.order.api.IOrderService;
import study.example.order.dto.OrderDTO;

/**
 * @author liusk
 */
@DubboService(version = "1.0.0")
public class OrderServiceImpl implements IOrderService {
    @Override
    public OrderDTO getOrder() {
        OrderDTO orderDTO = new OrderDTO("12", "什么玩意");
        return orderDTO;
    }
}
