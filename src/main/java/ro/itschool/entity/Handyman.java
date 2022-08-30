package ro.itschool.entity;
import com.opencsv.bean.CsvBindByPosition;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Handyman  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @CsvBindByPosition(position = 0)
    @Column(name="handyman_id")
    private Long id;

    @CsvBindByPosition(position = 3)
    @Column(nullable = false, unique = true)
    private String username;

    @CsvBindByPosition(position = 1)
    @Column(nullable = false, length = 30)
    private String name;

    @CsvBindByPosition(position = 2)
    @Column(nullable = false, length = 30)
    private String surname;

    @CsvBindByPosition(position = 4)
    @Column(nullable = false)
    private String skill;

    @CsvBindByPosition(position = 5)
    @Column(nullable = false)
    private int experience;

    @CsvBindByPosition(position = 6)
    @Column(nullable = false)
    private int rating;

    @CsvBindByPosition(position = 7)
    @Column(nullable = false, length = 30, unique = true)
    private String email;

    @CsvBindByPosition(position = 8)
    @Column(nullable = false, length = 12, unique = true)
    private long phoneNumber;

    @CsvBindByPosition(position = 9)
    @Column(name = "service_price")
    private Double servicePrice;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "handyman_skills",
            joinColumns = @JoinColumn(name = "handyman_id", referencedColumnName = "handyman_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id", referencedColumnName ="skill_id"))
    private Set<Skill> skills = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="order_id", referencedColumnName = "id")
    private Order order;

    public Handyman
            (String name, String username , String surname, String skill, int experience, int rating, String email, int cellphone, Set<Skill> skills) {
        this.name = name;
        this.surname = surname;
        this.skill=skill;
        this.skills = skills;
        this.experience = experience;
        this.rating = rating;
        this.email = email;
        this.phoneNumber = cellphone;
        this.username = username;



    }

    public Handyman(Handyman h) {
        this.order=h.getOrder();
        this.id=h.getId();
        this.name = h.getName();
        this.surname = h.getSurname();
        this.skill=h.getSkill();
        this.skills = h.getSkills();
        this.experience = h.getExperience();
        this.rating = h.getRating();
        this.email = h.getEmail();
        this.phoneNumber = h.getPhoneNumber();
        this.username = h.getUsername();
        this.servicePrice = h.getServicePrice();
    }
}

