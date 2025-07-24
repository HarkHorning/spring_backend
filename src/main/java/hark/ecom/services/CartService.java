package hark.ecom.services;

import hark.ecom.entities.Cart;
import hark.ecom.entities.products.CartItem;
import hark.ecom.entities.products.Product;
import hark.ecom.repositories.CartRepository;
import hark.ecom.repositories.products.CartItemRepository;
import hark.ecom.repositories.products.ProductRepository;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;
    private ProductRepository productRepository;

    public CartService(CartRepository cartRepository, CartItemRepository cartItemRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
    }

    public Cart cartbyid(long id) {
        return cartRepository.findById(id).orElse(null);
    }

    public String addItem(Long cartId, Long productId) {

        Product product = productRepository.findById(productId).orElse(null);
        Cart cart = cartRepository.findById(cartId).orElse(null);

        if (product == null || cart == null) {
            return "Failed to find product with id: " + productId;
        } else {

            CartItem cartItem = new CartItem();
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItemRepository.save(cartItem);

            List<CartItem> cartItemList = cart.getCartItems();
            cartItemList.add(cartItem);
//            cart.setCartItems(cartItemList);
            cartRepository.save(cart);

            return "Successfully added product with id: " + productId;
        }
    }
}
