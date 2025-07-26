package hark.ecom.services;

import hark.ecom.entities.products.Product;
import hark.ecom.repositories.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findProductById(long id) {

        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    public Set<Product> searchProducts(String filter) {

        Set<Product> products = productRepository.findAllByProductNameNotContainingIgnoreCase(filter);
        return products;
    }
}
