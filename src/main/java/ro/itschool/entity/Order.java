package ro.itschool.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;


@Getter
@Setter
@Entity
@ToString
public class  Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String currency;

    private Double amount;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private MyUser user;

    @OneToMany(mappedBy = "handyman", cascade = CascadeType.REMOVE)
    private Set<Handyman> handyman;

    public Order() {
        this.currency="RON";
        this.createdAt = LocalDateTime.now();
        this.amount = 0D;
    }


}
