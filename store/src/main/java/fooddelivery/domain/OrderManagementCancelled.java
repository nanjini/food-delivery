package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderManagementCancelled extends AbstractEvent {

    private Long id;

    public OrderManagementCancelled(OrderManagement aggregate){
        super(aggregate);
    }
    public OrderManagementCancelled(){
        super();
    }
}
