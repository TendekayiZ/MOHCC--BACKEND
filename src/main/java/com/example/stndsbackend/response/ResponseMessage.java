package com.example.stndsbackend.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ResponseMessage {
    private String message;
    public ResponseMessage() {

    }
}
