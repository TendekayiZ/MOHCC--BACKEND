package com.example.stndsbackend.mapper;

import com.example.stndsbackend.dto.StudentsDto;
import com.example.stndsbackend.entity.Students;

public class StudentMapper  {
    public static StudentsDto mapToStudentDto(Students students){
        return new StudentsDto(
                students.getId(),
                students.getFirstName(),
                students.getLastName(),
                students.getAge(),
                students.getPassword(),
                students.getEmail()
        );
    }

    public static Students mapToStudents(StudentsDto studentsDto){
        return new Students(
                studentsDto.getId(),
                studentsDto.getFirstName(),
                studentsDto.getLastName(),
                studentsDto.getAge(),
                studentsDto.getPassword(),
                studentsDto.getEmail()
        );
    }
}
