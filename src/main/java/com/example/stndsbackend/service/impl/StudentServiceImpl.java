package com.example.stndsbackend.service.impl;

import com.example.stndsbackend.dto.StudentsDto;
import com.example.stndsbackend.entity.Students;
import com.example.stndsbackend.mapper.StudentMapper;
import com.example.stndsbackend.repository.StudentRepository;
import com.example.stndsbackend.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    @Override
    public StudentsDto createStudents(StudentsDto studentsDto) {

        Students students = StudentMapper.mapToStudents(studentsDto);
        Students savedStudents = studentRepository.save(students);
        return StudentMapper.mapToStudentDto (savedStudents);
    }
}
