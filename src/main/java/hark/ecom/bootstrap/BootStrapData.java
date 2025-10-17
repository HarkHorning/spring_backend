package hark.ecom.bootstrap;

import hark.ecom.entities.customers.Customer;
import hark.ecom.entities.products.Product;
import hark.ecom.repositories.CartRepository;
import hark.ecom.repositories.customers.CustomerRepository;
import hark.ecom.repositories.products.ProductRepository;
import hark.ecom.services.CartService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;
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
        customer2.setUsername("User");
        customer2.setFirstName("User");
        customer2.setLastName("Johnson");
        customer2.setPhone("12345678901");
        customer2.setAddress("St Road, North South, America");

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
        product.setProductURL("/SingleCamera.jpg");
        product.setAmountSold(0);

        Product product2 = new Product();
        product2.setProductName("Spoon");
        product2.setDescription("Can use to eat sandwitch. But that's not really what this is made for. But if you must...");
        product2.setProductPrice(BigDecimal.valueOf(4.21));
        product2.setProductRating(BigDecimal.valueOf(2.1));
        product2.setProductURL("/SingleLense.jpg");
        product2.setAmountSold(0);

        Product product3 = new Product();
        product3.setProductName("Shoe");
        product3.setDescription("Can use to walk. Famously used to walk 500 miles and then 500 miles more by the Proclaimers.");
        product3.setProductPrice(BigDecimal.valueOf(74.21));
        product3.setProductRating(BigDecimal.valueOf(2.1));
        product3.setProductURL("/SingleCamera.jpg");
        product3.setAmountSold(0);

        Product product4 = new Product();
        product4.setProductName("Potato");
        product4.setDescription("Entirely edible. Entirely fun. Great for entertaining crowds. People will be jealous.");
        product4.setProductPrice(BigDecimal.valueOf(2.01));
        product4.setProductRating(BigDecimal.valueOf(5.0));
        product4.setProductURL("/SingleCamera.jpg");
        product4.setAmountSold(0);

        Product product5 = new Product();
        product5.setProductName("Shampoo");
        product5.setDescription("Not entirely edible. Made for use in hair. You can wash your hair with this product.");
        product5.setProductPrice(BigDecimal.valueOf(4.01));
        product5.setProductRating(BigDecimal.valueOf(3.0));
        product5.setProductURL("/SingleCamera.jpg");
        product5.setAmountSold(0);

        Product product6 = new Product();
        product6.setProductName("Water");
        product6.setDescription("Not entirely drinkable. It was. But after we put it in these water bottles, they seem to be poisonous.");
        product6.setProductPrice(BigDecimal.valueOf(42.07));
        product6.setProductRating(BigDecimal.valueOf(4.5));
        product6.setProductURL("/SingleCamera.jpg");
        product6.setAmountSold(0);

        Product product7 = new Product();
        product7.setProductName("Three Oranges");
        product7.setDescription("If you think you like oranges, guess again. This has the potential to make you question everything you think you know about oranges; the good and the bad.");
        product7.setProductPrice(BigDecimal.valueOf(10.02));
        product7.setProductRating(BigDecimal.valueOf(4.5));
        product7.setProductURL("/SingleCamera.jpg");
        product7.setAmountSold(0);

        Product product8 = new Product();
        product8.setProductName("Four Oranges");
        product8.setDescription("You have had three oranges, but have you ever had four. Something about the number four and oranges is fundamentally strange. Don't you think? I think. Therefore you should buy four oranges.");
        product8.setProductPrice(BigDecimal.valueOf(12.73));
        product8.setProductRating(BigDecimal.valueOf(5.0));
        product8.setProductURL("/SingleCamera.jpg");
        product8.setAmountSold(0);

        Product product9 = new Product();
        product9.setProductName("Rug");
        product9.setDescription("Quite frankly, I think you know what this is. People are always contacting me and saying they haven't heard of a rug before. This I do not believe. Please Stop being confused. It's a rug. Rugs are rugs.");
        product9.setProductPrice(BigDecimal.valueOf(61.41));
        product9.setProductRating(BigDecimal.valueOf(1.2));
        product9.setProductURL("/SingleCamera.jpg");
        product9.setAmountSold(0);

        Product product10 = new Product();
        product10.setProductName("Mysterious Object");
        product10.setDescription("If you like mystery, than you should buy this. I don't even know what it is. It glows in the dark and I hear voices sometimes when I'm near it. I also won the lottery recently. Don't know if it's related. It's very mysterious.");
        product10.setProductPrice(BigDecimal.valueOf(18.26));
        product10.setProductRating(BigDecimal.valueOf(5.0));
        product10.setProductURL("/SingleCamera.jpg");
        product10.setAmountSold(0);

        Product product11 = new Product();
        product11.setProductName("Camera");
        product11.setDescription("This is a sample product made to be a placeholder.");
        product11.setProductPrice(BigDecimal.valueOf(18.26));
        product11.setProductRating(BigDecimal.valueOf(5.0));
        product11.setProductURL("/SingleCamera.jpg");
        product11.setAmountSold(0);

        Product product12 = new Product();
        product12.setProductName("Lens");
        product12.setDescription("This is a sample product made to be a placeholder.");
        product12.setProductPrice(BigDecimal.valueOf(18.26));
        product12.setProductRating(BigDecimal.valueOf(5.0));
        product12.setProductURL("/SingleLense.jpg");
        product12.setAmountSold(0);

        Product product13 = new Product();
        product13.setProductName("Products Sample 3");
        product13.setDescription("This is a sample product made to be a placeholder.");
        product13.setProductPrice(BigDecimal.valueOf(18.26));
        product13.setProductRating(BigDecimal.valueOf(5.0));
        product13.setProductURL("/SingleCamera.jpg");
        product13.setAmountSold(0);

        Product product14 = new Product();
        product14.setProductName("Products Sample 4");
        product14.setDescription("This is a sample product made to be a placeholder.");
        product14.setProductPrice(BigDecimal.valueOf(18.26));
        product14.setProductRating(BigDecimal.valueOf(5.0));
        product14.setProductURL("/SingleCamera.jpg");
        product14.setAmountSold(0);

        Product product15 = new Product();
        product15.setProductName("Products Sample 5");
        product15.setDescription("This is a sample product made to be a placeholder.");
        product15.setProductPrice(BigDecimal.valueOf(18.26));
        product15.setProductRating(BigDecimal.valueOf(5.0));
        product15.setProductURL("/SingleCamera.jpg");
        product15.setAmountSold(0);

        Product product16 = new Product();
        product16.setProductName("Products Sample 6");
        product16.setDescription("This is a sample product made to be a placeholder.");
        product16.setProductPrice(BigDecimal.valueOf(18.26));
        product16.setProductRating(BigDecimal.valueOf(5.0));
        product16.setProductURL("/SingleCamera.jpg");
        product16.setAmountSold(0);

        Product product17 = new Product();
        product17.setProductName("Products Sample 7");
        product17.setDescription("This is a sample product made to be a placeholder.");
        product17.setProductPrice(BigDecimal.valueOf(18.26));
        product17.setProductRating(BigDecimal.valueOf(5.0));
        product17.setProductURL("/SingleCamera.jpg");
        product17.setAmountSold(0);

        Product product18 = new Product();
        product18.setProductName("Products Sample 8");
        product18.setDescription("This is a sample product made to be a placeholder.");
        product18.setProductPrice(BigDecimal.valueOf(18.26));
        product18.setProductRating(BigDecimal.valueOf(5.0));
        product18.setProductURL("/SingleCamera.jpg");
        product18.setAmountSold(0);

        Product product19 = new Product();
        product19.setProductName("Products Sample 9");
        product19.setDescription("This is a sample product made to be a placeholder.");
        product19.setProductPrice(BigDecimal.valueOf(18.26));
        product19.setProductRating(BigDecimal.valueOf(5.0));
        product19.setProductURL("/SingleCamera.jpg");
        product19.setAmountSold(0);



        Product[] newProducts = {
                product,
                product2,
                product3,
                product4,
                product5,
                product6,
                product7,
                product8,
                product9,
                product10,
                product11,
                product12,
                product13,
                product14,
                product15,
                product16,
                product17,
                product18,
                product19,
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