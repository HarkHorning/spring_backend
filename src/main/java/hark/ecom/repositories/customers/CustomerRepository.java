package hark.ecom.repositories.customers;

import hark.ecom.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:3000")
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
//    Customer findById(@Param("id") long id);
}
