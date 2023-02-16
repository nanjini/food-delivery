package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrdeCancelled extends AbstractEvent {

    private Long id;

    public OrdeCancelled(Order aggregate){
        super(aggregate);
    }
    public OrdeCancelled(){
        super();
    }
}
