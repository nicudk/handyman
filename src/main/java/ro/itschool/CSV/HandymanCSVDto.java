package ro.itschool.CSV;

import com.opencsv.bean.CsvBindByPosition;
import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HandymanCSVDto {

    @CsvBindByPosition(position = 0)
    private Long id;

    @CsvBindByPosition(position = 1)
    private String name;

    @CsvBindByPosition(position = 2)
    private String surname;

    @CsvBindByPosition(position = 3)
    private String username;

    @CsvBindByPosition(position = 4)
    private String skill;

    @CsvBindByPosition(position = 5)
    private int experience;

    @CsvBindByPosition(position = 6)
    private int rating;

    @CsvBindByPosition(position = 7)
    private String email;

    @CsvBindByPosition(position = 8)
    private long phoneNumber;

    @CsvBindByPosition(position = 9)
    private Double servicePrice;

}