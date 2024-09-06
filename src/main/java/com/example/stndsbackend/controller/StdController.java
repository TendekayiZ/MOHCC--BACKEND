package com.example.stndsbackend.controller;

import com.example.stndsbackend.dto.StdRequest;
import com.example.stndsbackend.entities.Stds;
import com.example.stndsbackend.response.ResponseMessage;
import com.example.stndsbackend.response.StdResponse;
import com.example.stndsbackend.service.StdService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/stds")
@CrossOrigin(origins = "http://localhost:4200")
public class StdController {

    @Autowired
    private StdService stdService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        if(stdService.hasCsvFormat(file)){
            stdService.processAndSaveData(file);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage("Successfully uploaded file" + file.getOriginalFilename()));
        }
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("File format not supported"));
    }


        @PostMapping("/getBySymptom")
        public ResponseEntity<StdResponse> findBySymptomsIgnoreCase(@RequestBody StdRequest stdRequest) {
            StdResponse stdResponse = stdService.findBySymptomsIgnoreCase(stdRequest);
            return ResponseEntity.ok(stdResponse);
        }



    @PostMapping("/find")
    public StdResponse findStdBySymptoms(@RequestBody StdRequest stdRequest) {
        return stdService.getStdBySymptomsIgnoreCase(stdRequest); // Correct usage
    }
}




