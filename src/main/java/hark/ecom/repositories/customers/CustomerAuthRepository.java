package hark.ecom.repositories.customers;

import hark.ecom.entities.customers.CustomerAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:3000")
@Repository
public interface CustomerAuthRepository extends JpaRepository<CustomerAuth,Long> {
    CustomerAuth findByPasswordAndUsername(String password, String username);
}
