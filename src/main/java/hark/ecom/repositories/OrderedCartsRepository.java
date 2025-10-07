package hark.ecom.repositories;

import hark.ecom.entities.OrderedCart;
import hark.ecom.entities.customers.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000")
@Repository
public interface OrderedCartsRepository extends JpaRepository<OrderedCart,Long> {
    List<OrderedCart> findAllByCustomerId(long id);
}
