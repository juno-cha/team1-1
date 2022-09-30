package team.domain;

import java.util.*;
import lombok.Data;
import team.infra.AbstractEvent;

@Data
public class Paid extends AbstractEvent {

    private Long id;
    private Long totalPrice;
    private Long productId;
    private String cancelYN;
    private Long orderId;
}
