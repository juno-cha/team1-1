package team.domain;

import team.RenthouseApplication;
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
    }

    public static ManagementRepository repository(){
        ManagementRepository managementRepository = RenthouseApplication.applicationContext.getBean(ManagementRepository.class);
        return managementRepository;
    }



    public void bikeArrival(){
        BikeArrivaled bikeArrivaled = new BikeArrivaled(this);
        bikeArrivaled.publishAfterCommit();

    }
    public void bikeRepair(){
        BicycleRepaired bicycleRepaired = new BicycleRepaired(this);
        bicycleRepaired.publishAfterCommit();

    }
    public void bikeRepairComplete(){
        BikeRepairCompleted bikeRepairCompleted = new BikeRepairCompleted(this);
        bikeRepairCompleted.publishAfterCommit();

    }

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
