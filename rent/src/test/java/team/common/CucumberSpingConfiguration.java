package team.common;


import team.RentApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { RentApplication.class })
public class CucumberSpingConfiguration {
    
}
