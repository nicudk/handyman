package ro.itschool.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDateTime;
import java.util.Set;


@Getter
@Setter
@ToString
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String currency;

    private Double amount;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ToString.Exclude
    private MyUser myUser;

    @OneToMany(mappedBy = "order" /*cascade = CascadeType.REMOVE*/, fetch = FetchType.LAZY)
    private Set<Handyman> handymanSet;

    public Order() {
        this.currency = "RON";
        this.createdAt = LocalDateTime.now();
        this.amount = 0D;
    }


}
