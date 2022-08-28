package ro.itschool.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ro.itschool.CSV.SetupCSV;
import ro.itschool.HandymanApplication;
import ro.itschool.entity.Handyman;
import ro.itschool.repository.SetupCSVRepository;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class SetupCSVServiceImpl {

    @Autowired
    SetupCSVRepository repository;

//    public void save (MultipartFile file) {
//        try {
//            List<SetupCSV> setupCSVList = HandymanApplication.readDataFromCSVFile((Listist<SetupCSV>));
//            repository.saveAll(setupCSVList);
//        }catch (IOException e){
//            throw new RuntimeException("fail to store csv data"+e.getMessage());
//        }
//    }
//    public ByteArrayInputStream load (){
//        List<SetupCSV> setupCSVList =repository.findAll();
//
//        ByteArrayInputStream in =  HandymanApplication.readDataFromCSVFile (setupCSVList.addAll());
//        return in;
//    }
//    public List <SetupCSV> getAllData(){
//        return repository.findAll();
//    }
}
