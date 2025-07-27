package hark.ecom.repositories.products;

import hark.ecom.entities.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Set;

@CrossOrigin("http://localhost:3000")
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Set<Product> findAllByProductNameNotContainingIgnoreCase(String productName);
    Set<Product> findAllByProductNameContainingIgnoreCase(String productName);
}
