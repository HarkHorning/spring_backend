package hark.ecom.controllers;

import hark.ecom.entities.customers.Customer;
import hark.ecom.entities.customers.CustomerAuth;
import hark.ecom.repositories.customers.CustomerAuthRepository;
import hark.ecom.services.CartService;
import hark.ecom.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

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
    public Customer newCustomer(@Param("pwd") String pwd, @RequestBody Customer customer) {
        cartService.createCart(customer);
        customerService.createAuth(customer, pwd);
        return customerService.createCustomer(customer);
    }

    @PostMapping("/signin")
    public String signin(@Param("pwd") String pwd, @Param("username")  String username, @Param("password") String password) {
        return customerService.signin(username, pwd);
    }

    @PostMapping("/editcustomer")
    public Customer editCustomer(@Param("pwd") String pwd, @RequestBody Customer customer) {
        return customerService.editCustomer(customer, pwd);
    }

    @RequestMapping("/self")
    public Customer findCustomerById(@Param("id") long id) {
        return customerService.findCustomerById(id);
    }
}
