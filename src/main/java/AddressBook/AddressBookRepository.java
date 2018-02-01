package AddressBook;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "book", path = "book")
public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {
    AddressBook findById(Long id);
}
