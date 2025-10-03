package hark.ecom.entities;

import hark.ecom.entities.customers.Customer;
import hark.ecom.entities.enums.CartStatus;
import hark.ecom.entities.products.CartItem;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "ordered_cart")
public class OrderedCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordered_cart_id")
    private Long id;

    @Column(name = "cart_tracking_number")
    private String orderTrackingNumber;

    @Column(name = "created")
    @CreationTimestamp
    private Date created;

    @Column(name = "modified")
    @UpdateTimestamp
    private Date modified;

    @Enumerated(EnumType.STRING)
    @Column(name = "cart_status")
    private CartStatus status;

    @OneToMany(mappedBy = "orderedCart", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<OrderedCartItem> orderedCartItems;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
