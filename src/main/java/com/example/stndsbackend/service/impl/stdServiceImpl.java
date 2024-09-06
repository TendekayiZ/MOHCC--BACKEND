package com.example.stndsbackend.service.impl;

import com.example.stndsbackend.dto.StdRequest;
import com.example.stndsbackend.entities.Stds;
import com.example.stndsbackend.repositories.stdRepository;
import com.example.stndsbackend.response.StdResponse;
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
import java.util.List;
import java.util.Optional;

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
            // Convert CSV file to a list of Stds objects
            List<Stds> stds = csvToStds(file.getInputStream());
            stdRepository.saveAll(stds); // Save the list of Stds
        } catch (IOException e) {
            // Log the error instead of printing the stack trace
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
                stdsList.add(std); // Add std to the list
            }
            return stdsList; // Return the populated list
        } catch (IOException e) {
            e.printStackTrace(); // Consider using a logging framework for production
        }
        return stdsList; // Return the list even in case of an exception
    }

    @Override
    public StdResponse findBySymptomsIgnoreCase(StdRequest stdRequest) {
        // This method is currently unimplemented. Consider implementing or removing it.
        return null;
    }

    @Override
    public StdResponse getStdBySymptomsIgnoreCase(StdRequest stdRequest) {
        String symptoms = stdRequest.getSymptoms();
        Optional<Stds> stdsOptional = stdRepository.findBySymptomsIgnoreCase(symptoms);

        if (stdsOptional.isPresent()) {
            Stds stds = stdsOptional.get();
            return new StdResponse("According to the symptoms to selected: " + stds.getSymptoms() +
                    ". We are suspecting its  : " + stds.getName(), true);
        } else {
            return new StdResponse("Sorry, please select again", false);
        }
    }

    @Override
    public Optional<Stds> getStdBySymptomsIgnoreCase(String symptoms) {
        // This method may be redundant as it's similar to the above method
        return stdRepository.findBySymptomsIgnoreCase(symptoms);
    }
}

