package team.domain;

import team.domain.BikeArrivaled;
import team.domain.BicycleRepaired;
import team.domain.BikeRepairCompleted;
import team.RentHouseApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Management_table")
@Data

public class Management  {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long productId;

    private String productName;

    private Long rentUnitPrice;

    private Boolean rentAvailable;

    @PostPersist
    public void onPostPersist(){
        BikeArrivaled bikeArrivaled = new BikeArrivaled(this);
        bikeArrivaled.publishAfterCommit();

        BicycleRepaired bicycleRepaired = new BicycleRepaired(this);
        bicycleRepaired.publishAfterCommit();

        BikeRepairCompleted bikeRepairCompleted = new BikeRepairCompleted(this);
        bikeRepairCompleted.publishAfterCommit();

    }

    public static ManagementRepository repository(){
        ManagementRepository managementRepository = RentHouseApplication.applicationContext.getBean(ManagementRepository.class);
        return managementRepository;
    }

    /*
     * 자전거 상태 변경(신규상품입고)
     * 
     * @param
     * productId
     * productName
     * rentUnitPrice
     * rentAvailable    -- true
     */
    public static void bikeConditionChange(BikeArrivaled bikeArrivaled){

        /** Example 1:  new item    */
        Management management = new Management();
        management.setProductName(bikeArrivaled.getProductName());
        management.setRentUnitPrice(bikeArrivaled.getRentUnitPrice());
        management.setRentAvailable(true);
        repository().save(management);
    }

    /*
     * 자전거 상태 변경(수리)
     * 
     * @param
     * productId
     * productName
     * rentUnitPrice
     * rentAvailable    -- false
     */
    public static void bikeConditionChange(BicycleRepaired bicycleRepaired){
        /** Example 2:  finding and process */
        
        repository().findById(bicycleRepaired.getProductId()).ifPresent(management->{
            
            //management // do something
            // management.setProductId(bicycleRepaired.getProductId());
            // management.setProductName(bicycleRepaired.getProductName());
            // management.setRentUnitPrice(bicycleRepaired.getRentUnitPrice());
            management.setRentAvailable(false);

            repository().save(management);
         });
    }

    /*
     * 자전거 상태 변경(대여)
     * 
     * @param
     * productId
     * productName
     * rentUnitPrice
     * rentAvailable    -- false
     */
    public static void bikeConditionChange(Paid paid){
        /** Example 2:  finding and process     */
        
        repository().findById(paid.getProductId()).ifPresent(management->{
            
            //management // do something
            // management.setProductId(bicycleRepaired.getProductId());
            // management.setProductName(bicycleRepaired.getProductName());
            // management.setRentUnitPrice(bicycleRepaired.getRentUnitPrice());
            management.setRentAvailable(false);

            repository().save(management);

         });
        

        
    }

    /*
     * 자전거 상태 변경(반납)
     * 
     * @param
     * productId
     * productName
     * rentUnitPrice
     * rentAvailable    -- true
     */
    public static void bikeConditionChange(Returned returned){
        /** Example 2:  finding and process     */
        
        repository().findById(returned.getProductId()).ifPresent(management->{
            //management // do something
            // management.setProductId(bicycleRepaired.getProductId());
            // management.setProductName(bicycleRepaired.getProductName());
            // management.setRentUnitPrice(bicycleRepaired.getRentUnitPrice());
            management.setRentAvailable(true);
            repository().save(management);

         });
        
    }

    /*
     * 자전거 상태 변경(수리완료)
     * 
     * @param
     * productId
     * productName
     * rentUnitPrice
     * rentAvailable    -- true
     */
    public static void bikeConditionChange(BikeRepairCompleted bikeRepairCompleted){
        /** Example 2:  finding and process */
        
        repository().findById(bikeRepairCompleted.getProductId()).ifPresent(management->{
            //management // do something
            // management.setProductId(bicycleRepaired.getProductId());
            // management.setProductName(bicycleRepaired.getProductName());
            // management.setRentUnitPrice(bicycleRepaired.getRentUnitPrice());
            management.setRentAvailable(true);
            repository().save(management);
         });
        

        
    }


}
