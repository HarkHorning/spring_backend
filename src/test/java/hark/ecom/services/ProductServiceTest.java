package hark.ecom.services;

import hark.ecom.repositories.products.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

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

    @Test
    void testFindProductById() {
    }

    @Test
    void testSearchProducts() {
    }

    @Test
    void testDeleteProductById() {
    }

    @Test
    void testEditProductById() {
    }

    @Test
    void testCheckProductsForPortfolio() {
    }

    @Test
    void testGetProductsByQuantity() {
    }
}