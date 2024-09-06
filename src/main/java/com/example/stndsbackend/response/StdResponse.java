package com.example.stndsbackend.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class StdResponse {
    private String message; // This should be a String
    private boolean success;

}
