package com.studenti.studenti.services;

import com.studenti.studenti.dto.ProfesorDto;
import com.studenti.studenti.dto.StudentDto;
import com.studenti.studenti.dto.StudentEnrollRequest;
import com.studenti.studenti.exceptions.MaterieNotFoundException;
import com.studenti.studenti.exceptions.ProfesorNotFoundException;
import com.studenti.studenti.exceptions.StudentAlreadyEnrollException;
import com.studenti.studenti.exceptions.StudentNotFoundException;
import com.studenti.studenti.models.Materie;
import com.studenti.studenti.models.Profesor;
import com.studenti.studenti.models.Student;
import com.studenti.studenti.models.StudentiToMaterii;
import com.studenti.studenti.repository.MaterieRepository;
import com.studenti.studenti.repository.ProfesorRepository;
import com.studenti.studenti.repository.StudentRepository;
import com.studenti.studenti.repository.StudentiToMateriiRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UniversityService {

    private StudentRepository studentRepository;
    private ProfesorRepository profesorRepository;
    private MaterieRepository materieRepository;
    private StudentiToMateriiRepository studentiToMateriiRepository;

    @Autowired
    public UniversityService(StudentRepository studentRepository,
                             ProfesorRepository profesorRepository,
                             MaterieRepository materieRepository,
                             StudentiToMateriiRepository studentiToMateriiRepository) {
        this.studentRepository = studentRepository;
        this.profesorRepository = profesorRepository;
        this.materieRepository = materieRepository;
        this.studentiToMateriiRepository = studentiToMateriiRepository;
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

    public Student saveStudent(StudentDto studentDto) {
        return this.studentRepository.save(Student.builder()
                .nume(studentDto.getNume())
                .dateOfBirth(studentDto.getDateOfBirth())
                .cnp(studentDto.getCnp())
                .email(studentDto.getEmail())
                .build());
    }

    public Profesor saveProfesor(ProfesorDto profesorDto) {
        return this.profesorRepository.save(Profesor.builder()
                .nume(profesorDto.getNume())
                .cnp(profesorDto.getCnp())
                .build());
    }

    public void enrollStudentToMaterie(StudentEnrollRequest request) {
        Student existingStudent = studentRepository.findByNume(request.getNumeStudent()).orElseThrow(StudentNotFoundException::new);
        Materie existingMaterie = materieRepository.findByNume(request.getNumeMaterie()).orElseThrow(MaterieNotFoundException::new);

        if (studentiToMateriiRepository.findByStudentAndMaterie(existingStudent, existingMaterie).isPresent()) {
            throw new StudentAlreadyEnrollException("Student already enrolls to a course");
        }
        studentiToMateriiRepository.save(StudentiToMaterii.builder()
                .student(existingStudent)
                .materie(existingMaterie)
                .build());
    }
}