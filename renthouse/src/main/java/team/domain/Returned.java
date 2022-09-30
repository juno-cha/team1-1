package team.domain;

import team.domain.*;
import team.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Returned extends AbstractEvent {

    private Long orderId;
    private Long productId;
    private Date startTime;
    private Date endTime;
    private Long rentHour;
    private Long totalPrice;
}


