package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderManagementStateStarted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String orderState;

    public OrderManagementStateStarted(OrderManagement aggregate){
        super(aggregate);
    }
    public OrderManagementStateStarted(){
        super();
    }
}
