package hark.ecom.repositories;

import hark.ecom.entities.Portfolio;
import hark.ecom.entities.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000")
@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio,Long> {
    List<Portfolio> findAllByVendor(Vendor vendor);
}
