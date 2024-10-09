package com.example.stndsbackend.controller;


import com.example.stndsbackend.common.response.ResponseMessage;
import com.example.stndsbackend.common.response.StdResponse;
import com.example.stndsbackend.service.StdService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/stds")
@CrossOrigin(origins = "http://localhost:4200")
public class StdController {

    @Autowired
    private StdService stdService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        if (stdService.hasCsvFormat(file)) {
            stdService.processAndSaveData(file);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage("Successfully uploaded file" + file.getOriginalFilename()));
        }
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("File format not supported"));
    }


    @PostMapping("/find")
    public ResponseEntity<?> findStdsByMultipleSymptoms(@RequestBody List<String> symptoms) {
        try {
            // Change the type to List<StiResponse>
            List<StdResponse> stiResponses = stdService.findStdsBySymptoms(symptoms);
            if (stiResponses.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No STIs found for the provided symptoms.");
            }
            return ResponseEntity.ok(stiResponses); // Return the list of StiResponse
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}





































