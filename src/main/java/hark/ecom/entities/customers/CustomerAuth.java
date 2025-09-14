package hark.ecom.entities.customers;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customer_cred")
@AllArgsConstructor
public class CustomerAuth {

//    !!BUILD PASSWORD VALIDATORS!!

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_pwd_id")
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "passcode", nullable = false)
    private String password;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public CustomerAuth() {}
}
