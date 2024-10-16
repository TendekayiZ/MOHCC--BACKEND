package com.example.stndsbackend.service;

import com.example.stndsbackend.common.response.ResponseData;
import com.example.stndsbackend.entities.Std;
import com.example.stndsbackend.common.response.StdResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

public interface StdService {
//    boolean hasCsvFormat(MultipartFile file);
//    void processAndSaveData(MultipartFile file);
//    List<Std> csvToStds(InputStream inputStream);
    List<StdResponse> findStdsBySymptoms(List<String> symptoms);

    ResponseData<List<Std>> getAllStds();
//    ResponseData<List<Std>> getAllStds();
}
