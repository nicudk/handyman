package ro.itschool.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class Handyman  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="handyman_id")
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, length = 30)
    private String name;
    @Column(nullable = false, length = 30)
    private String surname;
    @Column(nullable = false)
    private String skill;
    @Column(nullable = false)
    private int experience;
    @Column(nullable = false)
    private int rating;
    @Column(nullable = false, length = 30, unique = true)
    private String email;
    @Column(nullable = false, length = 12, unique = true)
    private long phoneNumber;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "handyman_skills",
            joinColumns = @JoinColumn(name = "handyman_id", referencedColumnName = "handyman_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id", referencedColumnName ="skill_id"))
    private Set<Skill> skills = new HashSet<>();

    @ManyToOne
    @JoinColumn(insertable = false,updatable = false,name="handyman_id")
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
    }
}

