package AddressBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "buddy", path = "buddy")
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long>{
    List<BuddyInfo> findByName(String name);
    BuddyInfo findById(Long id);
}
