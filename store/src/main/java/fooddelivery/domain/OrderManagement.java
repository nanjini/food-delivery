package fooddelivery.domain;

import fooddelivery.domain.OrderManagementAccepted;
import fooddelivery.domain.OrderManagementCancelled;
import fooddelivery.domain.OrderManagementStateStarted;
import fooddelivery.domain.OrderManagementStateCompleted;
import fooddelivery.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="OrderManagement_table")
@Data

public class OrderManagement  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private Long menuId;
    
    
    
    
    
    private String orderState;
    
    
    
    
    
    private String address;

    @PostPersist
    public void onPostPersist(){


        OrderManagementAccepted orderManagementAccepted = new OrderManagementAccepted(this);
        orderManagementAccepted.publishAfterCommit();



        OrderManagementCancelled orderManagementCancelled = new OrderManagementCancelled(this);
        orderManagementCancelled.publishAfterCommit();



        OrderManagementStateStarted orderManagementStateStarted = new OrderManagementStateStarted(this);
        orderManagementStateStarted.publishAfterCommit();



        OrderManagementStateCompleted orderManagementStateCompleted = new OrderManagementStateCompleted(this);
        orderManagementStateCompleted.publishAfterCommit();

    }

    public static OrderManagementRepository repository(){
        OrderManagementRepository orderManagementRepository = StoreApplication.applicationContext.getBean(OrderManagementRepository.class);
        return orderManagementRepository;
    }




    public static void receipt(PaymentSuccessed paymentSuccessed){

        /** Example 1:  new item 
        OrderManagement orderManagement = new OrderManagement();
        repository().save(orderManagement);

        */

        /** Example 2:  finding and process
        
        repository().findById(paymentSuccessed.get???()).ifPresent(orderManagement->{
            
            orderManagement // do something
            repository().save(orderManagement);


         });
        */

        
    }
    public static void cancelReceipt(OrdeCancelled ordeCancelled){

        /** Example 1:  new item 
        OrderManagement orderManagement = new OrderManagement();
        repository().save(orderManagement);

        */

        /** Example 2:  finding and process
        
        repository().findById(ordeCancelled.get???()).ifPresent(orderManagement->{
            
            orderManagement // do something
            repository().save(orderManagement);


         });
        */

        
    }


}
