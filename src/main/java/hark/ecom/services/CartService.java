package hark.ecom.services;

import hark.ecom.entities.Cart;
import hark.ecom.entities.OrderedCart;
import hark.ecom.entities.OrderedCartItem;
import hark.ecom.entities.customers.Customer;
import hark.ecom.entities.enums.CartStatus;
import hark.ecom.entities.products.CartItem;
import hark.ecom.entities.products.Product;
import hark.ecom.repositories.CartRepository;
import hark.ecom.repositories.OrderedCartItemRepository;
import hark.ecom.repositories.OrderedCartsRepository;
import hark.ecom.repositories.customers.CustomerRepository;
import hark.ecom.repositories.products.CartItemRepository;
import hark.ecom.repositories.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CartService {

    @Autowired
    private static CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final OrderedCartsRepository orderedCartsRepository;
    private final OrderedCartItemRepository orderedCartItemRepository;


    public CartService(CartRepository cartRepository, CartItemRepository cartItemRepository, ProductRepository productRepository, CustomerRepository customerRepository, OrderedCartsRepository orderedCartsRepository, OrderedCartItemRepository orderedCartItemRepository) {
        CartService.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.orderedCartsRepository = orderedCartsRepository;
        this.orderedCartItemRepository = orderedCartItemRepository;
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
        String productName = product.getProductName();
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

            return "Successfully added product, " + productName + ", to your cart!";
        }
    }

    public String removeItem(Long cartId, Long productId) {
//        Product product = productRepository.findById(productId).orElse(null);
        CartItem cartItem = null;
        Cart cart = cartRepository.findById(cartId).orElse(null);

        if (cart == null || cart.getCartItems() == null || cart.getCartItems().isEmpty()) {
            return "There are no items in cart with id: " + cartId;
        } else {
            List<CartItem> cartItems = null;

            for (CartItem item : cart.getCartItems()) {
                System.out.println(item);
                if (item.getProduct().getId() == productId) {
//                    cartItem = item;
                    cartItemRepository.delete(item);
                    return "Successfully removed product with id: " + productId;
                }
            }
            
            return "Failed to find product with id: " + productId;
        }
    }

    public String buyCart(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        Cart cart = null;
        if (customer != null) {
            cart = cartRepository.findByCustomerId(customer.getId());
        }
//        CartItem cartItem = cartItemRepository.findByCart(cart);
        if (cart == null) {
            return "Failed to find cart";
        } else  {

            OrderedCart orderedCart = new OrderedCart();
            orderedCart.setCustomer(customer);
            orderedCart.setOrderTrackingNumber(generateOrderTrackingNumber());
            List<CartItem> cartItems = cart.getCartItems();
            orderedCart.setStatus(CartStatus.ordered);
            List<OrderedCartItem> orderedCartItems = new ArrayList<>();
            for  (CartItem item : cartItems) {
                OrderedCartItem thisItem = new OrderedCartItem();
                thisItem.setOrderedCart(orderedCart);
                thisItem.setProduct(item.getProduct());
                orderedCartItems.add(thisItem);
            }
            orderedCart.setOrderedCartItems(orderedCartItems);
            orderedCartsRepository.save(orderedCart);
            orderedCartItemRepository.saveAll(orderedCartItems);


            cartItemRepository.deleteAll(cart.getCartItems());
            cart.getCartItems().clear();
            cartRepository.save(cart);

            return "Successfully bought a cart with id: " + cart.getId();
        }
    }
}
