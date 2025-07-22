package hark.ecom.entities.products;

import hark.ecom.entities.Cart;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "cart_id") // Foreign key to Cart
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id") // Foreign key to Product
    private Product product;

    @Column(name = "created")
    @CreationTimestamp
    private Date created;

    @Column(name = "modified")
    @UpdateTimestamp
    private Date modified;
}
