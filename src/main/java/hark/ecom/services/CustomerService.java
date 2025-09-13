package hark.ecom.services;

import hark.ecom.entities.Customer;
import hark.ecom.repositories.customers.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findCustomerById(long id) {

        Optional<Customer> self = customerRepository.findById(id);
        return self.orElse(null);
    }
}
