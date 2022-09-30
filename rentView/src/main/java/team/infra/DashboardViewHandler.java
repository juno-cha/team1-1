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
public class DashboardViewHandler {


    @Autowired
    private DashboardRepository dashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBikeRented_then_CREATE_1 (@Payload BikeRented bikeRented) {
        try {

            if (!bikeRented.validate()) return;

            // view 객체 생성
            Dashboard dashboard = new Dashboard();
            // view 객체에 이벤트의 Value 를 set 함
            dashboard.setId(bikeRented.getOrderId());
            dashboard.setRentStatus("Rented");
            // view 레파지 토리에 save
            dashboardRepository.save(dashboard);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenReturned_then_UPDATE_1(@Payload Returned returned) {
        try {
            if (!returned.validate()) return;
                // view 객체 조회
            Optional<Dashboard> dashboardOptional = dashboardRepository.findById(returned.getOrderId());

            if( dashboardOptional.isPresent()) {
                 Dashboard dashboard = dashboardOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setRentStatus("Returned");    
                // view 레파지 토리에 save
                 dashboardRepository.save(dashboard);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaid_then_UPDATE_2(@Payload Paid paid) {
        try {
            if (!paid.validate()) return;
                // view 객체 조회
            Optional<Dashboard> dashboardOptional = dashboardRepository.findById(paid.getOrderId());

            if( dashboardOptional.isPresent()) {
                 Dashboard dashboard = dashboardOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setPaymentStatus("Paid");    
                // view 레파지 토리에 save
                 dashboardRepository.save(dashboard);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

