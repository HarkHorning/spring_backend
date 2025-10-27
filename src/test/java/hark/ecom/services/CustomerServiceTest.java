package hark.ecom.services;

import hark.ecom.entities.Customer;
import hark.ecom.entities.CustomerAuth;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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