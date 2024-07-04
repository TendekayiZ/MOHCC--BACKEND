package com.example.stndsbackend.controller;


import com.example.stndsbackend.dto.StudentsDto;
import com.example.stndsbackend.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    //build Get Students
    @GetMapping("{id}")
    public ResponseEntity<StudentsDto> getStudentsById(@PathVariable("id") Long studentsId){
       StudentsDto studentsDto = studentService.getStudentById(studentsId);
       return ResponseEntity.ok(studentsDto);
    }
//    build Get all Students
    @GetMapping
    public ResponseEntity<List<StudentsDto>> getAllStudents(){
        List<StudentsDto> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
    //update Students Rest API
    @PutMapping("{id}")
    public ResponseEntity<StudentsDto> updateStudent(@PathVariable("id") Long studentId,
                                                     @RequestBody StudentsDto updatedStudent){
        StudentsDto studentsDto = studentService.updateStudents(studentId, updatedStudent);
        return ResponseEntity.ok(studentsDto);
    }

//Delete Student restPi
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudents(@PathVariable ("id") Long studentId){
        studentService.deleteStudents(studentId);
        return ResponseEntity.ok("Student Deleted Successfully!");
    }

    }



