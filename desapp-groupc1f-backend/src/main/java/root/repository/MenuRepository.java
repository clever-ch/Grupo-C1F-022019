package root.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import root.model.Menu;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Long> {

}
