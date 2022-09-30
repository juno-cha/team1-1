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
// @RequestMapping(value="/rents")
@Transactional
public class RentController {
    @Autowired
    RentRepository rentRepository;




    @RequestMapping(value = "rents/{id}/rentalcancel",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Rent rentalCancel(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /rent/rentalCancel  called #####");
            Optional<Rent> optionalRent = rentRepository.findById(id);
            
            optionalRent.orElseThrow(()-> new Exception("No Entity Found"));
            Rent rent = optionalRent.get();
            rent.rentalCancel();
            
            rentRepository.save(rent);
            return rent;
            
    }
    



    @RequestMapping(value = "rents/{id}/return",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Rent bikeReturn(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /rent/bikeReturn  called #####");
            Optional<Rent> optionalRent = rentRepository.findById(id);
            
            optionalRent.orElseThrow(()-> new Exception("No Entity Found"));
            Rent rent = optionalRent.get();
            rent.bikeReturn();
            
            rentRepository.save(rent);
            return rent;
            
    }
    



}
