package com.example.stndsbackend.service;

import com.example.stndsbackend.dto.StudentsDto;

import java.util.List;

public interface StudentService {
    StudentsDto createStudents(StudentsDto studentsDto);
    StudentsDto getStudentById(Long studentsId) ;
    List<StudentsDto> getAllStudents();
    StudentsDto updateStudents(Long studentId, StudentsDto updateStudent);
    void deleteStudents(Long studentId);


}
