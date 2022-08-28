package ro.itschool.CSV;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import jakarta.persistence.*;
import lombok.*;
import ro.itschool.entity.Handyman;
import ro.itschool.entity.Skill;

import java.util.*;
import java.util.function.Function;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class SetupCSV extends Handyman  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @CsvBindByPosition(position = 0)
    @Column(name = "handyman_id")
    private Long id;
    @CsvBindByPosition(position = 1)
    @Column(nullable = false, length = 30)
    private String name;
    @CsvBindByPosition(position = 2)
    @Column(nullable = false, length = 30)
    private String surname;
    @CsvBindByPosition(position = 3)
    @Column(nullable = false, unique = true)
    private String username;
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
    @Column(nullable = false, length = 13, unique = true)
    private long phoneNumber;


    public SetupCSV
            (String name, String surname, String skill, int experience, int rating, String email, int cellphone, Set<Skill> skils) {
        this.name = name;
        this.surname = surname;
        this.skill = getSkill();
        this.experience = experience;
        this.rating = rating;
        this.email = email;
        this.phoneNumber = cellphone;
        this.username = getUsername();
    }


//    public static List<Handyman> readDataFromCSVFile(String fileName) {
//
//        Map<String, String> mapping = new
//                HashMap<String, String>();
//        mapping.put("name", "Name");
//        mapping.put("surname", "Surname");
//        mapping.put("username", "Username");
//        mapping.put("skill", "Skill");
//        mapping.put("experience", "Experience");
//        mapping.put("raiting", "Raiting");
//        mapping.put("email", "Email");
//        mapping.put("phonenumber", "Phonenumber");
//
//        HeaderColumnNameTranslateMappingStrategy<Handyman> strategy =
//                new HeaderColumnNameTranslateMappingStrategy<Handyman>();
//        strategy.setType(SetupCSV.class);
//        strategy.setColumnMapping(mapping);
//
//        return new ArrayList<>();

//    }
}