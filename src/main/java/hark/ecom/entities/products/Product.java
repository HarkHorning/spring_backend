package hark.ecom.entities.products;

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

    @Column(name = "product_price")
    private BigDecimal productPrice;

    @Column(name = "product_description")
    private String description;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "created")
    @CreationTimestamp
    private Date created;

    @Column(name = "modified")
    @UpdateTimestamp
    private Date modified;

}
