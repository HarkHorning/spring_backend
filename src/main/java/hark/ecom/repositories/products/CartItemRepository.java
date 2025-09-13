package hark.ecom.repositories.products;

import hark.ecom.entities.Cart;
import hark.ecom.entities.products.CartItem;
import hark.ecom.entities.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {
    List<CartItem> findAllByProduct(Product productId);

    CartItem findByCart(Cart cart);
}
