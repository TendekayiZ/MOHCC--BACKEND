package com.example.stndsbackend.service;

import com.example.stndsbackend.entities.Stds;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

public interface StdService {
    boolean hasCsvFormat(MultipartFile file);
    void processAndSaveData(MultipartFile file);
    List<Stds> csvToStds(InputStream inputStream);
    List<Stds> findStdsBySymptoms(List<String> symptoms);
}
