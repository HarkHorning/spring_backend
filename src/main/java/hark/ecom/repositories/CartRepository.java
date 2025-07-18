package hark.ecom.repositories;

import hark.ecom.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:3000")
@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
}
