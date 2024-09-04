package com.example.stndsbackend.service.impl;

import com.example.stndsbackend.entities.stds;
import com.example.stndsbackend.repositories.stdRepository;
import com.example.stndsbackend.service.StdService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class stdServiceImpl implements StdService {

    @Autowired
    private stdRepository repository;

    Specification<stds> getSpecification(){
        return(root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("stdName"), "gonorrhoea");
        };

    }
    public List<stds> getStdsByName(){
       Specification<stds> specification = getSpecification();
       return repository.findAll(specification);
    }

    @Override
    public boolean hasCsvFormat(MultipartFile file) {
        String type = "text/csv";
        if (!type.equals(file.getContentType()))
            return false;
        return true;
    }

    @Override
    public void processAndSaveData(MultipartFile file) {
        try {


            List<stds> stds = csvToStds(file.getInputStream());
    repository.saveAll(stds);
        } catch (IOException e) {
            e.printStackTrace();

        }


    }

    @Override
    public List<stds> csvToStds(InputStream inputStream) {
        List<stds> stds = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.Builder.create()
                     .build().withFirstRecordAsHeader()
                     .withIgnoreHeaderCase()
                     .withTrim())) {
            for (CSVRecord csvRecord : csvParser) {
                stds std = new stds(
                        csvRecord.get("StdName"),
                        csvRecord.get("Symptoms"));
                stds.add(std);
            }
            return stds;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stds;
    }

}
