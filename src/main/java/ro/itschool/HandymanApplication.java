package ro.itschool;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.itschool.entity.Handyman;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HandymanApplication {
	private static final String Path="C:\\Users\\eComputer\\Desktop\\IT school\\handyman\\src\\main\\resources\\handyman.csv";
	public static void main(String[] args)  {

		SpringApplication.run(HandymanApplication.class, args);

	}


	public static List<Handyman> readDataFromCSVFile(String fileName)  {
		try{
		return new CsvToBeanBuilder(new FileReader(Path))
				.withType(Handyman.class)
				.build()
				.parse();

		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
}