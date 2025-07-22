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

    @PostMapping("/additem")
    public String addItem(@RequestBody Cart cart, @Param("id") long id) {
        return cartService.addItem(cart, id);
    }
}
