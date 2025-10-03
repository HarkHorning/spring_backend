package hark.ecom.services;

import hark.ecom.entities.OrderedCart;
import hark.ecom.repositories.OrderedCartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderedCartService {

    @Autowired
    private OrderedCartsRepository orderedCartsRepository;

    public OrderedCartService(OrderedCartsRepository orderedCartsRepository) {
        this.orderedCartsRepository = orderedCartsRepository;
    }

    public OrderedCart getItems(Long cu_id) {
        return orderedCartsRepository.findById(cu_id).orElse(null);
    }


}
