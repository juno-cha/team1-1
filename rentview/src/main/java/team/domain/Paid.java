package team.domain;

import team.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class Paid extends AbstractEvent {

    private Long id;
    private Long totalPrice;
    private Long productId;
    private String cancelYN;
    private Long orderId;
}
