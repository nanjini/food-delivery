package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class PaymentSuccessed extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Integer price;
}


