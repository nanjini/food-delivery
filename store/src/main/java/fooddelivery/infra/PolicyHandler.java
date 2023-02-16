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
    @Autowired OrderManagementRepository orderManagementRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='PaymentSuccessed'")
    public void wheneverPaymentSuccessed_Receipt(@Payload PaymentSuccessed paymentSuccessed){

        PaymentSuccessed event = paymentSuccessed;
        System.out.println("\n\n##### listener Receipt : " + paymentSuccessed + "\n\n");


        

        // Sample Logic //
        OrderManagement.receipt(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrdeCancelled'")
    public void wheneverOrdeCancelled_CancelReceipt(@Payload OrdeCancelled ordeCancelled){

        OrdeCancelled event = ordeCancelled;
        System.out.println("\n\n##### listener CancelReceipt : " + ordeCancelled + "\n\n");


        

        // Sample Logic //
        OrderManagement.cancelReceipt(event);
        

        

    }

}


