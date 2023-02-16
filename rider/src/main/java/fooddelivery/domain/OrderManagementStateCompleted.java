package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class OrderManagementStateCompleted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long menuId;
    private String orderState;
    private String address;
}


