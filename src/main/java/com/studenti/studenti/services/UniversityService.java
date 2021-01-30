package com.studenti.studenti.services;

import com.studenti.studenti.dto.StudentDto;
import com.studenti.studenti.exceptions.ProfesorNotFoundException;
import com.studenti.studenti.exceptions.StudentNotFoundException;
import com.studenti.studenti.models.Profesor;
import com.studenti.studenti.models.Student;
import com.studenti.studenti.repository.ProfesorRepository;
import com.studenti.studenti.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Struct;
import java.util.List;

@Service
@Slf4j
public class UniversityService {

    private StudentRepository studentRepository;
    private ProfesorRepository profesorRepository;

    @Autowired
    public UniversityService(StudentRepository studentRepository, ProfesorRepository profesorRepository) {
        this.studentRepository = studentRepository;
        this.profesorRepository = profesorRepository;
    }

    public Student findStudentByName(String nume) {
        return this.studentRepository.findByNume(nume).orElseThrow(StudentNotFoundException::new);
    }

    public List<Student> findAllStudents() {
        return this.studentRepository.findAll();
    }

    public List<Profesor> findAllProfs() {
        return this.profesorRepository.findAll();
    }

    public Profesor findProfesorByName(String nume) {
        return this.profesorRepository.findProfesorByNume(nume).orElseThrow(ProfesorNotFoundException::new);
    }

    public Student saveStudent(StudentDto studentDto){
        return this.studentRepository.save(Student.builder()
                .nume(studentDto.getNume())
                .prenume(studentDto.getPrenume())
                .dateOfBirth(studentDto.getDateOfBirth())
                .cnp(studentDto.getCnp())
                .email(studentDto.getEmail())
                .build());
    }
}
