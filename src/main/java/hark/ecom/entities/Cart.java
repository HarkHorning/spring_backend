package hark.ecom.entities;

import hark.ecom.entities.enums.CartStatus;
import hark.ecom.entities.products.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int id;

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

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
