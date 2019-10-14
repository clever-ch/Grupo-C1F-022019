package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.Menu;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Long> {

}
