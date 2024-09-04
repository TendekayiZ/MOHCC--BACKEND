package com.example.stndsbackend.service;

import com.example.stndsbackend.entities.stds;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

public interface StdService {
    boolean hasCsvFormat(MultipartFile file);

    void processAndSaveData(MultipartFile file);

    List<stds> csvToStds(InputStream inputStream);

    static List<stds> getStdsByName() {
        return null;
    }
}
