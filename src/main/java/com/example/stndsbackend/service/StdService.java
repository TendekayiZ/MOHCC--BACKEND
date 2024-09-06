package com.example.stndsbackend.service;

import com.example.stndsbackend.dto.StdRequest;
import com.example.stndsbackend.entities.Stds;
import com.example.stndsbackend.response.StdResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public interface StdService {
    boolean hasCsvFormat(MultipartFile file);
    void processAndSaveData(MultipartFile file);
    List<Stds> csvToStds(InputStream inputStream);

    StdResponse findBySymptoms(StdRequest stdRequest);

    Optional<Stds> getStdBySymptoms(String symptoms);

    StdResponse getStdBySymptoms(StdRequest stdRequest);
}
