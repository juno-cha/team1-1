package team.infra;
import team.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@RestController
// @RequestMapping(value="/managements")
@Transactional
public class ManagementController {
    @Autowired
    ManagementRepository managementRepository;




    @RequestMapping(value = "managements/{id}/bikerepair",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Management bikeRepair(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /management/bikeRepair  called #####");
            Optional<Management> optionalManagement = managementRepository.findById(id);
            
            optionalManagement.orElseThrow(()-> new Exception("No Entity Found"));
            Management management = optionalManagement.get();
            management.bikeRepair();
            
            managementRepository.save(management);
            return management;
            
    }
    



    @RequestMapping(value = "managements/{id}/bikerepaircomplete",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Management bikeRepairComplete(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /management/bikeRepairComplete  called #####");
            Optional<Management> optionalManagement = managementRepository.findById(id);
            
            optionalManagement.orElseThrow(()-> new Exception("No Entity Found"));
            Management management = optionalManagement.get();
            management.bikeRepairComplete();
            
            managementRepository.save(management);
            return management;
            
    }
    



}
