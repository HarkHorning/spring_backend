package hark.ecom.services;

import hark.ecom.entities.customers.Customer;
import hark.ecom.entities.customers.CustomerAuth;
import hark.ecom.repositories.customers.CustomerAuthRepository;
import hark.ecom.repositories.customers.CustomerRepository;
import hark.ecom.repositories.products.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest
class CustomerServiceTest {

//    @Mock
//    @Autowired
//    private CustomerRepository customerRepository;
//    private CustomerAuthRepository customerAuthRepository;

//    @InjectMocks
//    private CustomerService customerService;

    //create customer
    @BeforeEach
    @Test
    void createCustomer() {
        Customer customer = new Customer();
        Assertions.assertNotNull(customer);
        customer.setFirstName("FirstName");
        customer.setLastName("LastName");
        Assertions.assertEquals("FirstName", customer.getFirstName());
        Assertions.assertEquals("LastName", customer.getLastName());
//        customerRepository.save(customer);
    }

    @Test
    void createAuth() {
        Customer customer = new Customer();
        Assertions.assertNotNull(customer);
        customer.setFirstName("FirstName");
        customer.setLastName("LastName");
        Assertions.assertEquals("FirstName", customer.getFirstName());
        Assertions.assertEquals("LastName", customer.getLastName());
        CustomerAuth customerAuth = new CustomerAuth();
        Assertions.assertNotNull(customerAuth);
        customerAuth.setCustomer(customer);
        Assertions.assertNotNull(customerAuth.getCustomer());
        customerAuth.setPassword("password");
        customerAuth.setUsername("username");
        Assertions.assertEquals("password", customerAuth.getPassword());
        Assertions.assertEquals("username", customerAuth.getUsername());
    }

    @Test
    void editCustomer() {
    }

    @Test
    void findCustomerById() {
    }

//    @AfterEach
    @Test
    void signin() {

    }
}