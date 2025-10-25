package hark.ecom.services;

import hark.ecom.entities.customers.Customer;
import hark.ecom.entities.customers.CustomerAuth;
import hark.ecom.repositories.customers.CustomerAuthRepository;
import hark.ecom.repositories.customers.CustomerRepository;
import hark.ecom.security.Hash;
import hark.ecom.validators.ValidPassword;
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
//        decrypt
//        validate
        String password = Hash.bCrypt(pwd);

        CustomerAuth customerAuth = new CustomerAuth();
        customerAuth.setCustomer(customer);
        customerAuth.setPassword(password);
        customerAuth.setUsername(customer.getUsername());
        customerAuthRepository.save(customerAuth);
        return "Auth Created Successfully";
    }

    public Customer editCustomer(Customer customer, String pwd) {

        String password = Hash.bCrypt(pwd);
//        CustomerAuth customerAuth = customerAuthRepository.findByPasswordAndUsername(password, customer.getUsername());


        return customerRepository.saveAndFlush(customer);
    }

    public Customer findCustomerById(long id) {

        Optional<Customer> self = customerRepository.findById(id);
        return self.orElse(null);
    }

    public String signin(String username, String pwd) {

//        decrypt
//        if (ValidPassword.validPassword(pwd)) {
        if (true) {

                String password = Hash.bCrypt(pwd);

                if (username == null || pwd == null) {
                    return "Username or password is empty";
                } else {

                    CustomerAuth realAuth = customerAuthRepository.findByPasswordAndUsername(password, username);

                    Customer customer = realAuth.getCustomer();

                    if (realAuth == null) {
                        return "No match found for username or password";
                    } else {

                        return customer.getId().toString();
                    }
                }
            } else {
                return "Invalid password";
            }
        }
}
