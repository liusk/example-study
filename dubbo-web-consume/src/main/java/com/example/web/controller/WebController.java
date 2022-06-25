package com.example.web.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.example.order.api.IOrderService;
import study.example.order.dto.OrderDTO;

import java.util.List;

/**
 * @author liusk
 */
@RestController
@RequestMapping("order")
public class WebController {

    @DubboReference(interfaceClass = IOrderService.class, check = false, version = "1.0.0", group = "*", merger = "cus")
    private IOrderService orderService;

    @RequestMapping("test")
    public List<OrderDTO> getOrder() {
        RpcContext.getServiceContext().setAttachment("name", "context");
        return orderService.getOrder();
    }
}
