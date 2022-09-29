package team.infra;

import team.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="timeCounteds", path="timeCounteds")
public interface TimeCountedRepository extends PagingAndSortingRepository<TimeCounted, Long> {

    

    
}
