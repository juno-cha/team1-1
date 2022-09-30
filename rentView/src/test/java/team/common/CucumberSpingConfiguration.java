package team.common;


import team.RentViewApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { RentViewApplication.class })
public class CucumberSpingConfiguration {
    
}
