package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderManagementAccepted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long menuId;
    private String address;

    public OrderManagementAccepted(OrderManagement aggregate){
        super(aggregate);
    }
    public OrderManagementAccepted(){
        super();
    }
}
