package com.example.stndsbackend.controller;

import com.example.stndsbackend.entities.stds;
import com.example.stndsbackend.response.ResponseMessage;
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
public class stdsController {

    @Autowired
    StdService service;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        if(service.hasCsvFormat(file)){
            service.processAndSaveData(file);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage("Successfully uploaded file" + file.getOriginalFilename()));
        }
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("File format not supported"));
    }

    @GetMapping("/Symptoms")
    List<stds> getByName() {
        return StdService.getStdsByName();

    }
}
