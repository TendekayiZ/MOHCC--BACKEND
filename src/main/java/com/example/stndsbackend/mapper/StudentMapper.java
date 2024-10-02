package com.example.stndsbackend.mapper;

import com.example.stndsbackend.dto.RegisterDTO;
import com.example.stndsbackend.entities.Student;

public class StudentMapper  {

    public static RegisterDTO mapToStudentDto(Student student){
        return new RegisterDTO(
                student.getId(),
                student.getUsername(),
                student.getPassword(),
                student.getConfirmPassword()

        );
    }

    public static Student mapToStudents(RegisterDTO registerDTO){

        return new Student(
                registerDTO.getId(),
                registerDTO.getUsername(),
                registerDTO.getPassword(),
                registerDTO.getConfirmPassword()
        );
    }
}
