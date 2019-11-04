package root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import root.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{

}
