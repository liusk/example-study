package com.example.web.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.example.order.api.IOrderService;
import study.example.order.dto.OrderDTO;

/**
 * @author liusk
 */
@RestController
@RequestMapping("order")
public class WebController {

    @DubboReference(check = false, version = "1.0.0")
    private IOrderService orderService;

    @RequestMapping("test")
    public OrderDTO getOrder() {
        return orderService.getOrder();
    }
}
