package hark.ecom.controllers;

import hark.ecom.entities.Cart;
import hark.ecom.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin("http://localhost:3000")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping("/cartbyid")
    public Cart cartbyid(@Param("id") long id) {
        return cartService.cartbyid(id);
    }

    @RequestMapping("/cartbyuserid")
    public Cart cartByUserId(@Param("id") long id) {
        return CartService.cartByUserId(id);
    }

    @PostMapping("/additem")
    public String addItem(@Param("ca_id") Long ca_id, @Param("pr_id") Long pr_id) {
        return cartService.addItem(ca_id, pr_id);
    }

    @PostMapping("/removeitem")
    public String removeItem(@Param("ca_id") Long ca_id, @Param("pr_id") Long pr_id) {
        return cartService.removeItem(ca_id, pr_id);
    }

    @PostMapping("/buycart")
    public String buycart(@Param("ca_id") Long ca_id) {
        return cartService.buyCart(ca_id);
    }
}
