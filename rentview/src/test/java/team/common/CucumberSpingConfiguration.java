package team.common;


import team.RentviewApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { RentviewApplication.class })
public class CucumberSpingConfiguration {
    
}
