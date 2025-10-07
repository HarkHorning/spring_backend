package hark.ecom.controllers;

import hark.ecom.entities.OrderedCart;
import hark.ecom.entities.OrderedCartItem;
import hark.ecom.services.OrderedCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ordered")
@CrossOrigin("http://localhost:3000")
public class OrderedCartController {

    private OrderedCartService orderedCartService;

    @Autowired
    public OrderedCartController(OrderedCartService orderedCartService) {
        this.orderedCartService = orderedCartService;
    }

    @RequestMapping("cart")
    public List<OrderedCart> orderedCart(@Param("id") long id) {
        return orderedCartService.getCart(id);
    }

//    @RequestMapping("items")
//    public List<OrderedCartItem> orderedCartItems(@Param("id") long id) {
//        return orderedCartService.getCartItem(id);
//    }
}
