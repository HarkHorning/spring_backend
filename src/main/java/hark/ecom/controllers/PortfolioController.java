package hark.ecom.controllers;

import hark.ecom.entities.Portfolio;
import hark.ecom.entities.Vendor;
import hark.ecom.entities.products.Product;
import hark.ecom.services.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolio")
@CrossOrigin("http://localhost:3000")
public class PortfolioController {

    private PortfolioService portfolioService;

    @Autowired
    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @PostMapping("/createportfolio")
    public Portfolio createPortfolio(@RequestBody Portfolio portfolio) {
        return portfolioService.createPortfolio(portfolio);
    }

    @GetMapping("/getportfolios")
    public List<Portfolio> getPortfolios(@Param("id") long id) {
        return portfolioService.getPortfolios(id);
    }

    @GetMapping("/getportfolio")
    public Portfolio getPortfolio(@Param("id") long id) {
        return portfolioService.getPortfolio(id);
    }

    @GetMapping("/getproductsbyportfolio")
    public List<Product> getProductsByportfolio(@Param("id") long id) {
        return portfolioService.getProductsByPortfolio(id);
    }

    @PostMapping("/addproducttoportfolio")
    public Product addProductToPortfolio(@RequestBody Product product) {

        return  portfolioService.addProductToPortfolio(product);
    }

    @GetMapping("/deleteportfolio") // make deletemapping
    public String deletePortfolio(@Param("id") long id) {
        return portfolioService.deletePortfolio(id);
    }
}
