package hark.ecom.services;

import hark.ecom.entities.customers.Customer;
import hark.ecom.entities.customers.CustomerAuth;
import hark.ecom.repositories.customers.CustomerAuthRepository;
import hark.ecom.repositories.customers.CustomerRepository;
import hark.ecom.security.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    private CustomerAuthRepository customerAuthRepository;

    public CustomerService(CustomerRepository customerRepository, CustomerAuthRepository customerAuthRepository) {
        this.customerRepository = customerRepository;
        this.customerAuthRepository = customerAuthRepository;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public String createAuth(Customer customer, String pwd) {
        String password = Hash.bCrypt(pwd);
        CustomerAuth customerAuth = new CustomerAuth();
        customerAuth.setCustomer(customer);
        customerAuth.setPassword(password);
        customerAuth.setUsername(customer.getUsername());
        customerAuthRepository.save(customerAuth);
        return "Auth Created Successfully";
    }

    public Customer findCustomerById(long id) {

        Optional<Customer> self = customerRepository.findById(id);
        return self.orElse(null);
    }
}
