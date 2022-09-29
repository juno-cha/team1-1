package team.common;


import team.RentHouseApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { RentHouseApplication.class })
public class CucumberSpingConfiguration {
    
}
