package hark.ecom.services;

import hark.ecom.entities.OrderedCart;
import hark.ecom.entities.OrderedCartItem;
import hark.ecom.repositories.OrderedCartItemRepository;
import hark.ecom.repositories.OrderedCartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderedCartService {

    @Autowired
    private OrderedCartsRepository orderedCartsRepository;
    private OrderedCartItemRepository orderedCartItemRepository;

    public OrderedCartService(OrderedCartsRepository orderedCartsRepository,  OrderedCartItemRepository orderedCartItemRepository) {
        this.orderedCartsRepository = orderedCartsRepository;
        this.orderedCartItemRepository = orderedCartItemRepository;
    }

    public List<OrderedCart> getCart(long id) {
        List<OrderedCart> oC = orderedCartsRepository.findAllByCustomerId((id));
//        List<OrderedCartItem> oCItems = oC.getOrderedCartItems();
//        for (OrderedCartItem oCItem : oCItems) {
//            System.out.println("oCItem.getProduct().getProductName()");
//        }
        if (oC != null) {
            return oC;
        } else {
            return null;
        }
    }

//    public List<OrderedCartItem> getCartItem(long id) {
//        OrderedCart orderedCart = orderedCartsRepository.findById(id).orElse(null);
//        List<OrderedCartItem> orderedCartItems = orderedCartItemRepository.findAllByOrderedCart(orderedCart);
//        System.out.println(orderedCartItems.get(0));
//        return orderedCartItemRepository.findAllByOrderedCart(orderedCart);
//    }

}
