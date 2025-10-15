package hark.ecom.controllers;

import hark.ecom.entities.products.Product;
import hark.ecom.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin("http://localhost:3000")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/getproductsbyquantity")
    public List<Product> getProductsByQuantity(@Param("quantity") int quantity){
        return productService.getProductsByQuantity(quantity);
    }

    @RequestMapping("/getbyid")
    public Product findProductById(@Param("id") long id) {
        return productService.findProductById(id);
    }

    @RequestMapping("deleteproductbyid") // make @DeleteMapping
    public void deleteProductById(@Param("id") long id) {
        productService.deleteProductById(id);
    }

    @RequestMapping("/editproduct")
    public Product editProductById(@RequestBody Product product) {
        return productService.editProductById(product);
    }
}
