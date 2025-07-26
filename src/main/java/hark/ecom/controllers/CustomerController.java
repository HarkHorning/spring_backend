package hark.ecom.controllers;

import hark.ecom.entities.Customer;
import hark.ecom.repositories.CustomerRepository;
import hark.ecom.services.CartService;
import hark.ecom.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin("http://localhost:3000")
public class CustomerController {

    private final CustomerService customerService;
    private final CartService cartService;

    @Autowired
    public CustomerController(CustomerService customerService, CartService cartService) {
        this.customerService = customerService;
        this.cartService = cartService;
    }

    @PostMapping("/signup")
    public Customer newCustomer(@RequestBody Customer customer) {
        cartService.createCart(customer);
        return customerService.createCustomer(customer);
    }

    @RequestMapping("/self")
    public Customer findCustomerById(@Param("id") long id) {
        return customerService.findCustomerById(id);
    }
}
