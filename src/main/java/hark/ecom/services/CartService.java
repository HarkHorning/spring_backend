package hark.ecom.services;

import hark.ecom.entities.Cart;
import hark.ecom.entities.Customer;
import hark.ecom.entities.enums.CartStatus;
import hark.ecom.entities.products.CartItem;
import hark.ecom.entities.products.Product;
import hark.ecom.repositories.CartRepository;
import hark.ecom.repositories.CustomerRepository;
import hark.ecom.repositories.products.CartItemRepository;
import hark.ecom.repositories.products.ProductRepository;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CartService {

    @Autowired
    private static CartRepository cartRepository;
    private CartItemRepository cartItemRepository;
    private ProductRepository productRepository;

    public CartService(CartRepository cartRepository, CartItemRepository cartItemRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
    }

    public String createCart(Customer customer) {

        Cart cart = new Cart();
        cart.setStatus(CartStatus.pending);
        cart.setOrderTrackingNumber(generateOrderTrackingNumber());
        cart.setCustomer(customer);
        cartRepository.save(cart);

        return "";
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }

    public Cart cartbyid(long id) {
        return cartRepository.findById(id).orElse(null);
    }

    public static Cart cartByUserId(long id) {
        return cartRepository.findByCustomerId(id);
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

    public String removeItem(Long cartId, Long productId) {
//        Product product = productRepository.findById(productId).orElse(null);
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if (cart == null || cart.getCartItems() == null || cart.getCartItems().isEmpty()) {
            return "Failed to find cart with id: " + cartId;
        } else {
            CartItem cartItem = cartItemRepository.findById(productId).orElse(null);
            if (cartItem == null) {
                return "Failed to find product with id: " + productId;
            } else {
                cartItemRepository.delete(cartItem);
                
                return "Successfully removed product with id: " + productId;
            }
        }
    }
}
