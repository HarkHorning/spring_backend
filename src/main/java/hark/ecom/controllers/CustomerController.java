package hark.ecom.controllers;

import hark.ecom.entities.Customer;
import hark.ecom.repositories.CustomerRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin("http://localhost:3000")
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping("/self")
    public Customer getSelf(@Param("id") long id) {

        Optional<Customer> self = customerRepository.findById(id);

        return self.orElse(null);
    }
}
