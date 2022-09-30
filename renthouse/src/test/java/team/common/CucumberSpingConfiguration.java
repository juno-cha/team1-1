package team.common;


import team.RenthouseApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { RenthouseApplication.class })
public class CucumberSpingConfiguration {
    
}
