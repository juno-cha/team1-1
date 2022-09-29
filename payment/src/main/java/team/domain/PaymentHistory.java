package team.domain;

import team.domain.Paid;
import team.PaymentApplication;
import javax.persistence.*;
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




    public static void cancelRequest(RentalCanceled rentalCanceled){

        /** Example 1:  new item 
        PaymentHistory paymentHistory = new PaymentHistory();
        repository().save(paymentHistory);

        */

        /** Example 2:  finding and process
        
        repository().findById(rentalCanceled.get???()).ifPresent(paymentHistory->{
            
            paymentHistory // do something
            repository().save(paymentHistory);


         });
        */

        
    }
    public static void payment(BikeRented bikeRented){

        /** Example 1:  new item 
        PaymentHistory paymentHistory = new PaymentHistory();
        repository().save(paymentHistory);

        */

        /** Example 2:  finding and process
        
        repository().findById(bikeRented.get???()).ifPresent(paymentHistory->{
            
            paymentHistory // do something
            repository().save(paymentHistory);


         });
        */

        
    }


}
