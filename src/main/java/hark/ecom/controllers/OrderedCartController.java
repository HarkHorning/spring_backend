package hark.ecom.controllers;

import hark.ecom.entities.OrderedCart;
import hark.ecom.services.OrderedCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ordered")
@CrossOrigin("http://localhost:3000")
public class OrderedCartController {

    private OrderedCartService orderedCartService;

    @Autowired
    public OrderedCartController(OrderedCartService orderedCartService) {
        this.orderedCartService = orderedCartService;
    }

    @RequestMapping("items")
    public OrderedCart items(@Param("cu_id") Long cu_id) {
        return orderedCartService.getItems(cu_id);
    }
}
