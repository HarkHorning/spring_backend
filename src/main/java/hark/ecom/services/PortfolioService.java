package hark.ecom.services;

import hark.ecom.entities.Portfolio;
import hark.ecom.entities.Vendor;
import hark.ecom.entities.products.Product;
import hark.ecom.repositories.PortfolioRepository;
import hark.ecom.repositories.VendorRepository;
import hark.ecom.repositories.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;
    private final VendorRepository vendorRepository;
    private final ProductRepository productRepository;

    public PortfolioService(PortfolioRepository portfolioRepository,  VendorRepository vendorRepository,  ProductRepository productRepository) {
        this.portfolioRepository = portfolioRepository;
        this.vendorRepository = vendorRepository;
        this.productRepository = productRepository;
    }

    public Portfolio createPortfolio(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    public Portfolio updatePortfolio(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    public List<Portfolio> getPortfolios(long id) {
        Vendor vendor = vendorRepository.findById(id).orElse(null);
        return portfolioRepository.findAllByVendor(vendor);
    }

    public List<Product> getProductsByPortfolio(long id) {
        return productRepository.getProductByPortfolio_Id((int) id);
    }

    public Product addProductToPortfolio(Product product) {
        Portfolio portfolio = portfolioRepository.findById((long) product.getPortfolio().getId()).orElse(null);
        assert portfolio != null;
        productRepository.save(product);
        portfolio.getProducts().add(product);
        portfolioRepository.save(portfolio);
        return product;
    }
}
