package hark.ecom.bootstrap;

import hark.ecom.entities.Customer;
import hark.ecom.entities.products.Product;
import hark.ecom.repositories.CartRepository;
import hark.ecom.repositories.customers.CustomerRepository;
import hark.ecom.repositories.products.ProductRepository;
import hark.ecom.services.CartService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepo;
    private final ProductRepository productRepo;
    private final CartRepository cartRepository;
    private final CartService cartService;

    public BootStrapData(CustomerRepository customerRepo,  ProductRepository productRepo, CartRepository cartRepository, CartService cartService) {
        this.customerRepo = customerRepo;
        this.productRepo = productRepo;
        this.cartRepository = cartRepository;
        this.cartService = cartService;
    }


    @Override
    public void run(String... args) throws Exception {

        Customer customer = new Customer();
        customer.setUsername("BigDiggle32");
        customer.setFirstName("Hark");
        customer.setLastName("Horning");
        customer.setPhone("12345678901");
        customer.setAddress("Streat");

        Customer customer2 = new Customer();
        customer2.setUsername("LilDiggle32");
        customer2.setFirstName("Larry");
        customer2.setLastName("David");
        customer2.setPhone("12345678901");
        customer2.setAddress("Lane");

        Customer[] sampleCustomers = {customer,customer2};

        List<Customer> allCustomers = (List<Customer>) customerRepo.findAll();

        for (Customer sampleCustomer: sampleCustomers) { boolean exists = false;
            for (Customer thisCustomer : allCustomers) {
                if (thisCustomer.getUsername().equals(sampleCustomer.getUsername())) {
                    exists = true;
                }
            }
            if (!exists) {
                // create cart
                cartService.createCart(sampleCustomer);
                customerRepo.save(sampleCustomer);
            }
        }


//        customerRepo.save(customer2);

        Product product = new Product();
        product.setProductName("Sword");
        product.setDescription("Very big sword. Very pointy. If you stab someone, don't tell anyone where you got the sword.");
        product.setProductPrice(BigDecimal.valueOf(12.23));
        product.setProductRating(BigDecimal.valueOf(3.9));
        product.setProductURL("https://picsum.photos/id/1/200");

        Product product2 = new Product();
        product2.setProductName("Spoon");
        product2.setDescription("Can use to eat sandwitch. But that's not really what this is made for. But if you must...");
        product2.setProductPrice(BigDecimal.valueOf(4.21));
        product2.setProductRating(BigDecimal.valueOf(2.1));
        product2.setProductURL("https://picsum.photos/seed/picsum/200");

        Product product3 = new Product();
        product3.setProductName("Shoe");
        product3.setDescription("Can use to walk. Famously used to walk 500 miles and then 500 miles more by the Proclaimers.");
        product3.setProductPrice(BigDecimal.valueOf(74.21));
        product3.setProductRating(BigDecimal.valueOf(2.1));
        product3.setProductURL("https://picsum.photos/seed/picsum/200");

        Product product4 = new Product();
        product4.setProductName("Potato");
        product4.setDescription("Entirely edible. Entirely fun. Great for entertaining crowds. People will be jealous.");
        product4.setProductPrice(BigDecimal.valueOf(2.01));
        product4.setProductRating(BigDecimal.valueOf(5.0));
        product4.setProductURL("https://picsum.photos/id/237/200");

        Product product5 = new Product();
        product5.setProductName("Shampoo");
        product5.setDescription("Not entirely edible. Made for use in hair. You can wash your hair with this product.");
        product5.setProductPrice(BigDecimal.valueOf(4.01));
        product5.setProductRating(BigDecimal.valueOf(3.0));
        product5.setProductURL("https://picsum.photos/seed/picsum/200");

        Product product6 = new Product();
        product6.setProductName("Water");
        product6.setDescription("Not entirely drinkable. It was. But after we put it in these water bottles, they seem to be poisonous.");
        product6.setProductPrice(BigDecimal.valueOf(42.07));
        product6.setProductRating(BigDecimal.valueOf(4.5));
        product6.setProductURL("https://picsum.photos/200?grayscale");

        Product[] newProducts = {
                product,
                product2,
                product3,
                product4,
                product5,
                product6
        };

        List<Product> allProducts = (List<Product>) productRepo.findAll();

        for (Product sampleProduct: newProducts) { boolean exists = false;
            for (Product thisProduct : allProducts) {
                if (thisProduct.getProductName().equals(sampleProduct.getProductName())) {
                    exists = true;
                }
            }
            if (!exists) {
                productRepo.save(sampleProduct);
            }
        }
    }
}