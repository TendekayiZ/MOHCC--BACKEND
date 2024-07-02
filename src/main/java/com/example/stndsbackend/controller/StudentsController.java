package com.example.stndsbackend.controller;


import com.example.stndsbackend.dto.StudentsDto;
import com.example.stndsbackend.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentsController {

    private StudentService studentService;

    //Build Add Students Rest API
    @PostMapping
    public ResponseEntity <StudentsDto> createStudents(@RequestBody StudentsDto studentsDto){
         StudentsDto savedStudents = studentService.createStudents(studentsDto);
         return new ResponseEntity<>(savedStudents, HttpStatus.CREATED);
    }


}
