package fooddelivery.domain;

import fooddelivery.domain.OrderPlaced;
import fooddelivery.domain.OrdeCancelled;
import fooddelivery.CustomerApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Order_table")
@Data

public class Order  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String menuName;
    
    
    
    
    
    private Integer qty;
    
    
    
    
    
    private Long customerId;
    
    
    
    
    
    private Long menuId;
    
    
    
    
    
    private Integer price;
    
    
    
    
    
    private String orderState;
    
    
    
    
    
    private String address;

    @PostPersist
    public void onPostPersist(){

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        fooddelivery.external.Payment payment = new fooddelivery.external.Payment();
        // mappings goes here
        CustomerApplication.applicationContext.getBean(fooddelivery.external.PaymentService.class)
            .pay(payment);


        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();



        OrdeCancelled ordeCancelled = new OrdeCancelled(this);
        ordeCancelled.publishAfterCommit();

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = CustomerApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }




    public static void orderStateComplete(DeliveryCompleted deliveryCompleted){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCompleted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }


}
