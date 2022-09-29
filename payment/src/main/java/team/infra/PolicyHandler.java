package team.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import team.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import team.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired PaymentHistoryRepository paymentHistoryRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='RentalCanceled'")
    public void wheneverRentalCanceled_CancelRequest(@Payload RentalCanceled rentalCanceled){

        RentalCanceled event = rentalCanceled;
        System.out.println("\n\n##### listener CancelRequest : " + rentalCanceled + "\n\n");


        

        // Sample Logic //
        PaymentHistory.cancelRequest(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='BikeRented'")
    public void wheneverBikeRented_Payment(@Payload BikeRented bikeRented){

        BikeRented event = bikeRented;
        System.out.println("\n\n##### listener Payment : " + bikeRented + "\n\n");


        

        // Sample Logic //
        PaymentHistory.payment(event);
        

        

    }

}


