package com.studenti.studenti.repository;

import com.studenti.studenti.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT s FROM Student s WHERE s.nume = :nume")
    Optional<Student> findByNume(@Param("nume") String nume);
}
