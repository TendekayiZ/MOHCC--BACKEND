package com.example.stndsbackend.controller;


import com.example.stndsbackend.common.response.ResponseData;
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

    private final StdService stdService;

    @PostMapping("/find")
    public ResponseEntity<ResponseData<List<StdResponse>>> findStdsByMultipleSymptoms(@RequestBody List<String> symptoms) {
        ResponseData<List<StdResponse>> response = new ResponseData<List<StdResponse>>();
        try {
            List<StdResponse> stiResponses = stdService.findStdsBySymptoms(symptoms);
            if (stiResponses.isEmpty()) {
                response.buildFailedResponse("No STIs found for the provided symptoms.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            response.buildSuccessResponse("STIs found successfully", stiResponses);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            response.buildFailedResponse(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}




































