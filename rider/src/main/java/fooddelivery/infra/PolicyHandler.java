package fooddelivery.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import fooddelivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import fooddelivery.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired DeliveryRepository deliveryRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderManagementStateStarted'")
    public void wheneverOrderManagementStateStarted_DeliveryRequest(@Payload OrderManagementStateStarted orderManagementStateStarted){

        OrderManagementStateStarted event = orderManagementStateStarted;
        System.out.println("\n\n##### listener DeliveryRequest : " + orderManagementStateStarted + "\n\n");


        

        // Sample Logic //
        Delivery.deliveryRequest(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderManagementStateCompleted'")
    public void wheneverOrderManagementStateCompleted_DeliveryStart(@Payload OrderManagementStateCompleted orderManagementStateCompleted){

        OrderManagementStateCompleted event = orderManagementStateCompleted;
        System.out.println("\n\n##### listener DeliveryStart : " + orderManagementStateCompleted + "\n\n");


        

        // Sample Logic //
        Delivery.deliveryStart(event);
        

        

    }

}


