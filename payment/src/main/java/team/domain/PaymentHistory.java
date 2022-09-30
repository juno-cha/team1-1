package team.domain;

import team.domain.Paid;
import zipkin2.internal.DateUtil;
import team.PaymentApplication;
import javax.persistence.*;

import ch.qos.logback.classic.pattern.DateConverter;

import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="PaymentHistory_table")
@Data

public class PaymentHistory  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private Long totalPrice;
    
    private Long productId;
    
    private String cancelYn;
    
    private Long orderId;

    @PostPersist
    public void onPostPersist(){
        Paid paid = new Paid(this);
        paid.publishAfterCommit();
    }

    public static PaymentHistoryRepository repository(){
        PaymentHistoryRepository paymentHistoryRepository = PaymentApplication.applicationContext.getBean(PaymentHistoryRepository.class);
        return paymentHistoryRepository;
    }

    /**
     * 예약취소
     * 
     * @param
     * productId
     * startTime        -- 자동계산
     * endTime          -- 자동계산
     * rentHour
     * totalPrice       -- 자동계산
     */
    public static void cancelRequest(RentalCanceled rentalCanceled){

        /** Example 1:  new item 
        PaymentHistory paymentHistory = new PaymentHistory();
        repository().save(paymentHistory);

        */

        /** Example 2:  finding and process */
        
        repository().findById(rentalCanceled.getOrderId()).ifPresent(paymentHistory->{
            

            //paymentHistory // do something
            //paymentHistory.setProductId(rentalCanceled.getProductId());
            //paymentHistory.setTotalPrice(rentalCanceled.getTotalPrice());
            paymentHistory.setOrderId(rentalCanceled.getOrderId());
            paymentHistory.setCancelYn("Y");
            repository().save(paymentHistory);

         });
        
    }

    /**
     * 예약
     * 
     * @param
     * productId
     * startTime        -- 자동계산
     * endTime          -- 자동계산
     * rentHour
     * totalPrice       -- 자동계산
     */
    public static void payment(BikeRented bikeRented){

        /** Example 1:  new item */
        PaymentHistory paymentHistory = new PaymentHistory();
        paymentHistory.setProductId(bikeRented.getProductId());
        paymentHistory.setOrderId(bikeRented.getOrderId());
        paymentHistory.setTotalPrice(bikeRented.getTotalPrice());
        paymentHistory.setCancelYn("N");
        repository().save(paymentHistory);

        

        /** Example 2:  finding and process
        
        repository().findById(bikeRented.get???()).ifPresent(paymentHistory->{
            
            paymentHistory // do something
            repository().save(paymentHistory);


         });
        */
    }
}
