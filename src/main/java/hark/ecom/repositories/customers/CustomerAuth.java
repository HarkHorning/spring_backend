package hark.ecom.repositories.customers;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customer_auth")
@AllArgsConstructor
public class CustomerAuth {

//    !!BUILD PASSWORD VALIDATORS!!

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_pwd_id")
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    public CustomerAuth() {}
}
