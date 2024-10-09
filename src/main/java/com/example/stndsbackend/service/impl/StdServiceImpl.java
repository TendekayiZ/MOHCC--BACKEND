package com.example.stndsbackend.service.impl;

import com.example.stndsbackend.entities.Std;
import com.example.stndsbackend.repositories.StdRepository;
import com.example.stndsbackend.common.response.StdResponse;
import com.example.stndsbackend.service.StdService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StdServiceImpl implements StdService {

    @Autowired
    private StdRepository stdRepository;

    @Override
    public boolean hasCsvFormat(MultipartFile file) {
        String type = "text/csv";
        return type.equals(file.getContentType());
    }

    @Override
    public void processAndSaveData(MultipartFile file) {
        try {

            List<Std> stds = csvToStds(file.getInputStream());
            stdRepository.saveAll(stds);
        } catch (IOException e) {

            System.err.println("Error processing the CSV file: " + e.getMessage());
        }
    }

    @Override
    public List<Std> csvToStds(InputStream inputStream) {
        List<Std> stdList = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader()
                     .withIgnoreHeaderCase()
                     .withTrim())) {

            for (CSVRecord csvRecord : csvParser) {
                Std std = new Std(
                        csvRecord.get("Name"),
                        csvRecord.get("Symptoms"));
                stdList.add(std);
            }
            return stdList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stdList;
    }


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

     }


