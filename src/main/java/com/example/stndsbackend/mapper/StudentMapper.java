package com.example.stndsbackend.mapper;

import com.example.stndsbackend.dto.RegisterRequest;
import com.example.stndsbackend.entities.Students;

public class StudentMapper  {

    public static RegisterRequest mapToStudentDto(Students students){
        return new RegisterRequest(
                students.getId(),
                students.getUsername(),
                students.getPassword(),
                students.getConfirmPassword()

        );
    }

    public static Students mapToStudents(RegisterRequest registerRequest){

        return new Students(
                registerRequest.getId(),
                registerRequest.getUsername(),
                registerRequest.getPassword(),
                registerRequest.getConfirmPassword()
        );
    }
}
