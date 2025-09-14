package hark.ecom.config;

import hark.ecom.entities.Cart;
import hark.ecom.entities.customers.Customer;
import hark.ecom.entities.Vendor;
import hark.ecom.entities.products.Category;
import hark.ecom.entities.products.Product;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        config.exposeIdsFor(Vendor.class);
        config.exposeIdsFor(Customer.class);
        config.exposeIdsFor(Cart.class);
        config.exposeIdsFor(Product.class);
        config.exposeIdsFor(Category.class);
        config.setDefaultPageSize(Integer.MAX_VALUE);
        config.setMaxPageSize(Integer.MAX_VALUE);
    }
}
