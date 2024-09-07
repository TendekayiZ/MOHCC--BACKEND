package com.example.stndsbackend.service.impl;

import com.example.stndsbackend.entities.Stds;
import com.example.stndsbackend.repositories.stdRepository;
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
public class stdServiceImpl implements StdService {

    @Autowired
    private stdRepository stdRepository;

    @Override
    public boolean hasCsvFormat(MultipartFile file) {
        String type = "text/csv";
        return type.equals(file.getContentType());
    }

    @Override
    public void processAndSaveData(MultipartFile file) {
        try {

            List<Stds> stds = csvToStds(file.getInputStream());
            stdRepository.saveAll(stds); // Save the list of Stds
        } catch (IOException e) {

            System.err.println("Error processing the CSV file: " + e.getMessage());
        }
    }

    @Override
    public List<Stds> csvToStds(InputStream inputStream) {
        List<Stds> stdsList = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader()
                     .withIgnoreHeaderCase()
                     .withTrim())) {

            for (CSVRecord csvRecord : csvParser) {
                Stds std = new Stds(
                        csvRecord.get("StdName"),
                        csvRecord.get("Symptoms"));
                stdsList.add(std);
            }
            return stdsList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stdsList;
    }


    @Override
    public List<Stds> findStdsBySymptoms(List<String> symptoms) {
        // Ensure at least two symptoms are provided
        if (symptoms.size() < 2) {
            throw new IllegalArgumentException("At least two symptoms must be provided.");
        }

        Set<Stds> stdSet = new HashSet<>();

        for (String symptom : symptoms) {
            List<Stds> stdsList = stdRepository.findBySymptom(symptom);
            for (Stds std : stdsList) {
                List<String> stdSymptoms = std.getSymptomsList();
                // Check if the stdSymptoms contain at least two of the provided symptoms
                long count = stdSymptoms.stream()
                        .filter(symptoms::contains)
                        .count();

                if (count >= 2) {
                    stdSet.add(std); // Add to the set if there are at least two matching symptoms
                }
            }
        }

        return new ArrayList<>(stdSet);
    }}


