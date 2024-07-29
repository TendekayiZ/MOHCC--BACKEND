package com.example.stndsbackend.stds;

import org.springframework.web.multipart.MultipartFile;

public interface stdService {
    boolean hasCsvFormat(MultipartFile file);

    void processAndSaveData(MultipartFile file);
}
