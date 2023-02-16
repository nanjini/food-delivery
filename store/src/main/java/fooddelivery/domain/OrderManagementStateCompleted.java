package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderManagementStateCompleted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long menuId;
    private String orderState;
    private String address;

    public OrderManagementStateCompleted(OrderManagement aggregate){
        super(aggregate);
    }
    public OrderManagementStateCompleted(){
        super();
    }
}
