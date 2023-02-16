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
    @Autowired PaymentRepository paymentRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderManagementCancelled'")
    public void wheneverOrderManagementCancelled_PayCancel(@Payload OrderManagementCancelled orderManagementCancelled){

        OrderManagementCancelled event = orderManagementCancelled;
        System.out.println("\n\n##### listener PayCancel : " + orderManagementCancelled + "\n\n");


        

        // Sample Logic //
        Payment.payCancel(event);
        

        

    }

}


