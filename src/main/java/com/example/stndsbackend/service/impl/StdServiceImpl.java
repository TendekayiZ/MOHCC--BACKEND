package com.example.stndsbackend.service.impl;

import com.example.stndsbackend.common.response.ResponseData;
import com.example.stndsbackend.entities.Std;
import com.example.stndsbackend.repositories.StdRepository;
import com.example.stndsbackend.common.response.StdResponse;
import com.example.stndsbackend.service.StdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StdServiceImpl implements StdService {

    @Autowired
    private StdRepository stdRepository;

    @Override
    public List<StdResponse> findStdsBySymptoms(List<String> symptoms) {
        if (symptoms.size() < 2) {
            throw new IllegalArgumentException("At least two symptoms must be provided.");
        }

        Set<Std> stdSet = new HashSet<>();

        for (String symptom : symptoms) {
            List<Std> stdList = stdRepository.findBySymptom(symptom);
            for (Std std : stdList) {
                List<String> stdSymptoms = std.getSymptomsList();
                long count = stdSymptoms.stream()
                        .filter(symptoms::contains)
                        .count();

                if (count >= 2) {
                    stdSet.add(std);
                }
            }
        }

        // Transform the Set<Stds> to List<StiResponse>
        List<StdResponse> responseList = new ArrayList<>();
        for (Std std : stdSet) {
            responseList.add(new StdResponse(std.getName(), String.join(",", std.getSymptomsList())));
        }

        return responseList;
    }

    @Override
    public ResponseData<List<Std>> getAllStds() {
        List<Std> all = stdRepository.findAll();

        if (all.isEmpty()){
            return new ResponseData<List<Std>>().buildFailedResponse("No Stds");
        }
        return new ResponseData<List<Std>>().buildSuccessResponse("Stds found ", all);
    }

}


