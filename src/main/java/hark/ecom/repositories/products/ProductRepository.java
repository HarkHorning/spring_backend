package hark.ecom.repositories.products;

import hark.ecom.entities.Portfolio;
import hark.ecom.entities.products.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Set;

@CrossOrigin("http://localhost:3000")
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Set<Product> findAllByProductNameNotContainingIgnoreCase(String productName);
    Set<Product> findAllByProductNameContainingIgnoreCase(String productName);

    List<Product> getProductByPortfolio_Id(int portfolioId);


    List<Product> getAProductByPortfolio_Id(int portfolioId, Sort sort);

    List<Product> getAllByPortfolio(Portfolio portfolio);

    @Query(value = "SELECT * FROM product LIMIT ?1", nativeQuery = true)
    List<Product> findTopNEntities(int limit);
}
