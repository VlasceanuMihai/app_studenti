package com.studenti.studenti.repository;

import com.studenti.studenti.models.Materie;
import com.studenti.studenti.models.Student;
import com.studenti.studenti.models.StudentiToMaterii;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentiToMateriiRepository extends JpaRepository<StudentiToMaterii, Long> {

    @Query(value = "SELECT sm FROM StudentiToMaterii sm WHERE sm.student=:student AND sm.materie=:materie")
    Optional<StudentiToMaterii> findByStudentAndMaterie(@Param("student") Student student, @Param("materie") Materie materie);
}
