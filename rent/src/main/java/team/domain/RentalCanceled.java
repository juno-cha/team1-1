package team.domain;

import team.domain.*;
import team.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class RentalCanceled extends AbstractEvent {

    private Long orderId;
    private Long productId;
    private Date startTime;
    private Date endTime;
    private Long rentHour;
    private Long totalPrice;

    public RentalCanceled(Rent aggregate){
        super(aggregate);
    }
    public RentalCanceled(){
        super();
    }
}
