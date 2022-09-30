package team.domain;

import java.util.*;
import lombok.Data;
import team.infra.AbstractEvent;

@Data
public class BikeRented extends AbstractEvent {

    private Long orderId;
    private Long productId;
    private Date startTime;
    private Date endTime;
    private Long rentHour;
    private Long totalPrice;
}
