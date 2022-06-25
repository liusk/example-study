package com.example.web;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.rpc.cluster.Merger;
import study.example.order.dto.OrderDTO;

import java.util.List;

/**
 * @author liusk
 */
@Slf4j
public class CustomeMerger implements Merger<List<OrderDTO>> {

    @Override
    public List<OrderDTO> merge(List<OrderDTO>... items) {
        log.info("==========================" + items.length);

        List<OrderDTO> result = Lists.newArrayList();
        for (List<OrderDTO> item : items) {
            result.addAll(item);
        }

        return result;
    }
}
