package team.domain;

import java.util.*;
import lombok.*;
import team.domain.*;
import team.infra.AbstractEvent;

@Data
@ToString
public class BikeArrivaled extends AbstractEvent {

    private Long productId;
    private String productName;
    private Long rentUnitPrice;
    private boolean rentAvailable;

    public BikeArrivaled(Management aggregate) {
        super(aggregate);
    }

    public BikeArrivaled() {
        super();
    }
}
