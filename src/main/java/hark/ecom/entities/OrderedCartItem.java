package hark.ecom.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hark.ecom.entities.Cart;
import hark.ecom.entities.OrderedCart;
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
@Table(name = "ordered_cart_item")
public class OrderedCartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordered_cart_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ordered_cart_id") // Foreign key to Cart
    @JsonIgnore
    private OrderedCart orderedCart;

    @ManyToOne
    @JoinColumn(name = "product_id") // Foreign key to Product
    private Product product;

    @ManyToMany
    @JoinTable( name = "ordered_product_cart_item", joinColumns = @JoinColumn(name = "ordered_cart_item_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products;

    @Column(name = "created")
    @CreationTimestamp
    private Date created;

    @Column(name = "modified")
    @UpdateTimestamp
    private Date modified;
}
