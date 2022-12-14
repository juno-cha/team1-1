package team.domain;

import team.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="managements", path="managements")
public interface ManagementRepository extends PagingAndSortingRepository<Management, Long>{

}
