package hark.ecom.entities;

import hark.ecom.entities.products.Product;
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
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "portfolio_id")
    private int id;

    @Column(name = "portfolio_name")
    private String  portfolioName;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "customer_id")
//    private Customer customer;

    @Column(name = "created")
    @CreationTimestamp
    private Date created;

    @Column(name = "modified")
    @UpdateTimestamp
    private Date modified;

//    @OneToMany(mappedBy = "portfolio", fetch = FetchType.LAZY, orphanRemoval = true)
//    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

}
