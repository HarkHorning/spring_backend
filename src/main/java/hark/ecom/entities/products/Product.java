package hark.ecom.entities.products;

import hark.ecom.entities.Cart;
import hark.ecom.entities.Portfolio;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_price")
    private BigDecimal productPrice;

    @Column(name = "product_description")
    private String description;

    @Column(name = "product_rating")
    private BigDecimal productRating;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "created")
    @CreationTimestamp
    private Date created;

    @Column(name = "modified")
    @UpdateTimestamp
    private Date modified;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio  portfolio;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;


    public Product() {}

    public Product(String productName, BigDecimal productPrice, String description, BigDecimal productRating) {

        this.productName = productName;
        this.productPrice = productPrice;
        this.description = description;
        this.productRating = productRating;
    }
}
