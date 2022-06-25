package study.example.order.api;

import study.example.order.dto.OrderDTO;

import java.util.List;

/**
 * @author liusk
 */
public interface IOrderService {
    List<OrderDTO> getOrder();
}
