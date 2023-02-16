package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class PaymentSuccessed extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Integer price;

    public PaymentSuccessed(Payment aggregate){
        super(aggregate);
    }
    public PaymentSuccessed(){
        super();
    }
}
