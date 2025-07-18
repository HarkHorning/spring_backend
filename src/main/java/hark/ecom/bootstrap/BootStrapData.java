package hark.ecom.bootstrap;

import hark.ecom.entities.Customer;
import hark.ecom.entities.products.Product;
import hark.ecom.repositories.CustomerRepository;
import hark.ecom.repositories.products.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepo;
    private final ProductRepository productRepo;

    public BootStrapData(CustomerRepository customerRepo,  ProductRepository productRepo) {
        this.customerRepo = customerRepo;
        this.productRepo = productRepo;
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

//        customerRepo.save(customer2);

        Product product = new Product();
        product.setProductName("Sword");
        product.setDescription("Very big sword. Very pointy.");
        product.setProductPrice(BigDecimal.valueOf(12.23));
        product.setProductRating(BigDecimal.valueOf(3.9));

        Product product2 = new Product();
        product2.setProductName("Spoon");
        product2.setDescription("Can use to eat sandwitch.");
        product2.setProductPrice(BigDecimal.valueOf(4.21));
        product2.setProductRating(BigDecimal.valueOf(2.1));

        Product product3 = new Product();
        product3.setProductName("Shoe");
        product3.setDescription("Can use to walk.");
        product3.setProductPrice(BigDecimal.valueOf(74.21));
        product3.setProductRating(BigDecimal.valueOf(2.1));

        Product product4 = new Product();
        product4.setProductName("Potato");
        product4.setDescription("Entirely edible.");
        product4.setProductPrice(BigDecimal.valueOf(2.01));
        product4.setProductRating(BigDecimal.valueOf(5.0));

        Product product5 = new Product();
        product5.setProductName("Shampoo");
        product5.setDescription("Not entirely edible.");
        product5.setProductPrice(BigDecimal.valueOf(4.01));
        product5.setProductRating(BigDecimal.valueOf(3.0));

        Product product6 = new Product();
        product6.setProductName("Water");
        product6.setDescription("Not entirely drinkable.");
        product6.setProductPrice(BigDecimal.valueOf(42.07));
        product6.setProductRating(BigDecimal.valueOf(4.5));

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