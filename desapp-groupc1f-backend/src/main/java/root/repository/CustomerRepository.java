package root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import root.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
