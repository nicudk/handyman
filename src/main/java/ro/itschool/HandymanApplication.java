package ro.itschool;

import ch.qos.logback.classic.log4j.XMLLayout;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.multipart.MultipartFile;
import ro.itschool.CSV.SetupCSV;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HandymanApplication {
    private static final String Path = "C:\\Users\\eComputer\\Desktop\\IT school\\handyman\\src\\main\\resources\\handyman.csv";


    public static void main(String[] args) {

      SpringApplication.run(HandymanApplication.class, args);
        System.out.println(readDataFromCSVFile());


    }

    public static List<SetupCSV> readDataFromCSVFile() {
        try {
            return new CsvToBeanBuilder<SetupCSV>(new FileReader(Path))
                    .withType(SetupCSV.class)
                    .withSkipLines(1)
                    .build()
                    .parse();

        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

       return  new ArrayList<>();

    }

//    public static boolean readDataFromCSVFile(MultipartFile file) {
//      String TYPE = " text/csv";
//        if (TYPE.equals(file.getContentType())|| file.getContentType().equals("application/vnd.ms-ex-cel")){
//            return true;
//        }
//        return false;
//    }

}