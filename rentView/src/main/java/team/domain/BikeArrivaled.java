package team.domain;

import team.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class BikeArrivaled extends AbstractEvent {

    private Long productId;
    private String productName;
    private Long rentUnitPrice;
    private Boolean rentAvailable;
}
