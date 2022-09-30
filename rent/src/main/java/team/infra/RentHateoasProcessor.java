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
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/rentalcancel").withRel("rentalcancel"));
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/return").withRel("return"));

        
        return model;
    }
    
}
