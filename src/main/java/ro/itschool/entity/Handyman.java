package ro.itschool.entity;
import com.opencsv.bean.CsvBindByPosition;
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
public class Handyman  {

    @Id

    @CsvBindByPosition(position = 0)
    @Column(name="handyman_id")
    private Long id;
    @CsvBindByPosition(position = 1)
    @Column(nullable = false, unique = true)
    private String username;
    @CsvBindByPosition(position = 2)
    @Column(nullable = false, length = 30)
    private String name;
    @CsvBindByPosition(position = 3)
    @Column(nullable = false, length = 30)
    private String surname;
    @CsvBindByPosition(position = 4)
    @Column(nullable = false)
    private String skill;
    @CsvBindByPosition(position = 5)
    @Column(nullable = false)
    private int experience;
    @CsvBindByPosition(position = 6)
    @Column(nullable = false, precision = 5)
    private int rating;
    @CsvBindByPosition(position = 7)
    @Column(nullable = false, length = 30, unique = true)
    private String email;
    @CsvBindByPosition(position = 8)
    @Column(nullable = false, length = 12, unique = true)
    private int phoneNumber;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "handyman_skills",
            joinColumns = @JoinColumn(name = "handyman_id", referencedColumnName = "handyman_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id", referencedColumnName ="skill_id"))
    private Set<Skill> skills = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "handyman_id")
    @ToString.Exclude
    private Handyman handyman;


    public Handyman(Handyman handyman) {
        this.handyman = handyman;
    }

    public Handyman
            (String name, String surname, String skill, int experience, int rating, String email, int cellphone, Set<Skill> skils) {
        this.name = name;
        this.surname = surname;
        this.skills = getSkills();
        this.experience = experience;
        this.rating = rating;
        this.email = email;
        this.phoneNumber = cellphone;
        this.username = getUsername();



    }

}

