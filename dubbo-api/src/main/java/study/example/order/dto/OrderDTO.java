package study.example.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import study.example.order.BaseDTO;

/**
 * @author liusk
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO extends BaseDTO {
    private String id;
    private String orderName;
}
