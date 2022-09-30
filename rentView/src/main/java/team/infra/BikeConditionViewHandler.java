package team.infra;

import team.domain.*;
import team.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BikeConditionViewHandler {


    @Autowired
    private BikeConditionRepository bikeConditionRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBikeArrivaled_then_CREATE_1 (@Payload BikeArrivaled bikeArrivaled) {
        try {

            if (!bikeArrivaled.validate()) return;

            // view 객체 생성
            BikeCondition bikeCondition = new BikeCondition();
            // view 객체에 이벤트의 Value 를 set 함
            bikeCondition.setId(bikeArrivaled.getProductId());
            bikeCondition.setRentCount(0);
            // view 레파지 토리에 save
            bikeConditionRepository.save(bikeCondition);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenBikeRented_then_UPDATE_1(@Payload BikeRented bikeRented) {
        try {
            if (!bikeRented.validate()) return;
                // view 객체 조회
            Optional<BikeCondition> bikeConditionOptional = bikeConditionRepository.findById(bikeRented.getProductId());

            if( bikeConditionOptional.isPresent()) {
                 BikeCondition bikeCondition = bikeConditionOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                bikeCondition.setRentCount(bikeCondition.getRentCount() + 1);
                // view 레파지 토리에 save
                 bikeConditionRepository.save(bikeCondition);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenRentalCanceled_then_UPDATE_2(@Payload RentalCanceled rentalCanceled) {
        try {
            if (!rentalCanceled.validate()) return;
                // view 객체 조회
            Optional<BikeCondition> bikeConditionOptional = bikeConditionRepository.findById(rentalCanceled.getProductId());

            if( bikeConditionOptional.isPresent()) {
                 BikeCondition bikeCondition = bikeConditionOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                bikeCondition.setRentCount(bikeCondition.getRentCount() - 1);
                // view 레파지 토리에 save
                 bikeConditionRepository.save(bikeCondition);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

