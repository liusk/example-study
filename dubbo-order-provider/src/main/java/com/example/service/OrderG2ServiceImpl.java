package com.example.service;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import study.example.order.api.IOrderService;
import study.example.order.dto.OrderDTO;

import java.util.List;

/**
 * @author liusk
 */
@Slf4j
@DubboService(version = "1.0.0", group = "g2")
public class OrderG2ServiceImpl implements IOrderService {
    @Override
    public List<OrderDTO> getOrder() {
        String name = RpcContext.getServiceContext().getAttachment("name");
        log.info("============ 调用OrderServiceImpl:什么玩意:" + name);
        log.info("============ 调用OrderG2ServiceImpl:G12什么玩意");
        OrderDTO orderDTO = new OrderDTO("g2", "G12什么玩意");
        return Lists.newArrayList(orderDTO);
    }
}
