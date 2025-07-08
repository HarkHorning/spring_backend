package hark.ecom.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "portfolio_id")
    private int id;

    @Column(name = "portfolio_name")
    private String  portfolioName;

    @Column(name = "created")
    @CreationTimestamp
    private Date created;

    @Column(name = "modified")
    @UpdateTimestamp
    private Date modified;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

//    @OneToMany(mappedBy = "product_id", cascade = CascadeType.ALL)
//    private Set<Product> products;
}
