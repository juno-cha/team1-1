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
    @Autowired ManagementRepository managementRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='BikeArrivaled'")
    public void wheneverBikeArrivaled_BikeConditionChange(@Payload BikeArrivaled bikeArrivaled){

        BikeArrivaled event = bikeArrivaled;
        System.out.println("\n\n##### listener BikeConditionChange : " + bikeArrivaled + "\n\n");


        

        // Sample Logic //
        Management.bikeConditionChange(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='BicycleRepaired'")
    public void wheneverBicycleRepaired_BikeConditionChange(@Payload BicycleRepaired bicycleRepaired){

        BicycleRepaired event = bicycleRepaired;
        System.out.println("\n\n##### listener BikeConditionChange : " + bicycleRepaired + "\n\n");


        

        // Sample Logic //
        Management.bikeConditionChange(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Paid'")
    public void wheneverPaid_BikeConditionChange(@Payload Paid paid){

        Paid event = paid;
        System.out.println("\n\n##### listener BikeConditionChange : " + paid + "\n\n");


        

        // Sample Logic //
        Management.bikeConditionChange(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Returned'")
    public void wheneverReturned_BikeConditionChange(@Payload Returned returned){

        Returned event = returned;
        System.out.println("\n\n##### listener BikeConditionChange : " + returned + "\n\n");


        

        // Sample Logic //
        Management.bikeConditionChange(event);
        

        

    }

}


