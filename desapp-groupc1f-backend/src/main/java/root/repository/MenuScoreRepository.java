package root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import root.model.MenuScore;

@Repository
public interface MenuScoreRepository extends JpaRepository<MenuScore, Long>{

}
