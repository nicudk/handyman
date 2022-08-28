package ro.itschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ro.itschool.CSV.ResponseMessage;
import ro.itschool.CSV.SetupCSV;
import ro.itschool.HandymanApplication;
import ro.itschool.service.impl.SetupCSVServiceImpl;

import java.util.List;

@CrossOrigin("http://localhost:8080")
@Controller
@RequestMapping("/api/csv")
public class SetupCSVController {

    @Autowired
    SetupCSVServiceImpl setupCSVService;

//    @PostMapping("/upload")
//    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
//        String message = " ";
//
//        if (HandymanApplication.readDataFromCSVFile(file)) {
//            try {
//                setupCSVService.save(file);
//                message = "Upload the file successfully:" + file.getOriginalFilename();
//                String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                        .path("/api/csv/download/")
//                        .path(file.getOriginalFilename())
//                        .toUriString();
//
//                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message, fileDownloadUri));
//            } catch (Exception e) {
//                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
//                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message, ""));
//            }
//        }
//
//        message = "Please upload a csv file!";
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message, ""));
//    }
//    @GetMapping("/Handyman")
//    public ResponseEntity<List<SetupCSV>> getAllData() {
//        try {
//            List<SetupCSV> handyman  = setupCSVService.getAllData();
//
//            if (handyman.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//            return new ResponseEntity<>(handyman, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

}





