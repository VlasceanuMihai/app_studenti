package com.studenti.studenti.controllers;

import com.studenti.studenti.dto.StudentDto;
import com.studenti.studenti.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class StudentController {

    private UniversityService universityService;

    @Autowired
    public StudentController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("/student/{nume}")
    public ResponseEntity<Object> getStudent(@PathVariable("nume") String nume) {
        return ResponseEntity.ok(this.universityService.findStudentByName(nume));
    }

    @GetMapping("/student/all")
    public ResponseEntity<Object> getAllStudents() {
        return ResponseEntity.ok(this.universityService.findAllStudents());
    }

    @GetMapping("/profesor/all")
    public ResponseEntity<Object> getAllProfs() {
        return ResponseEntity.ok(this.universityService.findAllProfs());
    }

    @GetMapping("/profesor/{nume}")
    public ResponseEntity<Object> getProfesor(@PathVariable("nume") String nume) {
        return ResponseEntity.ok(this.universityService.findProfesorByName(nume));
    }

    @PostMapping("/student/save")
    public ResponseEntity<Object> saveStudent(@Valid @RequestBody StudentDto studentDto){
        return ResponseEntity.ok(this.universityService.saveStudent(studentDto));
    }
}
