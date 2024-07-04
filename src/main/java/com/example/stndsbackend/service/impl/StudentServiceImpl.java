package com.example.stndsbackend.service.impl;

import com.example.stndsbackend.dto.StudentsDto;
import com.example.stndsbackend.entity.Students;
import com.example.stndsbackend.exception.ResourceNotFoundException;
import com.example.stndsbackend.mapper.StudentMapper;
import com.example.stndsbackend.repository.StudentRepository;
import com.example.stndsbackend.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public StudentsDto getStudentById(Long studentsId) {
        Students students = studentRepository.findById(studentsId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student id does not exist : " + studentsId));
        return StudentMapper.mapToStudentDto(students);
    }

    @Override
    public List<StudentsDto> getAllStudents() {
        List<Students> students = studentRepository.findAll();
        return students.stream().map((student) -> StudentMapper.mapToStudentDto(student))
                .collect(Collectors.toList());
    }

    @Override
    public StudentsDto updateStudents(Long studentId, StudentsDto updateStudent) {
        Students students = studentRepository.findById(studentId).orElseThrow(
                () -> new ResourceNotFoundException ("Student does not exist with given id" + studentId)
        );
        students.setFirstName(updateStudent.getFirstName());
        students.setLastName(updateStudent.getLastName());
        students.setAge(updateStudent.getAge());
        students.setPassword(updateStudent.getPassword());
        students.setEmail(updateStudent.getEmail());

        Students updatedStudentObj = studentRepository.save(students);
        return StudentMapper.mapToStudentDto(updatedStudentObj);
    }

    @Override
    public void deleteStudents(Long studentId) {
        Students students = studentRepository.findById(studentId).orElseThrow(
                () -> new ResourceNotFoundException ("Student does not exist with given id" + studentId)
        );
        studentRepository.deleteById(studentId);

    }

}

