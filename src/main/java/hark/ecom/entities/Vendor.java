package hark.ecom.entities;

import hark.ecom.entities.customers.Customer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "vendor")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendor_id")
    private int id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "shop_name")
    private String shopName;

    @Column(name = "vendor_email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "avatar_URL")
    private String avatarURL;

    @Column(name = "published")
    private boolean published;

    @Column(name = "created")
    @CreationTimestamp
    private Date created;

    @Column(name = "modified")
    @UpdateTimestamp
    private Date modified;



    public Vendor() {}
}
