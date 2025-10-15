package hark.ecom.controllers;

import hark.ecom.entities.Portfolio;
import hark.ecom.entities.Vendor;
import hark.ecom.entities.products.Product;
import hark.ecom.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendor")
@CrossOrigin("http://localhost:3000")
public class VendorController {

    private VendorService vendorService;

    @Autowired
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping("/createvendor")
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.createVendor(vendor);
    }

    @RequestMapping("/getvendor")
    public Vendor getVendorByCustomerId(@Param("id") Long id) {
        return vendorService.getVendorByCustomerId(id);
    }

    @PostMapping("createportfolio")
    public Portfolio createPortfolio(@RequestBody Portfolio portfolio) {
        return vendorService.createPortfolio(portfolio);
    }

    @RequestMapping("getportfolio")
    public Portfolio getPortfolioById(@RequestParam("portfolioId") Long portfolioId) {
        return vendorService.getPortfolioById(portfolioId);
    }

//    @PostMapping("/addproducttoportfolio")
//    public Product addProductToPortfolio(@RequestParam("portfolioId") Long portfolioId, @RequestBody Product product) {
//
//        return vendorService.addProductToPortfolio(portfolioId, product);
//    }

    @PostMapping("/editvendor")
    public Vendor modifyVendor(@RequestBody Vendor vendor) {
        return vendorService.modifyVendor(vendor);
    }
}
