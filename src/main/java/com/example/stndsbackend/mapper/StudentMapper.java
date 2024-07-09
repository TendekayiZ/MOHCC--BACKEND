package com.example.stndsbackend.mapper;

import com.example.stndsbackend.dto.RegisterRequest;
import com.example.stndsbackend.entity.Students;

public class StudentMapper  {

    public static RegisterRequest mapToStudentDto(Students students){
        return new RegisterRequest(
                students.getId(),
                students.getFirstName(),
                students.getLastName(),
                students.getUsername(),
                students.getPassword(),
                students.getConfirmPassword(),
                students.getAge(),
                students.getGender(),
                students.getEmail(),
                students.getLocation()

        );
    }

    public static Students mapToStudents(RegisterRequest registerRequest){

        return new Students(
                registerRequest.getId(),
                registerRequest.getFirstName(),
                registerRequest.getLastName(),
                registerRequest.getUsername(),
                registerRequest.getPassword(),
                registerRequest.getConfirmPassword(),
                registerRequest.getAge(),
                registerRequest.getGender(),
                registerRequest.getEmail(),
                registerRequest.getLocation()
        );
    }
}
