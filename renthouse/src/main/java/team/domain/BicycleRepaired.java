package team.domain;

import team.domain.*;
import team.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class BicycleRepaired extends AbstractEvent {

    private Long productId;
    private String productName;
    private Long rentUnitPrice;
    private Boolean rentAvailable;

    public BicycleRepaired(Management aggregate){
        super(aggregate);
    }
    public BicycleRepaired(){
        super();
    }
}
