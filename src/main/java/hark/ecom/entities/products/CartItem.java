package hark.ecom.entities.products;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hark.ecom.entities.Cart;
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
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "cart_id") // Foreign key to Cart
    @JsonIgnore
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id") // Foreign key to Product
    private Product product;

    @ManyToMany
    @JoinTable( name = "product_cart_item", joinColumns = @JoinColumn(name = "cart_item_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products;

    @Column(name = "created")
    @CreationTimestamp
    private Date created;

    @Column(name = "modified")
    @UpdateTimestamp
    private Date modified;
}
