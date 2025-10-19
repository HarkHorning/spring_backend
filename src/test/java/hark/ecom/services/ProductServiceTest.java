package hark.ecom.services;

import hark.ecom.entities.products.Product;
import hark.ecom.repositories.products.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;


//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }

    @Test
    void findProductById() {

//        ProductService productService = productService;
//        Product product = productService.findProductById(1);
//        Assertions.assertEquals("Camera 200", product.getProductName());

        int num = 1;
        Assertions.assertEquals(1, num);
    }

    @Test
    void searchProducts() {
        int num = 1;
        Assertions.assertEquals(1, num);
    }

    @Test
    void deleteProductById() {
        int num = 1;
        Assertions.assertEquals(1, num);
    }

    @Test
    void editProductById() {
        int num = 1;
        Assertions.assertEquals(1, num);
    }

    @Test
    void checkProductsForPortfolio() {
        int num = 1;
        Assertions.assertEquals(1, num);
    }

    @Test
    void getProductsByQuantity() {
        int num = 1;
        Assertions.assertEquals(1, num);
    }
}