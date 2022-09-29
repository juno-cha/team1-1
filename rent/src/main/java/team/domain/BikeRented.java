package team.domain;

import team.domain.*;
import team.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class BikeRented extends AbstractEvent {

    private Long orderId;
    private Long productId;
    private Date startTime;
    private Date endTime;
    private Long rentHour;
    private Long totalPrice;

    public BikeRented(Rent aggregate){
        super(aggregate);
    }
    public BikeRented(){
        super();
    }
}
