package hark.ecom.bootstrap;

import hark.ecom.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepo;

    public BootStrapData(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public void run(String... args) throws Exception {
    }
}