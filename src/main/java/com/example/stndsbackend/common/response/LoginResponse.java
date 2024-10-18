package com.example.stndsbackend.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class LoginResponse {
 private String  username;
 private Long id;
 private Boolean Status;
}
