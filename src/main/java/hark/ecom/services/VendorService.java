package hark.ecom.services;

import hark.ecom.entities.Portfolio;
import hark.ecom.entities.Vendor;
import hark.ecom.entities.customers.Customer;
import hark.ecom.entities.products.Product;
import hark.ecom.repositories.customers.CustomerRepository;
import hark.ecom.repositories.PortfolioRepository;
import hark.ecom.repositories.VendorRepository;
import hark.ecom.repositories.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendorService {

    @Autowired
    private CustomerRepository customerRepository;
    private VendorRepository vendorRepository;
    private PortfolioRepository portfolioRepository;
    private ProductRepository productRepository;
    private PortfolioService portfolioService;

    public VendorService(CustomerRepository customerRepository, VendorRepository vendorRepository, PortfolioRepository portfolioRepository, ProductRepository productRepository,  PortfolioService portfolioService) {
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
        this.portfolioRepository = portfolioRepository;
        this.productRepository = productRepository;
        this.portfolioService = portfolioService;
    }

    public Vendor createVendor(Vendor vendor) {
        Customer customer =  vendor.getCustomer();
//        System.out.println(customer.getUsername());
        customerRepository.save(customer);
        vendor.setCustomer(customer);
        return vendorRepository.save(vendor);
    }

    public Vendor getVendorByCustomerId(Long id) {
        return vendorRepository.findByCustomerId(id);
    }

    public Portfolio createPortfolio(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    public Portfolio getPortfolioById(Long  portfolioId) {
        return portfolioRepository.findById(portfolioId).get();
    }

//    public Product addProductToPortfolio(Long portfolioId, Product product) {
//        Portfolio portfolio = portfolioRepository.findById(portfolioId).orElse(null);
//        productRepository.save(product);
//        assert portfolio != null;
//        portfolio.getProducts().add(product);
//        portfolioRepository.save(portfolio);
//        return product;
//    }

    public Vendor modifyVendor(Vendor vendor) {
        return vendorRepository.saveAndFlush(vendor);
    }

    public List<Product> getSalesReportByVendorId(Long vendorId) {

//        Vendor vendor = getVendorByCustomerId(vendorId);
        List<Portfolio> portfolios = portfolioService.getPortfolios(vendorId);
        List<Product> products = new ArrayList<>();

        for (Portfolio portfolio : portfolios) {
            products.addAll(portfolioService.getProductsByPortfolio(portfolio.getId()));
        }

        return products;
    }
}
