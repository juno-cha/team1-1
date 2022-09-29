package team.infra;
import team.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class RentHateoasProcessor implements RepresentationModelProcessor<EntityModel<Rent>>  {

    @Override
    public EntityModel<Rent> process(EntityModel<Rent> model) {

        
        return model;
    }
    
}
