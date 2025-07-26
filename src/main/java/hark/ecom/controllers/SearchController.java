package hark.ecom.controllers;

import hark.ecom.entities.products.Product;
import hark.ecom.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/search")
@CrossOrigin("http://localhost:3000")
public class SearchController {

    private ProductService productService;

    @Autowired
    public SearchController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/searchfor")
    public Set<Product> search(@Param("filter") String filter) {
        return productService.searchProducts(filter);
    }
}
