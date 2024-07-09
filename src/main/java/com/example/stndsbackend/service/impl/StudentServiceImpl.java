package com.example.stndsbackend.service.impl;

import com.example.stndsbackend.LoginResponse;
import com.example.stndsbackend.dto.LoginRequest;
import com.example.stndsbackend.dto.RegisterRequest;
import com.example.stndsbackend.entity.Students;
import com.example.stndsbackend.exception.ResourceNotFoundException;
import com.example.stndsbackend.mapper.StudentMapper;
import com.example.stndsbackend.repository.StudentRepository;
import com.example.stndsbackend.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public RegisterRequest signup(RegisterRequest registerRequest) {
        Students students = StudentMapper.mapToStudents(registerRequest);
        Students savedStudents = studentRepository.save(students);
        return StudentMapper.mapToStudentDto (savedStudents);

    }

    @Override
    public RegisterRequest getStudentById(Long studentsId) {
        return null;
//        Students students = studentRepository.findById(studentsId)
//                .orElseThrow(() ->
//                        new ResourceNotFoundException("Student id does not exist : " + studentsId));
//        return StudentMapper.mapToStudentDto(students);
    }

    @Override
    public List<RegisterRequest> getAllStudents() {
        return null;
//        List<Students> students = studentRepository.findAll();
//        return students.stream().map((student) -> StudentMapper.mapToStudentDto(student))
//                .collect(Collectors.toList());
    }

    @Override
    public RegisterRequest updateStudents(Long studentId, RegisterRequest updateStudent) {
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


    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        String msg = "";
        Students students = studentRepository.findByUsername(loginRequest.getUsername());
        if (students != null) {
            String password = loginRequest.getPassword();
            if (password.equals(students.getPassword())) {
                Optional<Students> studentsOptional = studentRepository.findByUsernameAndPassword(
                        students.getUsername(), students.getPassword());
                if (studentsOptional.isPresent()) {
                    return new LoginResponse("Login Success",true);
                } else {
                    return new LoginResponse("Login Failed",true);
                }
            } else {
                return new LoginResponse("password incorrect", false);
            }
        }return new LoginResponse("username does not exist", false);


    }


}



